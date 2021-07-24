package com.xjtu.dormitory.security.complete;


import com.xjtu.dormitory.common.CommonService;
import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.common.Result;
import com.xjtu.dormitory.common.TokenUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/security/complete")
public class getDormitory {

    @Resource
    private DormitoryService dormitoryService;

    @GetMapping("")
    public Result dormitoryList(dormitoryDto dto){
        Map<String,Object> page = dormitoryService.getDormitoryList(dto);

        return Result.success(page);
    }
}
