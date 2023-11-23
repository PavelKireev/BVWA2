package cz.upce.bvwa2.model.patient;

import com.fasterxml.jackson.annotation.JsonFormat;
import cz.upce.bvwa2.db.entity.Patient;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PatientUpdateModel {
    private String uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private Date birthDate;

    public Patient toEntity(Patient patient) {
        patient.getUser().setUuid(this.uuid);
        patient.getUser().setFirstName(this.firstName);
        patient.getUser().setLastName(this.lastName);
        patient.getUser().setEmail(this.email);
        patient.getUser().setPhoneNumber(this.phoneNumber);
        patient.setBirthday(this.birthDate);
        return patient;
    }
}
