package com.xvshu.zk.manager.web;

import com.xvshu.zk.manager.util.ConfigUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by xvshu on 2016/10/10.
 */
@Controller
@RequestMapping("/lg")
public class LoginController {

    @RequestMapping(value="/up")
    public @ResponseBody
    Boolean query(
            @RequestParam(required=false) String username,
            @RequestParam(required=false) String password,
            HttpSession session
    ){
        boolean returnval = false;
        if(username!=null && password!=null && username.equals(ConfigUtil.getConfigMessage("userquery")) && password.equals(ConfigUtil.getConfigMessage("passquery"))){
            returnval=true;
            session.setAttribute("userP",true);
            session.setAttribute("userM",false);
        }else if(username!=null && password!=null && username.equals(ConfigUtil.getConfigMessage("useradmin")) && password.equals(ConfigUtil.getConfigMessage("passadmin"))){
            returnval=true;
            session.setAttribute("userP",true);
            session.setAttribute("userM",true);
        }
        return returnval ;
    }

    @RequestMapping(value="/out")
    public @ResponseBody
    void logout(
            HttpSession session
    ){
        session.removeAttribute("userP");
        session.removeAttribute("userM");
    }

}
