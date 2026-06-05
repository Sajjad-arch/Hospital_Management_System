
public class Nurse extends HospitalStaff {

    // ── Nurse-specific fields ────────────────────────────────────────────────
    private String ward;           // e.g. "ICU", "General Ward", "Pediatrics"
    private String nursingLevel;   // e.g. "Senior Nurse", "Junior Nurse"

    // ── Constructor ──────────────────────────────────────────────────────────
    public Nurse(String staffId, String name, String shiftSchedule,
                 String ward, String nursingLevel) {
        super(staffId, name, shiftSchedule);
        this.ward         = ward;
        this.nursingLevel = nursingLevel;
    }

    // ── Getters/Setters (Nurse-specific) ─────────────────────────────────────
    public String getWard()         { return ward; }
    public String getNursingLevel() { return nursingLevel; }
    public void   setWard(String w) { this.ward = w; }

    // ── Abstract method implementations (POLYMORPHISM) ───────────────────────

    @Override
    public void assignPatient(Patient patient) {
        System.out.println("[Nurse] " + name + " (" + ward + " Ward) is now caring for: " + patient.getName());
    }

    @Override
    public void performDuty(Patient patient) {
        // Nurse's duty: monitor vitals and administer medications
        System.out.println("[Nurse] " + name + " is checking vitals for " + patient.getName() + "...");
        System.out.println("[Nurse] Blood pressure recorded: 145/92 mmHg");
        System.out.println("[Nurse] Temperature: 37.2°C — Pulse: 88 bpm");
        System.out.println("[Nurse] Administering prescribed medications.");
        patient.addMedication("Amlodipine 5mg — Morning dose administered");
    }


    @Override
    public void generateReport(Patient patient) {
        System.out.println("\n--- PATIENT CARE LOG ---");
        System.out.println("  Nurse Name       : " + name);
        System.out.println("  Nursing Level    : " + nursingLevel);
        System.out.println("  Ward             : " + ward);
        System.out.println("  Shift            : " + shiftSchedule);
        System.out.println("  ─────────────────────────────────────────────────");
        System.out.println("  Patient Name     : " + patient.getName());
        System.out.println("  Patient ID       : " + patient.getPatientId());
        System.out.println("  Current Diagnosis: " + patient.getDiagnosis());
        System.out.println("  ─────────────────────────────────────────────────");
        System.out.println("  Care Activities  :");
        System.out.println("    ✓ Vitals checked — BP: 145/92, Temp: 37.2°C");
        System.out.println("    ✓ Morning medications administered");
        System.out.println("    ✓ Patient mobility assessment completed");
        System.out.println("    ✓ Wound dressing changed (if applicable)");
        System.out.println("  Patient Comfort  : Stable, resting comfortably.");
        System.out.println("  Notes            : Continue hourly BP monitoring.\n");
    }

    @Override
    public void displayStaffInfo() {
        super.displayStaffInfo();
        System.out.println("  Role          : Nurse");
        System.out.println("  Ward          : " + ward);
        System.out.println("  Nursing Level : " + nursingLevel);
        System.out.println("──────────────────────────────────────");
    }
}