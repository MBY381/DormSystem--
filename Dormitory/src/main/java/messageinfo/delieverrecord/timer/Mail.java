package com.xjtu.dormitory.messageinfo.delieverrecord.timer;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

public class Mail {

    public void SendMail() throws MessagingException {
        getRecipients();
        sendGroupMail();
    }

    //获取收件人邮件地址
    public String[] getRecipients() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//数据库驱动
            String url = "jdbc:mysql://localhost:3306/library";//数据库链接地址
            String user = "root";//用户名
            String password = "521517";//密码
            Connection conn = DriverManager.getConnection(url, user, password);//建立connection
            Statement stmt = conn.createStatement();
            conn.setAutoCommit(false);// 更改jdbc事务的默认提交方式

            String sql = "select u_email from user , water_deliever where user.u_id=water_deliever.deliever_id and water_deliever.time_actual is null and water_deliever.time_finish <= CURDATE()+1";//查询语句
            ResultSet rs = stmt.executeQuery(sql);//得到结果集
            conn.commit();//事务提交
            conn.setAutoCommit(true);// 更改jdbc事务的默认提交方式
            List<String> list = new ArrayList<String>();//创建取结果的列表
            while (rs.next()) {//如果有数据，取第一列添加如list
                list.add(rs.getString(1));
            }
            if (list != null && list.size() > 0) {//如果list中存入了数据，转化为数组
                String[] MailAdd = new String[list.size()];//创建一个和list长度一样的数组
                for (int i = 0; i < list.size(); i++) {
                    MailAdd[i] = list.get(i);//数组赋值了。
                }
                return MailAdd;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    //群发邮件
    public void sendGroupMail() throws AddressException, MessagingException {

        // 得到Session
        Properties props = new Properties();
        props.setProperty("mail.host", "smtp.163.com");
        props.setProperty("mail.smtp.auth", "true");
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //邮箱的用户名和密码
                return new PasswordAuthentication("liyan521517@163.com", "ZUXJMEUYAGZEGWCN");
            }
        };
        Session session = Session.getInstance(props, authenticator);

        //发送邮件
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("liyan521517@163.com"));
        String[] recipients = getRecipients();
        if (recipients != null) {
            for (int i = 0; i < recipients.length; i++) {
                String rec = recipients[i];
                //设置收件人
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(rec));
                //设置标题
                message.setSubject("送水提醒");
                //设置正文
                message.setContent("您有送水业务尚未完成，请尽快处理", "text/html;charset=utf-8");
                //发送
                Transport.send(message);
            }
            System.out.println("提醒邮件发送成功！");
        }else{
            System.out.println("无提醒业务");
        }
    }

}
