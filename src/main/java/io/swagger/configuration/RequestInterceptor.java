/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.configuration;

import com.union.corelogger.RequestLog;
import envtest.Helpers;
import envtest.model.ApiClient;
import envtest.proc.ApiClientCall;
import io.swagger.Config;
import io.swagger.Helper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 */
@Component
public class RequestInterceptor implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception exception) throws Exception {
        String serverIp = request.getRemoteAddr();
        String requestUri = request.getRequestURI();
        System.out.format("RES %s >> ~ %s%s (%s) %n", Helper.currentDateTime(), serverIp, requestUri, response.getStatus());
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
//        System.out.println("postHandle");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
        String apiKey = request.getHeader("x-api-key");
        String apiSecret = request.getHeader("x-api-secret");
        String ip = request.getHeader("X-FORWARDED-FOR");
        String ipAddr = (ip == null) ? getRemoteAddr(request) : ip;
        String requestUri = request.getRequestURI();
        String requestUrl = request.getRequestURL().toString();
        String method = request.getMethod();

        System.out.println("requestUri " + requestUri.substring(0));
        
        String[] apiResource = requestUri.replace("/core/api/v1.0/", "").split("/");
        
        if (requestUri.contains("swagger") || requestUri.contains("api-docs")) { // allow swagger request
            return true;
        } else {            
            ApiClientCall apiClientCall = new ApiClientCall();
            ApiClient apiClient = apiClientCall.ApiClientCheck(apiKey, apiSecret, ipAddr);

            // Change port
            String directoryPath = (Config.SERVER_DEV_PORT == request.getLocalPort())
                    ? "C://xcore-dev/requests/"
                    : "C://xcore/requests/";
            directoryPath = Helpers.isUnix() ? "/opt/api/logs/requests/" : directoryPath;

            String fileName = directoryPath + "request." + com.union.corelogger.Helper.currentDateTime("yyyy-MM-dd") + ".csv";
            System.out.format("REQ %s >> ~ (%s) %s %s %n", method, Helper.currentDateTime(), ipAddr, requestUrl);
            
            String resource = (apiResource.length > 0) ? apiResource[0] : "Unidentified Resource";
            
            if (apiClient != null) {
                String nameOfClient = apiClient.getApiRqstrnme();
                RequestLog.request(fileName, ipAddr, nameOfClient, method, requestUrl, resource, requestUri.replace("/core/api/v1.0/", ""));
                
                request.setAttribute("terminal", apiClient.getTerminal());
                
                if (requestUri.contains("user") && apiClient.getUser_endpt().equals("Y")) {
                    return true;
                }
                if (requestUri.contains("account") && apiClient.getAcct_endpt().equals("Y")) {
                    return true;
                }
                if (requestUri.contains("customer") && apiClient.getCust_endpt().equals("Y")) {
                    return true;
                }
                if (requestUri.contains("request") && apiClient.getRqst_endpt().equals("Y")) {
                    return true;
                }
                
                if (requestUri.contains("error")) {
                    return true;
                }
                System.out.println("Invalid requested resource. " + requestUri + " : " + apiClient.getRqst_endpt());
                return false;
            } else {
                // TODO: Log unauthorized attempt and IP
                System.out.println("Could not find the requested server.");
                RequestLog.request(fileName, ipAddr, "Unknown Client", method, requestUrl, resource, requestUri.replace("/core/api/v1.0/", ""));
                return false;
            }

        }

    }

    private String getRemoteAddr(HttpServletRequest request) {
        String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
        if (ipFromHeader != null && ipFromHeader.length() > 0) {
            log.debug("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
            return ipFromHeader;
        }
        return request.getRemoteAddr();
    }
}
