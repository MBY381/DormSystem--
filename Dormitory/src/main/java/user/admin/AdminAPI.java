package com.xjtu.dormitory.user.admin;


import com.xjtu.dormitory.common.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/user/admin")
public class AdminAPI {
    @Resource
    private AdminService adminService;


    @GetMapping("")
    public Result roleList(AdminDto dto){

        Map<String,Object> page =  adminService.getRoleList(dto);
        return Result.success(page);
    }

    @Resource
    private RecordService recordService;

    @Resource
    private AgreeService agreeService;

    @Resource
    private DisagreeSerivce disagreeSerivce;

    @GetMapping("/getChangeRecord")
    public Result recordList(reacordDto dto){
        Map<String,Object> page = recordService.getRecordList(dto);

        return Result.success(page);
    }

    @PostMapping("/agreeChange")
    public Result agreeChange(@RequestBody reacordDto dto){
        boolean ok1 = agreeService.deleteNum(dto);
        boolean ok2 = agreeService.plusNum(dto);
        boolean ok3 = agreeService.changeDorm(dto);
        boolean ok4 = agreeService.changeStatus(dto);

        if(ok1 && ok2 && ok3 && ok4){
            return Result.success("操作成功！！！");
        }else {
            return Result.fail(Result.ERR_CODE_SYS,"系统升级中！！！！");
        }
    }
    @PostMapping("/disagreeChange")
    public Result disagreeChange(@RequestBody reacordDto dto){
        boolean ok = disagreeSerivce.deleteRecord(dto);

        if (ok){
            return Result.success("操作成功！！！");
        }else {
            return Result.fail(Result.ERR_CODE_SYS,"系统升级中！！！！");

        }
    }
     @DeleteMapping("/{id}")
    public Result roleDelete(@PathVariable String id) {
         adminService.deleteRole(id);
         return Result.success();


     }
}
