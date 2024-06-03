package com.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${email.subject}")
    private String emailSubject;

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    public void sendEmail(String to, String name) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(to);
            helper.setSubject(emailSubject);
            String messageContent = "I hope this message finds you well. I'm Irfan, representing HM Consultant and Services. We specialize in IT recruitment across various domains.\n\n" +
                    "Our rigorous pre-screening process has qualified over 200 highly skilled candidates ready to excel in various IT roles. We are confident in our ability to meet your specific staffing needs.\n\n" +
                    "We would love the opportunity to discuss how we can support your recruitment efforts. Could we schedule a brief call or meeting to explore potential collaboration?\n\n" +
                    "Best regards,\nIrfan Sayyed\nHM Consultant and Services";
            helper.setText("Hello " + name + ",\n" + messageContent);

            javaMailSender.send(message);
            logger.info("Email sent to: {} at {}", name, to);
        } catch (MessagingException e) {
            logger.error("Failed to send email to: {} at {}", name, to, e);
        }
    }
}

