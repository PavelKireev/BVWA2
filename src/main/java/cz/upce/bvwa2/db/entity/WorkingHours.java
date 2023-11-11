package cz.upce.bvwa2.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WorkingHours extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private User doctor;

}
