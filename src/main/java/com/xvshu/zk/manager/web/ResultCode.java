package com.xvshu.zk.manager.web;

public enum  ResultCode {

    AUTH_FAIL("AUTH_FAIL","您没有权限操作此url");

    private ResultCode(String in_code,String in_mes){
        this.code=in_code;
        this.message=in_mes;
    }

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
