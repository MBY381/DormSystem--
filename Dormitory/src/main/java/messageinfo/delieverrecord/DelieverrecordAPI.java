package com.xjtu.dormitory.messageinfo.delieverrecord;



import com.xjtu.dormitory.common.CommonService;
import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.common.Result;
import com.xjtu.dormitory.common.TokenUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/messageinfo/delieverrecord")
public
class DelieverrecordAPI {

    @GetMapping(" ")
    public Result delieverrecordList( @RequestHeader("Token") String token){
        CurrentUser currentUser = TokenUtils.getUserInfo(token,commonService);
        Map<String,Object> page = delieverrecordService.getDelieverrecordList(currentUser);
        return Result.success(page);
    }


    @Resource
    private DelieverrecordService delieverrecordService;
    @Resource
    private CommonService commonService;

}
