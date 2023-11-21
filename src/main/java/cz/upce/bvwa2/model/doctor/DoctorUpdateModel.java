package cz.upce.bvwa2.model.doctor;

import cz.upce.bvwa2.db.entity.Doctor;
import lombok.Data;

@Data
public class DoctorUpdateModel {

    private String uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Long office;
    private String role;

    public Doctor toEntity() {
        Doctor doctor = new Doctor();
        doctor.getUser().setUuid(this.uuid);
        doctor.getUser().setFirstName(this.firstName);
        doctor.getUser().setLastName(this.lastName);
        doctor.getUser().setEmail(this.email);
        doctor.getUser().setPhoneNumber(this.phoneNumber);
        doctor.setOfficeNumber(this.office);
        doctor.getUser().setRole(this.role);
        return doctor;
    }
}
