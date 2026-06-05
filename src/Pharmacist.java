
public class Pharmacist extends HospitalStaff {

    // ── Pharmacist-specific fields ───────────────────────────────────────────
    private String pharmacySection;  // e.g. "Inpatient Pharmacy", "Outpatient Pharmacy"
    private String pharmacistId;     // unique pharmacist registration ID

    // ── Constructor ──────────────────────────────────────────────────────────
    public Pharmacist(String staffId, String name, String shiftSchedule,
                      String pharmacySection, String pharmacistId) {
        super(staffId, name, shiftSchedule);
        this.pharmacySection = pharmacySection;
        this.pharmacistId    = pharmacistId;
    }

    // ── Getters/Setters (Pharmacist-specific) ────────────────────────────────
    public String getPharmacySection() { return pharmacySection; }
    public String getPharmacistId()    { return pharmacistId; }

    // ── Abstract method implementations (POLYMORPHISM) ───────────────────────

    @Override
    public void assignPatient(Patient patient) {
        System.out.println("[Pharmacist] " + name + " will handle medications for: " + patient.getName());
    }

    @Override
    public void performDuty(Patient patient) {
        // Pharmacist's duty: review prescription and dispense medications
        System.out.println("[Pharmacist] " + name + " reviewing prescription for " + patient.getName() + "...");
        System.out.println("[Pharmacist] Checking for drug interactions...");
        System.out.println("[Pharmacist] No adverse interactions detected.");
        System.out.println("[Pharmacist] Dispensing medications now.");
        patient.addMedication("Amlodipine 5mg — 30-day supply dispensed");
        patient.addMedication("Losartan 50mg — 30-day supply dispensed");
    }

    /**
     * POLYMORPHISM: Pharmacist generates a MEDICATION DISPENSING REPORT.
     * Focuses on medications dispensed — different from Doctor and Nurse reports.
     */
    @Override
    public void generateReport(Patient patient) {
        System.out.println("\n--- MEDICATION DISPENSING REPORT ---");
        System.out.println("  Pharmacist       : " + name);
        System.out.println("  Pharmacist ID    : " + pharmacistId);
        System.out.println("  Section          : " + pharmacySection);
        System.out.println("  Shift            : " + shiftSchedule);
        System.out.println("  ─────────────────────────────────────────────────");
        System.out.println("  Patient Name     : " + patient.getName());
        System.out.println("  Patient ID       : " + patient.getPatientId());
        System.out.println("  Diagnosis        : " + patient.getDiagnosis());
        System.out.println("  ─────────────────────────────────────────────────");
        System.out.println("  Medications Dispensed:");

        // Retrieve medication history through getter (Encapsulation respected)
        java.util.List<String> meds = patient.getMedicationHistory();
        if (meds.isEmpty()) {
            System.out.println("    — No medications on record.");
        } else {
            for (int i = 0; i < meds.size(); i++) {
                System.out.println("    " + (i + 1) + ". " + meds.get(i));
            }
        }

        System.out.println("  ─────────────────────────────────────────────────");
        System.out.println("  Interaction Check: PASSED — No conflicts found.");
        System.out.println("  Instructions     : Take with water after meals.");
        System.out.println("  Next Refill      : In 30 days.\n");
    }

    @Override
    public void displayStaffInfo() {
        super.displayStaffInfo();
        System.out.println("  Role             : Pharmacist");
        System.out.println("  Section          : " + pharmacySection);
        System.out.println("  Pharmacist ID    : " + pharmacistId);
        System.out.println("──────────────────────────────────────");
    }
}