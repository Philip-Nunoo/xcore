/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.configuration;

import com.union.corelogger.RequestLog;
import envtest.model.ApiClient;
import envtest.proc.ApiClientCall;
import io.swagger.Config;
import io.swagger.Helper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 */
@Component
public class RequestInterceptor implements HandlerInterceptor {
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
        String serverIp = request.getRemoteAddr();
        String requestUri = request.getRequestURI();
        String requestUrl = request.getRequestURL().toString();
        String method = request.getMethod();
        
        System.out.println(request.getLocalPort());
        
//        ApiClientCall apiClientCall = new ApiClientCall();
//        ApiClient apiClient = apiClientCall.ApiClientCheck(apiKey, apiSecret, serverIp);
        
        if (requestUri.contains("swagger-ui")) { // allow swagger request
            return true;
        } else {
            // Change port
            String directoryPath = (Config.SERVER_DEV_PORT == request.getLocalPort()) ? 
                    "C://xcore-dev/requests/" : 
                    "C://xcore/requests/";
            
            String fileName = directoryPath + "request." + com.union.corelogger.Helper.currentDateTime("yyyy-MM-dd") + ".csv";
            System.out.format("REQ %s >> ~ (%s) %s%s%n", method, Helper.currentDateTime(), serverIp, requestUrl);
            
            // RequestLog.request(fileName, serverIp, "TODO", method, requestUrl, "TODO - body");
        }
        return true;
        
        
//        return true;
        
//        
//        if (apiClient != null) {
//            if(requestUri.contains("user") && apiClient.getUser_endpt().equals("Y")){
//                return true;
//            }
//            if(requestUri.contains("account") && apiClient.getAcct_endpt().equals("Y")){
//                return true;
//            }
//            if(requestUri.contains("customer") && apiClient.getCust_endpt().equals("Y")){
//                return true;
//            }
//            if(requestUri.contains("request") && apiClient.getRqst_endpt().equals("Y")){
//                return true;
//            }
//            System.out.println("Invalid requested resource.");
//            return false;
//        } else {
//            // TODO: Log unauthorized attempt and IP
//            System.out.println("Could not find the requested server.");
//            return false;
//        }
    }
}