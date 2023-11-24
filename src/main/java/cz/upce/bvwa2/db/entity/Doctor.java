package cz.upce.bvwa2.db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
public class Doctor {

    @Id
    private Long id;
    private String uuid;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;
    private Long officeNumber;

    @OneToMany(mappedBy = "doctor")
    @ToString.Exclude
    private List<Appointment> appointments;

    public Doctor() {
        this.user = new User();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(getId(), doctor.getId()) && Objects.equals(getUser(), doctor.getUser()) && Objects.equals(getOfficeNumber(), doctor.getOfficeNumber()) && Objects.equals(getAppointments(), doctor.getAppointments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getOfficeNumber(), getAppointments());
    }
}
