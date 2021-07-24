package com.xjtu.dormitory.security.getDomInfo;


import com.xjtu.dormitory.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/security/getInfo")
public class getInfAPI {


    @Resource
    private GetInfoService getInfoService;


    @GetMapping("")
    public Result InfoList(InfoDto dto){
        Map<String,Object> page = getInfoService.getInfoList(dto);

        return Result.success(page);
    }
}
