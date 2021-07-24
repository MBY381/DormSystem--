package com.xjtu.dormitory.messageinfo.allinfo;

import com.xjtu.dormitory.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/messageinfo/allinfo")
public
class AllinfoAPI {
    @Resource
    private AllinfoService allinfoService;

    @GetMapping(" ")
    public Result allinfoList(Allinfodto dto) {

        Map<String, Object> page = allinfoService.getAllInfoList(dto);
        return Result.success(page);
    }
}
