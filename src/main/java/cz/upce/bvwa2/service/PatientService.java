package cz.upce.bvwa2.service;

import cz.upce.bvwa2.model.auth.SignUpModel;
import cz.upce.bvwa2.model.patient.PatientCreateModel;
import cz.upce.bvwa2.model.patient.PatientModel;
import cz.upce.bvwa2.model.patient.PatientUpdateModel;

public interface PatientService extends AbstractService<PatientModel> {
    void create(SignUpModel signUpModel);

    void update(PatientUpdateModel model);

    void create(PatientCreateModel patientCreateModel);
    void deleteByUuid(String uuid);
}
