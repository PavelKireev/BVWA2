package cz.upce.bvwa2.db.entity;

import ch.qos.logback.core.util.TimeUtil;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@ToString
@RequiredArgsConstructor
public class Patient extends User {

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @DateTimeFormat
    private Date birthday;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Patient patient = (Patient) o;
        return id != null && Objects.equals(id, patient.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
