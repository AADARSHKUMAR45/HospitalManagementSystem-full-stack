package com.hospital.service;

import com.hospital.model.Patient;
import com.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get patient by ID
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    // Add new patient
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Update patient
    public Patient updatePatient(Long id, Patient updatedPatient) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        patient.setName(updatedPatient.getName());
        patient.setAge(updatedPatient.getAge());
        patient.setGender(updatedPatient.getGender());
        patient.setDisease(updatedPatient.getDisease());
        patient.setDepartment(updatedPatient.getDepartment());
        patient.setAdmissionDate(updatedPatient.getAdmissionDate());
        patient.setStatus(updatedPatient.getStatus());

        return patientRepository.save(patient);
    }

    // Delete patient
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    // Search by name
    public List<Patient> searchByName(String name) {
        return patientRepository.findByNameContainingIgnoreCase(name);
    }

    // Stats for dashboard
    public Map<String, Object> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();

        long total = patientRepository.count();
        long admitted = patientRepository.findByStatus("Admitted").size();
        long discharged = patientRepository.findByStatus("Discharged").size();
        long observation = patientRepository.findByStatus("Under Observation").size();

        stats.put("totalPatients", total);
        stats.put("admitted", admitted);
        stats.put("discharged", discharged);
        stats.put("underObservation", observation);

        // Department-wise count
        List<Object[]> deptData = patientRepository.countByDepartment();
        Map<String, Long> deptMap = new LinkedHashMap<>();
        for (Object[] row : deptData) {
            deptMap.put((String) row[0], (Long) row[1]);
        }
        stats.put("byDepartment", deptMap);

        return stats;
    }
}
