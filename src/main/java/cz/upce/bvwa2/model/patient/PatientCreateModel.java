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
        patient.getUser().setFirstName(this.firstName);
        patient.getUser().setLastName(this.lastName);
        patient.getUser().setEmail(this.email);
        patient.getUser().setPhoneNumber(this.phoneNumber);
        patient.getUser().setPassword(this.password);
        patient.getUser().setRole("PATIENT");
        patient.setBirthday(this.birthday);
        return patient;
    }
}
