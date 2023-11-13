package cz.upce.bvwa2.model.patient;

import cz.upce.bvwa2.db.entity.Patient;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class PatientUpdateModel {
    private String uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date birthday;

    public Patient toEntity() {
        Patient patient = new Patient();
        patient.setUuid(this.uuid);
        patient.setFirstName(this.firstName);
        patient.setLastName(this.lastName);
        patient.setEmail(this.email);
        patient.setPhoneNumber(this.phoneNumber);
        patient.setBirthday(this.birthday);
        return patient;
    }
}
