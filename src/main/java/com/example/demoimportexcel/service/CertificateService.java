package com.example.demoimportexcel.service;

import com.example.demoimportexcel.service.dto.CertificateDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CertificateService {

    void importExcel(MultipartFile file) throws IOException;

}
