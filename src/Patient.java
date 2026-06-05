import java.util.ArrayList;
import java.util.List;


public class Patient {

    // ── Private fields (Encapsulation) ──────────────────────────────────────
    private int    patientId;
    private String name;
    private int    age;
    private String diagnosis;
    private List<String> medicationHistory;  // tracks all medications prescribed

    // ── Constructor ──────────────────────────────────────────────────────────
    public Patient(int patientId, String name, int age) {
        this.patientId         = patientId;
        this.name              = name;
        this.age               = age;
        this.diagnosis         = "Pending";
        this.medicationHistory = new ArrayList<>();
    }

    // ── Getters ──────────────────────────────────────────────────────────────
    public int    getPatientId()          { return patientId; }
    public String getName()               { return name; }
    public int    getAge()                { return age; }
    public String getDiagnosis()          { return diagnosis; }
    public List<String> getMedicationHistory() { return new ArrayList<>(medicationHistory); }

    // ── Setters ──────────────────────────────────────────────────────────────
    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Patient name cannot be empty.");
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 150)
            throw new IllegalArgumentException("Invalid age: " + age);
        this.age = age;
    }

    public void setDiagnosis(String diagnosis) {
        if (diagnosis == null || diagnosis.trim().isEmpty())
            throw new IllegalArgumentException("Diagnosis cannot be empty.");
        this.diagnosis = diagnosis;
    }


    public void addMedication(String medication) {
        if (medication != null && !medication.trim().isEmpty()) {
            this.medicationHistory.add(medication);
        }
    }

    // ── Display helper ───────────────────────────────────────────────────────
    @Override
    public String toString() {
        return String.format("Patient[ID=%d | Name=%s | Age=%d | Diagnosis=%s]",
                patientId, name, age, diagnosis);
    }
}
