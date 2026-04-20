package com.hospital.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int age;

    private String gender;

    private String disease;

    private String department;

    @Column(name = "admission_date")
    private LocalDate admissionDate;

    private String status; // Admitted, Discharged, Under Observation

    // Constructors
    public Patient() {}

    public Patient(String name, int age, String gender, String disease, String department, LocalDate admissionDate, String status) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
        this.department = department;
        this.admissionDate = admissionDate;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDisease() { return disease; }
    public void setDisease(String disease) { this.disease = disease; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public LocalDate getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(LocalDate admissionDate) { this.admissionDate = admissionDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
