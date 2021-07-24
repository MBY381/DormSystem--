package com.xjtu.dormitory.user.completestu;


import com.xjtu.dormitory.common.CommonService;
import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.common.Result;
import com.xjtu.dormitory.common.TokenUtils;
import com.xjtu.dormitory.user.repairer.RapairDto;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/securitystu/complete")
public class GetDormitorystu {

    @Resource
    private DormitoryServicestu dormitoryService;
    @Resource
      private  CommonService commonService;
    @PostMapping("")
    public Result dormitoryList(@RequestBody DormDtostu dto, @RequestHeader("Token") String token){

        CurrentUser currentUser = TokenUtils.getUserInfo(token,commonService);
        RapairDto ddd=new RapairDto();
        ddd.setU_id(currentUser.getUserId());
        ddd.setDorm_id(dormitoryService.getdormid(currentUser.getUserId()));
        ddd.setTime_finish(dto.getDorm_id());
        ddd.setU_sex("0");
        ddd.setRepair_id(dormitoryService.getmaxid());
        boolean ok1=(dormitoryService.getnum(ddd.getTime_finish())<4);
        boolean ok2=(dormitoryService.getid(ddd.getU_id())<1);
        if(ok1) {
            if(ok2){
            dormitoryService.insertall(ddd);
            return Result.success();}
            else  return Result.fail(250,"你已申请过调换宿舍，不可重复申请");
        }
        else return  Result.fail(250,"该寝室已满，请选择未满的寝室");
    }
}
