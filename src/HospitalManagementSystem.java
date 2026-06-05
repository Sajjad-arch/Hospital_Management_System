import java.util.Scanner;

public class HospitalManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Hospital Management System ===\n");

        // ---------------------------
        // Patient Input
        // ---------------------------
        System.out.println("Enter Patient 1 Details:");
        System.out.print("Patient ID: ");
        int p1Id = sc.nextInt();
        sc.nextLine();

        System.out.print("Patient Name: ");
        String p1Name = sc.nextLine();

        System.out.print("Patient Age: ");
        int p1Age = sc.nextInt();
        sc.nextLine();

        Patient p1 = new Patient(p1Id, p1Name, p1Age);

        System.out.print("Initial Diagnosis: ");
        p1.setDiagnosis(sc.nextLine());

        System.out.println();

        System.out.println("Enter Patient 2 Details:");
        System.out.print("Patient ID: ");
        int p2Id = sc.nextInt();
        sc.nextLine();

        System.out.print("Patient Name: ");
        String p2Name = sc.nextLine();

        System.out.print("Patient Age: ");
        int p2Age = sc.nextInt();
        sc.nextLine();

        Patient p2 = new Patient(p2Id, p2Name, p2Age);

        System.out.print("Diagnosis: ");
        p2.setDiagnosis(sc.nextLine());

        System.out.print("Medication: ");
        p2.addMedication(sc.nextLine());

        // ---------------------------
        // Doctor Input
        // ---------------------------
        System.out.println("\nEnter Doctor Details:");

        System.out.print("Doctor ID: ");
        String doctorId = sc.nextLine();

        System.out.print("Doctor Name: ");
        String doctorName = sc.nextLine();

        System.out.print("Shift: ");
        String doctorShift = sc.nextLine();

        System.out.print("Specialization: ");
        String specialization = sc.nextLine();

        System.out.print("License Number: ");
        String license = sc.nextLine();

        Doctor doctor = new Doctor(
                doctorId,
                doctorName,
                doctorShift,
                specialization,
                license
        );

        // ---------------------------
        // Nurse Input
        // ---------------------------
        System.out.println("\nEnter Nurse Details:");

        System.out.print("Nurse ID: ");
        String nurseId = sc.nextLine();

        System.out.print("Nurse Name: ");
        String nurseName = sc.nextLine();

        System.out.print("Shift: ");
        String nurseShift = sc.nextLine();

        System.out.print("Department: ");
        String department = sc.nextLine();

        System.out.print("Rank: ");
        String rank = sc.nextLine();

        Nurse nurse = new Nurse(
                nurseId,
                nurseName,
                nurseShift,
                department,
                rank
        );

        // ---------------------------
        // Pharmacist Input
        // ---------------------------
        System.out.println("\nEnter Pharmacist Details:");

        System.out.print("Pharmacist ID: ");
        String pharmacistId = sc.nextLine();

        System.out.print("Pharmacist Name: ");
        String pharmacistName = sc.nextLine();

        System.out.print("Shift: ");
        String pharmacistShift = sc.nextLine();

        System.out.print("Pharmacy Section: ");
        String pharmacySection = sc.nextLine();

        System.out.print("Registration Number: ");
        String regNo = sc.nextLine();

        Pharmacist pharmacist = new Pharmacist(
                pharmacistId,
                pharmacistName,
                pharmacistShift,
                pharmacySection,
                regNo
        );

        // ---------------------------
        // Encapsulation Demo
        // ---------------------------
        System.out.println("\n=== [1] ENCAPSULATION ===");
        System.out.println(p1);
        System.out.println(p2);

        // ---------------------------
        // Inheritance Demo
        // ---------------------------
        System.out.println("\n=== [2] INHERITANCE ===");

        System.out.println("\nDoctor Information:");
        doctor.displayStaffInfo();

        System.out.println("\nNurse Information:");
        nurse.displayStaffInfo();

        System.out.println("\nPharmacist Information:");
        pharmacist.displayStaffInfo();

        // ---------------------------
        // Abstraction + Polymorphism
        // ---------------------------
        System.out.println("\n=== [3] ABSTRACTION & POLYMORPHISM ===");

        System.out.println("\n--- Doctor's Turn ---");
        doctor.assignPatient(p1);
        doctor.performDuty(p1);
        doctor.generateReport(p1);

        System.out.println("\n--- Nurse's Turn ---");
        nurse.assignPatient(p1);
        nurse.performDuty(p1);
        nurse.generateReport(p1);

        System.out.println("\n--- Pharmacist's Turn ---");
        pharmacist.assignPatient(p1);
        pharmacist.performDuty(p1);
        pharmacist.generateReport(p1);

        // ---------------------------
        // Runtime Polymorphism
        // ---------------------------
        System.out.println("\n=== [4] RUNTIME POLYMORPHISM ===");

        HospitalStaff[] allStaff = { doctor, nurse, pharmacist };

        for (HospitalStaff staff : allStaff) {
            staff.generateReport(p2);
        }

        System.out.println("\n=== System Demo Complete ===");

        sc.close();
    }
}