package com.example.demoimportexcel.controller;

import com.example.demoimportexcel.service.CertificateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @PostMapping("/importExcel")
    public ResponseEntity<?> importExcel(@RequestParam("file") MultipartFile file) throws IOException {
        try {
            certificateService.importExcel(file);
            return ResponseEntity.ok("Import Excel thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}