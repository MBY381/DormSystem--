package com.xjtu.dormitory.security.loginByNetid;

public interface LoginService {
    boolean CheckLoginByNetID(LoginByNetidDto dto);

    String findRoleWeb(LoginByNetidDto dto);

    String getUserId(LoginByNetidDto dto);
}
