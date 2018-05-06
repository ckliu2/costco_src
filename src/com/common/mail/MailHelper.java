package com.common.mail;

import oliva.mail.MailBean;
import oliva.mail.NewMessage;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.HtmlEmail;
import com.common.mail.MailProperties;
import com.opensymphony.xwork.ActionSupport;
public class MailHelper 
{
	static MailProperties m=new MailProperties();
	static ActionSupport ww= new ActionSupport();

    public static String sendSimpleMail(String to, String toName,  String subject, String msg) throws Exception
    {    
        SimpleEmail mail = new SimpleEmail();  
        mail.setCharset("utf-8");
        mail.setFrom(m.LaborSender);
        mail.addTo(to, toName);
        mail.setSubject(subject);
        mail.setMsg(msg);
        mail.setSmtpPort(m.port);
        mail.setHostName(m.host);
        mail.setAuthentication(m.username, m.password);
        return mail.send();      
    }

    public static String sendHtmlMail(String to, String msg) throws Exception
    {   	
       try{
    	HtmlEmail mail = new HtmlEmail();
        mail.setCharset("utf-8");
        mail.setFrom(ww.getText("common.mail.sender"), ww.getText("common.mail.sys"));    
        mail.addTo(to);
        mail.setSubject( ww.getText("common.mail.subject") );        
        mail.setHtmlMsg("<html><body>" + msg + "</body></html>");
        mail.setSmtpPort( Integer.parseInt(ww.getText("common.mail.port")));       
        mail.setHostName(ww.getText("common.mail.host"));
        mail.setAuthentication(ww.getText("common.mail.username"), ww.getText("common.mail.password"));
          
        return mail.send();
       }catch(Exception e){
    	   System.out.println("sendHtmlMail error="+e.toString());
    	   return "ERROR";    	  
       }
    }
    
    public static String sendHtmlMailWithSSL(String to, String msg) throws Exception
    {   	
       try{
    	  HtmlEmail mail = new HtmlEmail();
        mail.setCharset("utf-8");
        mail.setFrom(ww.getText("common.mail.sender"), ww.getText("common.mail.sys"));    
        mail.addTo(to);
        mail.setSubject( ww.getText("common.mail.subject") );        
        mail.setHtmlMsg("<html><body>" + msg + "</body></html>");
        mail.setSSL(true);        
        mail.setSmtpPort(465);       
        mail.setHostName("smtp.gmail.com");
        mail.setAuthentication("winmahjong@gmail.com", "win888mahjong");
          
        return mail.send();
       }catch(Exception e){
    	   System.out.println(e.toString());
    	   return "ERROR";    	  
       }

    }
    
    

   

    
    
    


}
