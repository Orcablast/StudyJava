package api.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSend {
	public String mailSend(String email) {
		
		// 1. 랜덤코드 생성
		Random r = new Random();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<6; i++) {
			sb.append(r.nextInt(10));
		}
		
		System.out.println(sb.toString());
		
		// 2. 메일설정
		
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.trust", "smtp.gmail.com");
		
		// 3. 메일 계정 정보 설정
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("dbro6323@gmail.com", "34594688");
			}
			
		});
		
		MimeMessage msg = new MimeMessage(session);
		
		try {
			msg.setSentDate(new Date());
			msg.setFrom(new InternetAddress("dbro6323@gmail.com","형도형"));
			InternetAddress to = new InternetAddress(email);
			msg.setRecipient(Message.RecipientType.TO, to);
			msg.setSubject("인증 테스트", "utf-8");
			msg.setContent("<h1>이거슨 인증메일인거시여</h1><h3>인증번호 ["+sb.toString()+"]</h3> <br> 틀리면 안됨됨이","text/html;charset=UTF-8");
			Transport.send(msg);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}
}
