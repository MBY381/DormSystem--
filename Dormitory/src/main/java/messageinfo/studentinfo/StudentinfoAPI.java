package com.xjtu.dormitory.messageinfo.studentinfo;


import com.xjtu.dormitory.common.CommonService;
import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.common.Result;
import com.xjtu.dormitory.common.TokenUtils;
import com.xjtu.dormitory.common.model.User.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;


@RestController
@RequestMapping("/messageinfo/studentinfo")
public
class StudentinfoAPI {

    @GetMapping(" ")
    public Result studentinfoList(@RequestHeader("Token") String token){
        CurrentUser currentUser = TokenUtils.getUserInfo(token,commonService);
         Map<String,Object> page = studentinfoService.getStudentinfoList(currentUser);
         return Result.success(page);
    }


    @Resource
    private StudentinfoService studentinfoService;


    @Resource
    private CommonService commonService;


}
