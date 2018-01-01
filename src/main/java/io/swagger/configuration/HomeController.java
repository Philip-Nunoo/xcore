package io.swagger.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home redirection to swagger api documentation 
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String index() {
        System.out.println("swagger-ui.html");
        return "redirect:swagger-ui.html";
    }
    
    @RequestMapping(value = "/status")
    public ResponseEntity<ServerState> status() {
        System.out.println("swagger-ui.html");
        
        
        return new ResponseEntity<>(new ServerState("up"), HttpStatus.OK);
    }

    private static class ServerState {

        private String message;

        public ServerState(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
        
        public void setMessage(String message) {
            this.message = message;
        }
    }
}
