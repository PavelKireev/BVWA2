package cz.upce.bvwa2.model.patient;

import cz.upce.bvwa2.db.entity.Patient;
import lombok.Data;

import java.util.Date;

@Data
public class PatientCreateModel {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private Date birthday;
    private String role;


    public Patient toEntity() {
        Patient patient = new Patient();
        patient.setFirstName(this.firstName);
        patient.setLastName(this.lastName);
        patient.setEmail(this.email);
        patient.setPhoneNumber(this.phoneNumber);
        patient.setPassword(this.password);
        patient.setBirthday(this.birthday);
        patient.setRole(this.role);
        return patient;
    }
}
