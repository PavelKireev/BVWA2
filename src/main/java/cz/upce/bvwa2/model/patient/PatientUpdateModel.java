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

    public Patient toEntity(Patient patient) {
        patient.getUser().setUuid(this.uuid);
        patient.getUser().setFirstName(this.firstName);
        patient.getUser().setLastName(this.lastName);
        patient.getUser().setEmail(this.email);
        patient.getUser().setPhoneNumber(this.phoneNumber);
        patient.setBirthday(this.birthday);
        return patient;
    }
}
