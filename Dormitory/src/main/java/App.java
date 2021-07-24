package com.xjtu.dormitory;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.xjtu.dormitory.messageinfo.delieverrecord.timer.*;
import com.xjtu.dormitory.messageinfo.repairrecord.timer.*;

@SpringBootApplication
public class App {
    public static void main ( String[] args ) {
        ApplicationContext ctx=SpringApplication.run(App.class,args);
        new DelieverTimerManager();
        new RepairTimerManager();


    }
}
