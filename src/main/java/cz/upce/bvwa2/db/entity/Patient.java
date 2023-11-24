package cz.upce.bvwa2.db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@ToString
public class Patient {

    @Id
    private Long id;
    private String uuid;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    private Date birthday;

    @OneToMany(mappedBy = "patient")
    @ToString.Exclude
    private List<Appointment> appointments;

    public Patient() {
        this.user = new User();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(getUser(), patient.getUser()) && Objects.equals(getBirthday(), patient.getBirthday()) && Objects.equals(getAppointments(), patient.getAppointments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUser(), getBirthday(), getAppointments());
    }
}
