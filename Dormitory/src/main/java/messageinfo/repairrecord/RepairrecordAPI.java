package com.xjtu.dormitory.messageinfo.repairrecord;


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
@RequestMapping("/messageinfo/repairrecord")
public
class RepairrecordAPI {

    @GetMapping(" ")
    public
    Result repairrecordList(@RequestHeader("Token") String token){
        CurrentUser currentUser = TokenUtils.getUserInfo(token,commonService);
        Map<String,Object>page=repairrecordService.getRepairrecordList(currentUser);
        return Result.success(page);
    }


    @Resource
    private RepairrecordService repairrecordService;
    @Resource
    private CommonService commonService;


}
