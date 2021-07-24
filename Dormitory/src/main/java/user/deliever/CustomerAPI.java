package com.xjtu.dormitory.user.deliever;
import com.xjtu.dormitory.common.CommonService;
import com.xjtu.dormitory.common.CurrentUser;
import com.xjtu.dormitory.common.Result;
import com.xjtu.dormitory.common.TokenUtils;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

@RestController
@RequestMapping("/deliever")
public class CustomerAPI{
    @Resource
    private CustomerService customerService;

    @Resource
    private CommonService   commonService;

    @GetMapping("")
    public Result customerList(CustomerDto dto){
        Map<String,Object> page =  customerService.getCustomerList(dto);
        return Result.success(page);
    }
   // @Update("/up")
    //public Result customerUpdate( ) {
      //  customerService.updateCustomer();
       // return Result.success();
   // }

   @PutMapping("")
   public Result customerupdate(@RequestHeader("Token") String token){
       CustomerDto dto=new CustomerDto();
       SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );//时间格式转换
       dto.setTime_actual(sdf.format(new Date()));
       CurrentUser currentUser = TokenUtils.getUserInfo(token,commonService);
       dto.setDeliver_id(currentUser.getUserId());
       customerService.allCustomer(dto);
        return Result.success();
    }
    @PutMapping("/{id}")
    public Result customeradd( @PathVariable Integer id,@RequestHeader("Token") String token) {
        CustomerDto dto=new CustomerDto();
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );//时间格式转换
        dto.setTime_actual(sdf.format(new Date()));
        CurrentUser currentUser = TokenUtils.getUserInfo(token,commonService);
        System.out.println(currentUser.getUserId());
        dto.setDeliver_id(currentUser.getUserId());
        dto.setWater_id(id);
        //System.out.println(dto.getDeliver_id());
        customerService.addsCustomer(dto);
        return Result.success();
    }
   @DeleteMapping("/{id}")
  public Result customerDelete(@PathVariable Integer id){
        boolean ok =(customerService.selectCustomer(id)>0);
        if(ok) {
            customerService.deleteCustomer(id);
            customerService.updateall(id);
            return Result.success();
        }
        return  Result.fail(100,"还未送水");
   }

    @DeleteMapping("")
    public Result customerDelete1(){
        customerService.deleteCustomer();
        return Result.success();
    }
    @PostMapping("")
    public Result customerinsert(@RequestHeader("Token") String token) {
        CustomerDto dto = new CustomerDto();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//时间格式转换
        dto.setTime_begin(sdf.format(new Date()));
        Calendar rightNow = Calendar.getInstance();
        rightNow.add(Calendar.DAY_OF_WEEK, 3);
        Date dt1 = rightNow.getTime();
        dto.setTime_finish(sdf.format(dt1));
        CurrentUser currentUser = TokenUtils.getUserInfo(token, commonService);
        dto.setU_id(currentUser.getUserId());
        dto.setDorm_id(customerService.finddorm(dto.getU_id()));
        dto.setWater_id(customerService.findmax_waterid());
        boolean ok=(customerService.selectCustomer(dto.getDorm_id())>0);
        if (!ok) {
            customerService.insertCustomer(dto);
            return Result.success();
        }
        return Result.fail(250, "你所在寝室已经申请过，不可在规定时间内重复申请");
    }


}
