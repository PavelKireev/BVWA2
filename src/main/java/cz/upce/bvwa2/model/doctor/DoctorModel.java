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
    private Long officeNumber;
    private String role;

    public DoctorModel(Doctor doctor) {
        this.uuid = doctor.getUser().getUuid();
        this.firstName = doctor.getUser().getFirstName();
        this.lastName = doctor.getUser().getLastName();
        this.email = doctor.getUser().getEmail();
        this.phoneNumber = doctor.getUser().getPhoneNumber();
        this.officeNumber = doctor.getOfficeNumber();
        this.role = doctor.getUser().getRole();
    }

    public Doctor toEntity() {
        Doctor doctor = new Doctor();
        doctor.getUser().setFirstName(this.firstName);
        doctor.getUser().setLastName(this.lastName);
        doctor.getUser().setEmail(this.email);
        doctor.getUser().setPhoneNumber(this.phoneNumber);
        doctor.setOfficeNumber(this.officeNumber);
        doctor.getUser().setRole(this.role);
        return doctor;
    }
}
