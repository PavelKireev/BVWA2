package cz.upce.bvwa2.model.doctor;

import cz.upce.bvwa2.db.entity.Doctor;
import lombok.Data;

@Data
public class DoctorModel {

    private String uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Long office;
    private String role;

    public DoctorModel(Doctor doctor) {
        this.uuid = doctor.getUuid();
        this.firstName = doctor.getFirstName();
        this.lastName = doctor.getLastName();
        this.email = doctor.getEmail();
        this.phoneNumber = doctor.getPhoneNumber();
        this.office = doctor.getOffice();
        this.role = doctor.getRole();
    }

    public Doctor toEntity() {
        Doctor doctor = new Doctor();
        doctor.setFirstName(this.firstName);
        doctor.setLastName(this.lastName);
        doctor.setEmail(this.email);
        doctor.setPhoneNumber(this.phoneNumber);
        doctor.setOffice(this.office);
        doctor.setRole(this.role);
        return doctor;
    }
}
