package io.swagger.api;

import envtest.proc.UserCall;
import io.swagger.model.User;

import io.swagger.annotations.*;
import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.logging.Level;
import java.util.logging.Logger;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-10T09:55:07.361Z")

@Controller
public class UserApiController implements UserApi {


    @Override
    public ResponseEntity<User> userLoginPost(@ApiParam(value = "Username of x100 user", required=true) @RequestParam(value="username", required=true)  String username,
        @ApiParam(value = "Username of x100 user", required=true) @RequestParam(value="password", required=true)  String password) {
        // do some magic!
        UserCall userCall;
        
        ResponseEntity<User> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        try {
            userCall = new UserCall();
            envtest.model.User envUser = userCall.login(username, password);
            
            if (envUser!= null) {
                User user = new User();
                user.setAc(envUser.getGlobal_AC());
                user.setBranch(envUser.getGlobal_bra());
                user.setDepartment(envUser.getGlobal_department());
                user.setEmployeeId(envUser.getGlobal_emp_id());
                user.setHostname(envUser.getGlobal_hostname());
                user.setMachineIp(envUser.getGlobal_machineip());
                user.setSessionId(envUser.getGlobal_SESSID());
                user.setSubBranch(envUser.getGlobal_sub_bra());
                user.setTransEnq(envUser.getGlobal_transenq());
                user.setUsername(envUser.getGlobal_username());
                user.setMessage(envUser.getMess());
                user.setFullName(envUser.getFNAME());
                user.setBrDesc(envUser.getBR_DESC());
                user.setLoginCode(envUser.getLoginCode());
                user.setPostDate(envUser.getPD());
                response = new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                System.out.println("null 023");
            }
            
        } catch (SQLException ex) {
            System.err.println("Sql exception");
            Logger.getLogger(UserApiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }

}
