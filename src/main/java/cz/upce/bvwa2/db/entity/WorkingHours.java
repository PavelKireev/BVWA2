package cz.upce.bvwa2.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@RequiredArgsConstructor
@Table(name = "working_hours")
public class WorkingHours extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private String dayOfWeek;
    private Integer hourFrom;
    private Integer hoursCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingHours that = (WorkingHours) o;
        return Objects.equals(getDoctor(), that.getDoctor()) &&
               Objects.equals(getDayOfWeek(), that.getDayOfWeek()) &&
               Objects.equals(getHourFrom(), that.getHourFrom()) &&
               Objects.equals(getHoursCount(), that.getHoursCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDoctor(), getDayOfWeek(), getHourFrom(), getHoursCount());
    }
}
