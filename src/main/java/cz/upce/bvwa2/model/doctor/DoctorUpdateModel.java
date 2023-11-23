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
    private Long officeNumber;
    private String role;

    public Doctor toEntity(Doctor doctor) {
        doctor.getUser().setFirstName(this.firstName);
        doctor.getUser().setLastName(this.lastName);
        doctor.getUser().setPhoneNumber(this.phoneNumber);
        doctor.setOfficeNumber(this.officeNumber);
        return doctor;
    }
}
