import java.time.LocalDate;

public class Patient extends Person {
    private String patientID;

    public Patient(String name, String surname, LocalDate dateOfBirth, String mobileNo) {
        super(name, surname, dateOfBirth, mobileNo);
    }

    public String getPatientID()
    {
        return patientID;
    }

    public void setPatientID(String patientID)
    {
        this.patientID = patientID;
    }
}
