package cz.upce.bvwa2.model.doctor;

import cz.upce.bvwa2.db.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorCreateModel {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;
    private Long office;
    private String role;

    public Doctor toEntity() {
        Doctor doctor = new Doctor();
        doctor.getUser().setFirstName(this.firstName);
        doctor.getUser().setLastName(this.lastName);
        doctor.getUser().setPassword(this.password);
        doctor.getUser().setEmail(this.email);
        doctor.getUser().setPhoneNumber(this.phoneNumber);
        doctor.setOfficeNumber(this.office);
        doctor.getUser().setRole("DOCTOR");
        return doctor;
    }



}
