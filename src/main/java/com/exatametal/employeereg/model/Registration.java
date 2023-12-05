package com.exatametal.employeereg.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "employeeId")
    private Employee employeeId;
    private Date admissionDate;
    private Date resignationDate;
    private String workerRole;
    private Double salary;
}
