package com.xjtu.dormitory.user.adminStu;


import com.xjtu.dormitory.common.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/user/adminStu")
public class AdminStuAPI {

    @Resource
    private AdminStuService adminStuService;

    @GetMapping("")
    public Result userList(UsersDto dto){

        Map<String,Object> page =  adminStuService.getUserList(dto);
        return Result.success(page);
    }

    @PostMapping("")
    public Result studentUpd(@RequestBody UsersDto dto){
        try{
            adminStuService.updStudent(dto);
            System.out.println("正在修改密码");
            return Result.success();
        }catch(Exception e) {
           e.printStackTrace();
        }
        return Result.fail(400,"系统错误！");
    }


}
