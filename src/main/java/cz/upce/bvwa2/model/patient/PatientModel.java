package cz.upce.bvwa2.model.patient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import cz.upce.bvwa2.db.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonSerialize(using = DateSerializer.class)
    private Date birthDate;
    @Getter
    private String role;

    public PatientModel(Patient entity) {
        this.uuid = entity.getUser().getUuid();
        this.firstName = entity.getUser().getFirstName();
        this.lastName = entity.getUser().getLastName();
        this.email = entity.getUser().getEmail();
        this.phoneNumber = entity.getUser().getPhoneNumber();
        this.birthDate = entity.getBirthday();
        this.role = entity.getUser().getRole();
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

    public PatientModel setRole(String role) {
        this.role = role;
        return this;
    }
}
