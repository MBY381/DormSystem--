package com.xjtu.dormitory.security.register;


import com.xjtu.dormitory.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/security/register")
public class RegisterAPI {

    @Resource
    private RegisterService registerService;

    @PostMapping("")
    public Result register(@RequestBody RegisterDto dto){
        boolean insert = false;
        boolean exist = registerService.findWorkerId(dto);

        if(!exist){
            return Result.fail(Result.ERR_CODE_BUSINESS,"职工号不存在，请重新检查");
        }else{
            insert = registerService.insertUser(dto);
        }
        if(insert){
            return Result.success("注册成功！！！");
        }else {
            return Result.fail(Result.ERR_CODE_BUSINESS,"职工号重复");
        }
    }
}
