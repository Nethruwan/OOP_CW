import java.time.LocalDateTime;

public class Consultation {

    private LocalDateTime consultationTimeSlot;
    private Integer cost;
    private String notes;

    public LocalDateTime getConsultationTimeSlot() {
        return consultationTimeSlot;
    }

    public void setConsultationTimeSlot(LocalDateTime consultationTimeSlot) {
        this.consultationTimeSlot = consultationTimeSlot;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


}
