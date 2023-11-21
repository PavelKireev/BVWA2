package cz.upce.bvwa2.model.patient;

import cz.upce.bvwa2.db.entity.Patient;
import cz.upce.bvwa2.model.UserModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PatientModel extends UserModel {

    public PatientModel(Patient entity) {
        this.firstName = entity.getUser().getFirstName();
        this.lastName = entity.getUser().getLastName();
        this.email = entity.getUser().getEmail();
        this.phoneNumber = entity.getUser().getPhoneNumber();
    }
}
