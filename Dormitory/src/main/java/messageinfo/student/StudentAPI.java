package com.xjtu.dormitory.messageinfo.student;

import com.xjtu.dormitory.common.CommonService;
import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.common.Result;
import com.xjtu.dormitory.common.TokenUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/messageinfo/student")
public
class StudentAPI {
    @Resource
    private StudentService studentService;

    @Resource
    private CommonService commonService;

    @GetMapping(" ")
    public Result studentList(@RequestHeader("Token") String token){
        CurrentUser currentUser = TokenUtils.getUserInfo(token,commonService);
        Map<String,Object> page =studentService.getStudentList(currentUser);
        return Result.success(page);
    }


}
