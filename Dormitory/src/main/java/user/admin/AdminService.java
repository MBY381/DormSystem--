package com.xjtu.dormitory.user.admin;

import java.util.Map;

public interface AdminService {
    Map<String, Object> getRoleList(AdminDto dto);

    void deleteRole(String id);
}
