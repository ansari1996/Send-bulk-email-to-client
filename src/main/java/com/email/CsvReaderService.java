package com.email;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

@Service
public class CsvReaderService {

    @Value("${csv.file.path}")
    private String csvFilePath;

    public List<EmailData> readCsv() {
        List<EmailData> emailDataList = new ArrayList<>();

        try (Reader reader = new FileReader(csvFilePath)) {
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build(); // Skip header
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                EmailData emailData = new EmailData();
                emailData.setName(line[0]);
                emailData.setEmail(line[1]);
                emailDataList.add(emailData);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return emailDataList;
    }
}
