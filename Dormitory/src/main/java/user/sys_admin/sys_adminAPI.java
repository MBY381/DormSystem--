package com.xjtu.dormitory.user.sys_admin;


import com.xjtu.dormitory.common.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/user/sys_admin")
public class sys_adminAPI {

    @Resource
    private GetStudentListService getStudentListService;

    @Resource
    private GetWorkerListService getWorkerListService;

    @Resource
    private AddStudentService addStudentService;

    @Resource
    private AddWorkerService addWorkerService;

    @Resource
    private DeleteStudentService deleteStudentService;

    @Resource
    private DeleteWorkerService deleteWorkerService;


    @GetMapping("/getStudentInfo")
    public Result getStudentList(StudentDto dto){

        Map<String,Object> page = getStudentListService.getStudentListInfo(dto);

        return Result.success(page);
    }

    @GetMapping("/getWorkerInfo")
    public Result getWorkerList(WorkerDto dto){

        Map<String,Object> page = getWorkerListService.getWorkerListInfo(dto);

        return Result.success(page);
    }


    @PostMapping("/addStudent")
    public Result addStudent(@RequestBody Student dto){
        boolean ok = addStudentService.addStudentInfo(dto);

        if(ok){
            return Result.success("新增成功！！！");
        }else {
            return Result.fail(Result.ERR_CODE_BUSINESS,"id重复");
        }

    }

    @PostMapping("/addWorker")
    public Result addWorker(@RequestBody WorkerDto dto){
        boolean ok = addWorkerService.addWorkerInfo(dto);

        if(ok){
            return Result.success("新增成功！！！");
        }else {
            return Result.fail(Result.ERR_CODE_BUSINESS,"id重复");
        }

    }


    @PostMapping("/deleteStudent")
    public Result deleteStudent(@RequestBody StudentDto dto){
        boolean ok = deleteStudentService.deleteServiceInfo(dto);

        if(ok){
            return Result.success("删除成功！！！");
        }else {
            return Result.fail(Result.ERR_CODE_BUSINESS,"id 不存在");
        }

    }

    @PostMapping("/deleteWorker")
    public Result deleteWorker(@RequestBody WorkerDto dto){
        boolean ok = deleteWorkerService.deleteWorkerInfo(dto);

        if(ok){
            return Result.success("删除成功！！！");
        }else {
            return Result.fail(Result.ERR_CODE_BUSINESS,"id 不存在");
        }
    }

}
