package com.xjtu.dormitory.security.register;

public class RegisterDto {

    private String u_id;
    private String u_pwd;
    private String u_pwd2;
    private String role_id;
    private String temp;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public String getU_pwd2() {
        return u_pwd2;
    }

    public void setU_pwd2(String u_pwd2) {
        this.u_pwd2 = u_pwd2;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
