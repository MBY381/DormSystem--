package com.xjtu.dormitory.security.completeInfo;


import com.xjtu.dormitory.common.CommonService;
import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.common.Result;
import com.xjtu.dormitory.common.TokenUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/security/completeInfo")
public class CompleteInfoAPI {

    @Resource
    private CommonService commonService;

    @Resource
    private CompleteInfoService completeInfoService;

    @PostMapping("")
    public Result CompleteInfo(@RequestBody UserDto dto,@RequestHeader("Token") String token){

        CurrentUser currentUser = TokenUtils.getUserInfo(token,commonService);
        String u_id = currentUser.getUserId();

        System.out.println(u_id);

        boolean opr1 = completeInfoService.updateUserInfo(dto,u_id);

        Integer recordId = completeInfoService.getRecordId();

        System.out.println(recordId);

        boolean opr2 = completeInfoService.offerChangeDorm(dto,u_id,recordId);

        System.out.println(opr1);
        System.out.println(opr2);

        if(opr1 && opr2){
            return Result.success("新生登录完成，等待楼管审核宿舍！！！");
        }else {
            return Result.fail(Result.ERR_CODE_SYS,"系统维护中！！！");
        }
    }

}
