package com.xjtu.dormitory.security.register;

public interface RegisterService {
    boolean findWorkerId(RegisterDto dto);

    boolean insertUser(RegisterDto dto);
}
