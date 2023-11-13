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
        doctor.setUuid(this.uuid);
        doctor.setFirstName(this.firstName);
        doctor.setLastName(this.lastName);
        doctor.setEmail(this.email);
        doctor.setPhoneNumber(this.phoneNumber);
        doctor.setOffice(this.office);
        doctor.setRole(this.role);
        return doctor;
    }
}
