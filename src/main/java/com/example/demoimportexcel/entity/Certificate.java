package com.example.demoimportexcel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "certificate")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_certificate", nullable = false, unique = true)
    private String nameCertificate;

    @Column(name = "issue_date")
    private Date issueDate;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column
    private String description;

    @Column(name = "certification_officer")
    private String certificationOfficer;
}