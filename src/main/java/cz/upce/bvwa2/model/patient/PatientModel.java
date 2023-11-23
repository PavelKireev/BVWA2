package cz.upce.bvwa2.model.patient;

import com.fasterxml.jackson.annotation.JsonFormat;
import cz.upce.bvwa2.db.entity.Patient;
import cz.upce.bvwa2.model.UserModel;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class PatientModel {

    @Getter
    @Setter
    private String uuid;
    @Getter
    private String firstName;
    @Getter
    private String lastName;
    @Getter
    private String email;
    @Getter
    private String phoneNumber;
    private Date birthDate;

    public PatientModel(Patient entity) {
        this.uuid = entity.getUser().getUuid();
        this.firstName = entity.getUser().getFirstName();
        this.lastName = entity.getUser().getLastName();
        this.email = entity.getUser().getEmail();
        this.phoneNumber = entity.getUser().getPhoneNumber();
        this.birthDate = entity.getBirthday();
    }

    public PatientModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PatientModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PatientModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public PatientModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getBirthDate() {
        return birthDate;
    }

    public PatientModel setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }
}
