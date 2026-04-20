package com.hospital.repository;

import com.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Find by department
    List<Patient> findByDepartment(String department);

    // Find by status
    List<Patient> findByStatus(String status);

    // Find by name (case-insensitive)
    List<Patient> findByNameContainingIgnoreCase(String name);

    // Count by department (for dashboard chart)
    @Query("SELECT p.department, COUNT(p) FROM Patient p GROUP BY p.department")
    List<Object[]> countByDepartment();

    // Count by status (for dashboard chart)
    @Query("SELECT p.status, COUNT(p) FROM Patient p GROUP BY p.status")
    List<Object[]> countByStatus();
}
