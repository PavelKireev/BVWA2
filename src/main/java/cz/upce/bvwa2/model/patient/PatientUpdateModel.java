package cz.upce.bvwa2.model.patient;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import cz.upce.bvwa2.db.entity.Patient;
import lombok.Data;

import java.util.Date;

@Data
public class PatientUpdateModel {
    private String uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonSerialize(using = DateSerializer.class)
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
