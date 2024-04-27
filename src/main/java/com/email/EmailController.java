package com.email;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private CsvReaderService csvReaderService;

    @PostMapping("/send-bulk")
    public ResponseEntity<String> sendBulkEmail() {
        List<EmailData> emailDataList = csvReaderService.readCsv();
        for (EmailData emailData : emailDataList) {
            emailService.sendEmail(emailData.getEmail(), emailData.getName());
        }
        return ResponseEntity.ok("Bulk emails sent successfully.");
    }
}
