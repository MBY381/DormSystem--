package com.xjtu.dormitory.user.getDomInfostu;


import com.xjtu.dormitory.common.CommonService;
import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.common.Result;
import com.xjtu.dormitory.common.TokenUtils;
import com.xjtu.dormitory.user.repairer.RapairDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/securitystu/getInfo")
public class GetInfAPIstu {


    @Resource
    private GetInfoServicestu getInfoService;
    @Resource
    private CommonService commonService;

    @GetMapping("")
    public Result InfoList(@RequestHeader("Token") String token){
        CurrentUser currentUser = TokenUtils.getUserInfo(token,commonService);
        RapairDto ddd=new RapairDto();
        ddd.setU_sex(getInfoService.getusex(currentUser.getUserId()));
        ddd.setDorm_id(getInfoService.getdormid(currentUser.getUserId()));
        Map<String,Object> page = getInfoService.getInfoList(ddd);
        return Result.success(page);
    }
}
