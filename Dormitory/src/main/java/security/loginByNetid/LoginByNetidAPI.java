package com.xjtu.dormitory.security.loginByNetid;


import com.xjtu.dormitory.common.Result;
import com.xjtu.dormitory.common.TokenUtils;
import com.xjtu.dormitory.security.loginByNetid.impl.LoginByNetidServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/security/loginByNetid")
public class LoginByNetidAPI {

    @Resource
    private LoginByNetidServiceImpl loginByNetidServiceService;


    @PostMapping("")
    public Result Login(@RequestBody LoginByNetidDto dto){

        boolean ok = loginByNetidServiceService.CheckLoginByNetID(dto);

        System.out.println("111");

        if(ok){
            String role_web = loginByNetidServiceService.findRoleWeb(dto);

            String UserId = loginByNetidServiceService.getUserId(dto);

            System.out.println(UserId);

            String token = TokenUtils.loginSign(UserId,dto.getU_pwd());

            return Result.success(role_web,(Object)token);// send success msg and token
        }

        return Result.fail(Result.ERR_CODE_BUSINESS,"netid不存在或者netid或密码错误！！！");


    }
}
