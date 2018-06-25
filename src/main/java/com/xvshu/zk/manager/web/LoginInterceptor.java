package com.xvshu.zk.manager.web;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 登陆拦截器.
 *
 * @author xvshu
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final String[] IGNORE_URI = {"/login.jsp", "/login","/lg/up","css","img","js"};

    private static final String[] ModifyUrl={"add","update","del","save","create"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        boolean loginurl = false;
        String url = request.getRequestURL().toString();
        System.out.println(">>>: " + url);
        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                loginurl = true;
                break;
            }
        }
        if (!flag) {
            Boolean user = (Boolean)request.getSession().getAttribute("userP");
            flag = user==null?false:user;
        }
        if(!flag){
            response.sendRedirect("/login");
        }

        if(flag&&!loginurl){
            Boolean  blmodify = (Boolean)request.getSession().getAttribute("userM");
            if(!blmodify){
                for(String oneurl:ModifyUrl){
                    if(url.indexOf(oneurl)>=0){
                        out(response,ResultCode.AUTH_FAIL);
                        return false;
                    }
                }
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object arg2, ModelAndView arg3) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3) throws Exception {
    }

    /**
     * 返回输出json
     *
     * @param response
     * @param resultCode
     */
    private static final void out(HttpServletResponse response, ResultCode resultCode) {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(objectMapper.writeValueAsString(resultFail(resultCode)));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 错误信息
     *
     * @param resultCode
     * @return
     */
    private static final Map<String, Object> resultFail(ResultCode resultCode) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", resultCode.getCode());
        map.put("msg", resultCode.getMessage());
        return map;
    }
}
