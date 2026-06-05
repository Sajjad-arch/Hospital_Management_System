/**
 * Doctor - Subclass demonstrating INHERITANCE from HospitalStaff
 *
 * Adds unique fields: specialization, licenseNumber.
 * Overrides all abstract methods for POLYMORPHISM.
 * A Doctor's generateReport() produces a CLINICAL DIAGNOSIS REPORT.
 */
public class Doctor extends HospitalStaff {

    // ── Doctor-specific fields (unique to this subclass) ────────────────────
    private String specialization;   // e.g. "Cardiology", "Neurology"
    private String licenseNumber;
    private Patient assignedPatient; // currently assigned patient

    // ── Constructor ──────────────────────────────────────────────────────────
    public Doctor(String staffId, String name, String shiftSchedule,
                  String specialization, String licenseNumber) {
        super(staffId, name, shiftSchedule);  // calls HospitalStaff constructor
        this.specialization = specialization;
        this.licenseNumber  = licenseNumber;
    }

    // ── Getters/Setters (Doctor-specific) ────────────────────────────────────
    public String getSpecialization() { return specialization; }
    public String getLicenseNumber()  { return licenseNumber; }

    // ── Abstract method implementations (POLYMORPHISM) ───────────────────────

    @Override
    public void assignPatient(Patient patient) {
        this.assignedPatient = patient;
        System.out.println("[Doctor] " + name + " has been assigned patient: " + patient.getName());
    }

    @Override
    public void performDuty(Patient patient) {
        // Doctor's duty: examine and set diagnosis
        System.out.println("[Doctor] " + name + " is examining " + patient.getName() + "...");
        System.out.println("[Doctor] Setting diagnosis based on examination findings.");
        patient.setDiagnosis("Hypertension - Stage II");  // sample diagnosis
        System.out.println("[Doctor] Diagnosis recorded: " + patient.getDiagnosis());
    }

    /**
     * POLYMORPHISM: Doctor generates a CLINICAL DIAGNOSIS REPORT.
     * Completely different content vs Nurse and Pharmacist reports.
     */
    @Override
    public void generateReport(Patient patient) {
        System.out.println("\n--- CLINICAL DIAGNOSIS REPORT ---");
        System.out.println("  Attending Doctor : Dr. " + name);
        System.out.println("  Specialization   : " + specialization);
        System.out.println("  License No.      : " + licenseNumber);
        System.out.println("  Shift            : " + shiftSchedule);
        System.out.println("  ─────────────────────────────────────────────────");
        System.out.println("  Patient Name     : " + patient.getName());
        System.out.println("  Patient ID       : " + patient.getPatientId());
        System.out.println("  Age              : " + patient.getAge());
        System.out.println("  Diagnosis        : " + patient.getDiagnosis());
        System.out.println("  ─────────────────────────────────────────────────");
        System.out.println("  Clinical Notes   : Patient presents with elevated");
        System.out.println("                     blood pressure. Recommend lifestyle");
        System.out.println("                     modification and medication review.");
        System.out.println("  Recommended Next : Follow-up in 2 weeks.\n");
    }

    @Override
    public void displayStaffInfo() {
        super.displayStaffInfo();
        System.out.println("  Role           : Doctor");
        System.out.println("  Specialization : " + specialization);
        System.out.println("  License No.    : " + licenseNumber);
        System.out.println("──────────────────────────────────────");
    }
}