package cz.upce.bvwa2.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Appointment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="doctor_uuid")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="patient_uuid")
    private Patient patient;
    private Date time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(getDoctor(), that.getDoctor()) &&
               Objects.equals(getPatient(), that.getPatient()) &&
               Objects.equals(getTime(), that.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDoctor(), getPatient(), getTime());
    }
}
