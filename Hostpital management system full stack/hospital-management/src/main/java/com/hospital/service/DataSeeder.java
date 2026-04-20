package com.hospital.service;

import com.hospital.model.Patient;
import com.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void run(String... args) {
        // Only seed if DB is empty
        if (patientRepository.count() > 0) return;

        String[] names = {
            "Aadarsh Kumar", "Priya Sharma", "Rahul Gupta", "Anjali Singh", "Vikram Patel",
            "Sunita Verma", "Amit Yadav", "Pooja Mishra", "Suresh Tiwari", "Kavita Joshi",
            "Deepak Mehta", "Rekha Srivastava", "Manoj Pandey", "Neha Agarwal", "Sandeep Dubey",
            "Ritu Chauhan", "Arun Shukla", "Meena Tripathi", "Prakash Bajpai", "Shweta Rao"
        };
        String[] departments = {"Cardiology", "Neurology", "Orthopedics", "Pediatrics", "General Medicine", "ENT", "Dermatology"};
        String[] diseases = {"Hypertension", "Diabetes", "Fracture", "Fever", "Migraine", "Asthma", "Dengue", "Typhoid", "Malaria", "Arthritis"};
        String[] statuses = {"Admitted", "Discharged", "Under Observation"};
        String[] genders = {"Male", "Female"};

        Random rand = new Random();
        List<Patient> patients = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            String name = names[rand.nextInt(names.length)] + " " + (i + 1);
            int age = 5 + rand.nextInt(80);
            String gender = genders[rand.nextInt(2)];
            String disease = diseases[rand.nextInt(diseases.length)];
            String department = departments[rand.nextInt(departments.length)];
            LocalDate admDate = LocalDate.now().minusDays(rand.nextInt(365));
            String status = statuses[rand.nextInt(statuses.length)];

            patients.add(new Patient(name, age, gender, disease, department, admDate, status));
        }

        patientRepository.saveAll(patients);
        System.out.println("✅ Seeded 500 patient records successfully.");
    }
}
