# 🏥 Hospital Management System

A Java console application demonstrating the **four core pillars of Object-Oriented Programming** — Encapsulation, Inheritance, Abstraction, and Polymorphism — through a realistic hospital workflow simulation.

---

## 📋 Table of Contents

- [Overview](#overview)
- [OOP Concepts Demonstrated](#oop-concepts-demonstrated)
- [Project Structure](#project-structure)
- [Class Hierarchy](#class-hierarchy)
- [Features](#features)
- [How to Run](#how-to-run)
- [Sample Output](#sample-output)
- [Technologies Used](#technologies-used)

---

## Overview

This project simulates a hospital environment where **Doctors**, **Nurses**, and **Pharmacists** each interact with **Patients** in their own unique way. The system was built as a lab assignment to demonstrate how OOP principles apply to real-world software design.

---

## OOP Concepts Demonstrated

### 🔒 1. Encapsulation — `Patient.java`
All patient data (`patientId`, `name`, `age`, `diagnosis`, `medicationHistory`) is declared `private`. Access is strictly controlled through validated **getters and setters**.

```java
// Direct access blocked — must go through setter
patient.setAge(-5);  // Throws IllegalArgumentException
patient.setDiagnosis("");  // Throws IllegalArgumentException
```

### 🧱 2. Inheritance — `HospitalStaff.java`
`Doctor`, `Nurse`, and `Pharmacist` all **extend** `HospitalStaff`, inheriting common fields (`staffId`, `name`, `shiftSchedule`) while adding their own specializations.

```
MedicalService  (abstract)
    └── HospitalStaff  (abstract)
            ├── Doctor
            ├── Nurse
            └── Pharmacist
```

### 🎭 3. Abstraction — `MedicalService.java`
An abstract class that enforces a **contract** — every staff member *must* implement three methods, regardless of their role.

```java
public abstract void assignPatient(Patient patient);
public abstract void performDuty(Patient patient);
public abstract void generateReport(Patient patient);
```

### 🔄 4. Polymorphism — `generateReport()` across all staff
Same method call, completely different behavior at runtime. This is demonstrated clearly in the `HospitalManagementSystem` main class:

```java
HospitalStaff[] allStaff = { doctor, nurse, pharmacist };

for (HospitalStaff staff : allStaff) {
    staff.generateReport(p2);  // Each prints a different report!
}
```

| Staff Role  | Report Generated            |
|-------------|-----------------------------|
| Doctor      | Clinical Diagnosis Report   |
| Nurse       | Patient Care Log            |
| Pharmacist  | Medication Dispensing Report|

---

## Project Structure

```
HospitalManagementSystem/
│
├── MedicalService.java          # Abstract base — defines the contract
├── HospitalStaff.java           # Abstract parent — common staff fields
│
├── Doctor.java                  # Subclass — specialization, license
├── Nurse.java                   # Subclass — ward, nursing level
├── Pharmacist.java              # Subclass — pharmacy section, reg. no.
│
├── Patient.java                 # Encapsulated patient data model
└── HospitalManagementSystem.java  # Main class — full system demo
```

---

## Class Hierarchy

```
MedicalService          ← Abstract class
  │  assignPatient()
  │  performDuty()
  │  generateReport()
  │
  └── HospitalStaff     ← Abstract class (adds staffId, name, shift)
        │
        ├── Doctor      → specialization, licenseNumber
        ├── Nurse       → ward, nursingLevel
        └── Pharmacist  → pharmacySection, pharmacistId
```

---

## Features

- ✅ Full user input via `Scanner` for all entities (patients, doctor, nurse, pharmacist)
- ✅ Input validation with meaningful error messages in `Patient` setters
- ✅ Runtime polymorphism loop — all staff types handled through base reference
- ✅ Medication history tracking via `ArrayList<String>`
- ✅ `super()` constructor chaining demonstrated across three levels
- ✅ `@Override` used consistently for clarity and safety
- ✅ Clean, well-commented code suitable for academic review

---

## How to Run

### Prerequisites
- Java JDK 8 or higher
- Any IDE (IntelliJ IDEA, Eclipse, VS Code) or terminal

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/your-username/hospital-management-system.git
cd hospital-management-system
```

**2. Compile all files**
```bash
javac *.java
```

**3. Run the main class**
```bash
java HospitalManagementSystem
```

**4. Follow the prompts** — enter details for 2 patients, 1 doctor, 1 nurse, and 1 pharmacist.

---

## Sample Output

```
=== Hospital Management System ===

=== [1] ENCAPSULATION ===
Patient[ID=101 | Name=Rahim Uddin | Age=45 | Diagnosis=Hypertension]

=== [2] INHERITANCE ===
──────────────────────────────────────
  Staff ID : D-001
  Name     : Dr. Kamal Hossain
  Shift    : Morning (6AM–2PM)
  Role     : Doctor
  Specialization : Cardiology
  License No.    : BD-MED-4521
──────────────────────────────────────

=== [3] ABSTRACTION & POLYMORPHISM ===
[Doctor] Dr. Kamal Hossain is examining Rahim Uddin...
[Doctor] Diagnosis recorded: Hypertension - Stage II

--- CLINICAL DIAGNOSIS REPORT ---
  Attending Doctor : Dr. Kamal Hossain
  Specialization   : Cardiology
  Patient Name     : Rahim Uddin
  Diagnosis        : Hypertension - Stage II

=== [4] RUNTIME POLYMORPHISM ===
--- CLINICAL DIAGNOSIS REPORT ---     ← Doctor's version
--- PATIENT CARE LOG ---              ← Nurse's version
--- MEDICATION DISPENSING REPORT ---  ← Pharmacist's version
```

---

## Technologies Used

| Tool       | Version  |
|------------|----------|
| Java       | JDK 8+   |
| IDE        | IntelliJ IDEA / VS Code |
| Concepts   | OOP — Encapsulation, Inheritance, Abstraction, Polymorphism |

---

## Author

**Sajjad** — CSE Student, Southeast University (SEU), Dhaka  
*Java OOP Lab Assignment*

---

> *"Good code is like a good hospital — every role is clearly defined, every responsibility is encapsulated, and the system works even when you swap out the staff."*
