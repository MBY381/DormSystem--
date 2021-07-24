package com.xjtu.dormitory.messageinfo.delieverrecord.timer;

import javax.mail.MessagingException;
import java.util.TimerTask;

public class DelieverTaskRun extends TimerTask {


    Mail SendMail = new Mail();


    public void run() {

        try {
            SendMail.SendMail();
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }


}
