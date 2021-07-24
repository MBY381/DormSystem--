package com.xjtu.dormitory.messageinfo.changerecord;

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
@RequestMapping("/messageinfo/changerecord")
public
class ChangerecordAPI {

    @Resource
    private ChangerecordService changerecordService;

    @Resource
    private CommonService commonService;

    @GetMapping(" ")
    public
    Result changerecordList ( @RequestHeader("Token") String token){
        CurrentUser currentUser = TokenUtils.getUserInfo(token,commonService);
        Map<String,Object> page =changerecordService.getChangerecordList(currentUser);
        return Result.success(page);
    }
}
