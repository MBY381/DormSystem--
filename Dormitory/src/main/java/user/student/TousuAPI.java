package com.xjtu.dormitory.user.student;

import com.xjtu.dormitory.common.CommonService;
import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.common.Result;
import com.xjtu.dormitory.common.TokenUtils;
import com.xjtu.dormitory.user.repairer.RapairDto;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.PushBuilder;
import java.util.Map;

@RestController
@RequestMapping("/tousu")
public class TousuAPI {

    @Resource
    private CommonService commonService;
    @Resource
    private TousuService tousuService;

    @GetMapping("")
    public Result tousud(TousuDtt dtt){
        Map<String,Object> page =  tousuService.gettousu(dtt);
        return Result.success(page);
    }
    @PostMapping("")
    public Result customerinsert(@RequestBody TousuDto dto, @RequestHeader("Token") String token) {
        TousuDtt dd = new TousuDtt();
        System.out.println(dto.getTousu());
        CurrentUser currentUser = TokenUtils.getUserInfo(token, commonService);
        dd.setU_id(currentUser.getUserId());
        dd.setTousu(dto.getTousu());
        dd.setTousu_id(tousuService.findmax_tousuid());
        tousuService.insertCustomer(dd);
        return Result.success();
    }
    @PutMapping("/{id}")
    public Result change(@PathVariable Integer id){
        tousuService.change(id);
        return Result.success();
    }
}
