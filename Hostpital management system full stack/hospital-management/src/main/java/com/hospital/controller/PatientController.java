package com.hospital.controller;

import com.hospital.model.Patient;
import com.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*") // Allow frontend to call API
public class PatientController {

    @Autowired
    private PatientService patientService;

    // GET all patients
    // HTTP GET http://localhost:8080/api/patients
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }

    // GET patient by ID
    // HTTP GET http://localhost:8080/api/patients/1
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> patient = patientService.getPatientById(id);
        return patient.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // POST - Add new patient
    // HTTP POST http://localhost:8080/api/patients
    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient saved = patientService.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // PUT - Update patient
    // HTTP PUT http://localhost:8080/api/patients/1
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        try {
            Patient updated = patientService.updatePatient(id, patient);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE patient
    // HTTP DELETE http://localhost:8080/api/patients/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }

    // GET - Search patients by name
    // HTTP GET http://localhost:8080/api/patients/search?name=Kumar
    @GetMapping("/search")
    public ResponseEntity<List<Patient>> searchPatients(@RequestParam String name) {
        return ResponseEntity.ok(patientService.searchByName(name));
    }

    // GET - Dashboard statistics
    // HTTP GET http://localhost:8080/api/patients/stats
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getDashboardStats() {
        return ResponseEntity.ok(patientService.getDashboardStats());
    }
}
