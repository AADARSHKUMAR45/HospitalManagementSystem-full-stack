# 🏥 Hospital Management System — Full Stack

A full-stack Hospital Management System built with **Spring Boot REST API** + **HTML/JavaScript dashboard**.  
Manages 500+ patient records with real-time charts and complete CRUD operations over HTTP.

---

## 🚀 Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Java 17, Spring Boot 3.2, Spring Web, Spring Data JPA |
| Database | MySQL 8.0 |
| Protocol | REST API over HTTP/TCP |
| Frontend | HTML5, CSS3, JavaScript (Fetch API) |
| Charts | Chart.js |
| Build Tool | Maven |

---

## ✨ Features

- **REST API** — Full CRUD via HTTP endpoints (GET, POST, PUT, DELETE)
- **Live Dashboard** — Real-time charts (patients by department, status distribution)
- **500+ Records** — Auto-seeded on first startup
- **Search** — Search patients by name
- **Add/Delete** — Manage patients from the web UI
- **Stat Cards** — Total, Admitted, Discharged, Under Observation counts

---

## 📁 Project Structure

```
hospital-management/
├── src/main/java/com/hospital/
│   ├── HospitalManagementApplication.java   # Main entry point
│   ├── controller/
│   │   └── PatientController.java           # REST endpoints
│   ├── service/
│   │   ├── PatientService.java              # Business logic
│   │   └── DataSeeder.java                  # Seeds 500 records
│   ├── model/
│   │   └── Patient.java                     # JPA Entity
│   └── repository/
│       └── PatientRepository.java           # Database queries
├── src/main/resources/
│   ├── static/
│   │   └── index.html                       # Frontend dashboard
│   └── application.properties               # DB config
└── pom.xml
```

---

## ⚙️ Setup & Run

### 1. Create MySQL Database
```sql
CREATE DATABASE hospital_db;
```

### 2. Update `application.properties`
```properties
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3. Run the Application
```bash
mvn spring-boot:run
```

### 4. Open Dashboard
```
http://localhost:8080/index.html
```

---

## 🔗 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/patients` | Get all patients |
| GET | `/api/patients/{id}` | Get patient by ID |
| POST | `/api/patients` | Add new patient |
| PUT | `/api/patients/{id}` | Update patient |
| DELETE | `/api/patients/{id}` | Delete patient |
| GET | `/api/patients/search?name=xyz` | Search by name |
| GET | `/api/patients/stats` | Dashboard statistics |

### Example: Add Patient
```bash
curl -X POST http://localhost:8080/api/patients \
  -H "Content-Type: application/json" \
  -d '{"name":"Rahul Kumar","age":30,"gender":"Male","disease":"Fever","department":"General Medicine","admissionDate":"2025-04-20","status":"Admitted"}'
```

---

## 📊 Dashboard Preview

- **4 stat cards** — total, admitted, discharged, under observation
- **Bar chart** — patient count per department
- **Doughnut chart** — status distribution
- **Searchable table** — top 50 patients with delete action

---

## 👨‍💻 Author

**Aadarsh Kumar** — B.Tech CSE, Arya College of Engineering  
GitHub: [github.com/AADARSHKUMAR45](https://github.com/AADARSHKUMAR45)

---

## 📄 License
MIT
