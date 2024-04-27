package com.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${email.subject}")
    private String emailSubject;

    public void sendEmail(String to, String name) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(to);
            helper.setSubject(emailSubject);
            
            String messageContent = "I hope this message finds you well. I'm Irfan, representing HM Consultant and Services, a firm specializing in IT recruitment, particularly in the domains of DevOps and AWS engineering.\n\n" +
                    "I wanted to share some exciting news with you. We've recently conducted thorough pre-screening interviews and successfully qualified over 200 candidates, specifically targeting DevOps and AWS engineering roles. These professionals are equipped with the skills and experience necessary to excel in demanding IT environments.\n\n" +
                    "I believe our collaboration could significantly enhance your company's recruitment efforts in these critical areas. Would you be available for a brief call or meeting to discuss how we can assist you in fulfilling your DevOps and AWS engineering staffing needs?\n\n" +
                    "Looking forward to the opportunity to support your recruitment objectives.\n\n" +
                    "Best regards,\nIrfan Sayyed\nHM Consultant and Services";
            helper.setText("hello "+name+",\n"+messageContent);
//            helper.setText("Hello " + name + ","
//            		+ "\r\n"
//            		+ "I hope this message finds you well. I'm Irfan, representing HM Consultant and Services, a firm specializing in IT recruitment, particularly in the domains of DevOps and AWS engineering.\r\n"
//            		+ "\r\n"
//            		+ "I wanted to share some exciting news with you. We've recently conducted thorough pre-screening interviews and successfully qualified over 200 candidates, specifically targeting DevOps and AWS engineering roles. These professionals are equipped with the skills and experience necessary to excel in demanding IT environments.\r\n"
//            		+ "\r\n"
//            		+ "I believe our collaboration could significantly enhance your company's recruitment efforts in these critical areas. Would you be available for a brief call or meeting to discuss how we can assist you in fulfilling your DevOps and AWS engineering staffing needs?\r\n"
//            		+ "\r\n"
//            		+ "Looking forward to the opportunity to support your recruitment objectives.\r\n"
//            		+ "\r\n"
//            		+ "Best regards,\r\n"
//            		+ "Irfan Sayyed \r\n"
//            		+ "HM Consultant and Services");
//            helper.setText("Hello " + name + ",\r\n"
//                    + "\r\n"
//                    + "I hope this message finds you well. I'm Irfan, representing HM Consultant and Services, a firm specializing in IT recruitment, particularly in the domains of DevOps and AWS engineering.\r\n"
//                    + "\r\n"
//                    + "I wanted to share some exciting news with you. We've recently conducted thorough pre-screening interviews and successfully qualified over 200 candidates, specifically targeting DevOps and AWS engineering roles. These professionals are equipped with the skills and experience necessary to excel in demanding IT environments.\r\n"
//                    + "\r\n"
//                    + "I believe our collaboration could significantly enhance your company's recruitment efforts in these critical areas. Would you be available for a brief call or meeting to discuss how we can assist you in fulfilling your DevOps and AWS engineering staffing needs?\r\n"
//                    + "\r\n"
//                    + "Looking forward to the opportunity to support your recruitment objectives.\r\n"
//                    + "\r\n"
//                    + "Best regards,\r\n"
//                    + "Irfan Sayyed\r\n"
//                    + "HM Consultant and Services");
//            String emailText = "Hello " + name + ",\r\n" +
//                    "\r\n" +
//                    "I hope this message finds you well. I'm Irfan, representing HM Consultant and Services, a firm specializing in IT recruitment, particularly in the domains of DevOps and AWS engineering.\r\n" +
//                    "\r\n" +
//                    "I wanted to share some exciting news with you. We've recently conducted thorough pre-screening interviews and successfully qualified over 200 candidates, specifically targeting DevOps and AWS engineering roles. These professionals are equipped with the skills and experience necessary to excel in demanding IT environments.\r\n" +
//                    "\r\n" +
//                    "I believe our collaboration could significantly enhance your company's recruitment efforts in these critical areas. Would you be available for a brief call or meeting to discuss how we can assist you in fulfilling your DevOps and AWS engineering staffing needs?\r\n" +
//                    "\r\n" +
//                    "Looking forward to the opportunity to support your recruitment objectives.\r\n" +
//                    "\r\n" +
//                    "Best regards,\r\n" +
//                    "Irfan Sayyed\r\n" +
//                    "HM Consultant and Services";
//
//            helper.setText(emailText);
            
//            String emailText = "<html><body>" +
//                    "<p>Hello " + name + ",</p>" +
//                    "<p>I hope this message finds you well. I'm Irfan, representing HM Consultant and Services, a firm specializing in IT recruitment, particularly in the domains of DevOps and AWS engineering.</p>" +
//                    "<p>I wanted to share some exciting news with you. We've recently conducted thorough pre-screening interviews and successfully qualified over 200 candidates, specifically targeting DevOps and AWS engineering roles. These professionals are equipped with the skills and experience necessary to excel in demanding IT environments.</p>" +
//                    "<p>I believe our collaboration could significantly enhance your company's recruitment efforts in these critical areas. Would you be available for a brief call or meeting to discuss how we can assist you in fulfilling your DevOps and AWS engineering staffing needs?</p>" +
//                    "<p>Looking forward to the opportunity to support your recruitment objectives.</p>" +
//                    "<p>Best regards,<br>Irfan Sayyed<br>HM Consultant and Services</p>" +
//                    "</body></html>";
//
//            helper.setText(emailText, true); // Set HTML content
            
//            String emailText = "Hello " + name + ",\r\n" +
//                    "\r\n"
//                    + "\r\n"
//                    + "I hope this message finds you well. I'm Irfan, representing HM Consultant and Services, a firm specializing in IT recruitment, particularly in the domains of DevOps and AWS engineering.\r\n"
//                    + "\r\n"
//                    + "I wanted to share some exciting news with you. We've recently conducted thorough pre-screening interviews and successfully qualified over 200 candidates, specifically targeting DevOps and AWS engineering roles. These professionals are equipped with the skills and experience necessary to excel in demanding IT environments.\r\n"
//                    + "\r\n"
//                    + "I believe our collaboration could significantly enhance your company's recruitment efforts in these critical areas. Would you be available for a brief call or meeting to discuss how we can assist you in fulfilling your DevOps and AWS engineering staffing needs?\r\n"
//                    + "\r\n"
//                    + "Looking forward to the opportunity to support your recruitment objectives.\r\n"
//                    + "\r\n"
//                    + "Best regards,\r\n"
//                    + "Irfan Sayyed \r\n"
//                    + "HM Consultant and Services";
//            helper.setText(emailText);



            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
