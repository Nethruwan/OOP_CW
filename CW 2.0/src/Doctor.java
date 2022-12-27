import java.time.LocalDate;

public class Doctor extends Person{

    private String licenceNumber ;

    private String specialisation;

    public Doctor() {

    }

    public Doctor(String name, String surname, LocalDate dateOfBirth, String mobileNumber,String medicalLicence,String specialisation) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.licenceNumber=medicalLicence;
        this.specialisation=specialisation;

    }


    public String getLicenceNumber()
    {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber)
    {
        this.licenceNumber = licenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }


}
