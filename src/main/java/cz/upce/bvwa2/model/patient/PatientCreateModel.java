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

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class PatientCreateModel {
    @Getter
    private String firstName;
    @Getter
    private String lastName;
    @Getter
    private String email;
    @Getter
    private String phoneNumber;
    @Getter
    private String password;
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonSerialize(using = DateSerializer.class)
    private Date birthDate;
    @Getter
    private String role;


    public Patient toEntity() {
        Patient patient = new Patient();
        patient.getUser().setFirstName(this.firstName);
        patient.getUser().setLastName(this.lastName);
        patient.getUser().setEmail(this.email);
        patient.getUser().setPhoneNumber(this.phoneNumber);
        patient.getUser().setPassword(this.password);
        patient.getUser().setRole("PATIENT");
        patient.setBirthday(getBirthDate());
        return patient;
    }

    public PatientCreateModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PatientCreateModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PatientCreateModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public PatientCreateModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public PatientCreateModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getBirthDate() {
        return birthDate;
    }


    public PatientCreateModel setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PatientCreateModel setRole(String role) {
        this.role = role;
        return this;
    }
}
