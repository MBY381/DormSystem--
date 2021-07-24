package com.xjtu.dormitory.messageinfo.repairrecord.timer;


import javax.mail.MessagingException;
import java.util.TimerTask;

public class RepairTaskRun extends TimerTask {


    RepairMail SendMail = new RepairMail();


    public void run() {

        try {
            SendMail.SendMail();
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }


}
