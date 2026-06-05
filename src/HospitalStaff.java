/**
 * HospitalStaff - Base class demonstrating INHERITANCE
 * 
 * Holds common properties shared by ALL staff (Doctor, Nurse, Pharmacist).
 * Extends MedicalService so every staff member is bound by the abstract contract.
 */
public abstract class HospitalStaff extends MedicalService {

    // ── Common fields for all staff ──────────────────────────────────────────
    protected String staffId;
    protected String name;
    protected String shiftSchedule;   // e.g. "Morning (6AM–2PM)"

    // ── Constructor ──────────────────────────────────────────────────────────
    public HospitalStaff(String staffId, String name, String shiftSchedule) {
        this.staffId       = staffId;
        this.name          = name;
        this.shiftSchedule = shiftSchedule;
    }

    // ── Getters ──────────────────────────────────────────────────────────────
    public String getStaffId()       { return staffId; }
    public String getName()          { return name; }
    public String getShiftSchedule() { return shiftSchedule; }

    // ── Setters ──────────────────────────────────────────────────────────────
    public void setShiftSchedule(String shiftSchedule) {
        this.shiftSchedule = shiftSchedule;
    }

    // ── Common display ───────────────────────────────────────────────────────
    public void displayStaffInfo() {
        System.out.println("──────────────────────────────────────");
        System.out.println("  Staff ID : " + staffId);
        System.out.println("  Name     : " + name);
        System.out.println("  Shift    : " + shiftSchedule);
    }
}
