package com.example.demoimportexcel.service.serviceImpl;

import com.example.demoimportexcel.entity.Certificate;
import com.example.demoimportexcel.repository.CertificateRepository;
import com.example.demoimportexcel.service.CertificateService;
import com.example.demoimportexcel.service.mapper.CertificateMapper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Date;


@Service
public class CertificateServiceImpl implements CertificateService {
    private final CertificateRepository certificateRepository;
    private final CertificateMapper certificateMapper;


    public CertificateServiceImpl(CertificateRepository certificateRepository, CertificateMapper certificateMapper) {
        this.certificateRepository = certificateRepository;
        this.certificateMapper = certificateMapper;
    }


    @Override
    public void importExcel(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new RuntimeException("File không được trống!");
        }

        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            String nameCertificate = row.getCell(0).getStringCellValue();
            Date issueDate =  row.getCell(1).getDateCellValue();
            Date expirationDate =  row.getCell(2).getDateCellValue();
            String description = row.getCell(3).getStringCellValue();
            String certificationOfficer = row.getCell(4).getStringCellValue();

            // Lưu thông tin vào database

            Certificate certificate = new Certificate();
            certificate.setNameCertificate(nameCertificate);
            certificate.setIssueDate(issueDate);
            certificate.setExpirationDate(expirationDate);
            certificate.setDescription(description);
            certificate.setCertificationOfficer(certificationOfficer);

            certificateRepository.save(certificate);
        }
    }

}
