package cz.upce.bvwa2.service;

import cz.upce.bvwa2.model.auth.SignUpModel;
import cz.upce.bvwa2.model.patient.PatientModel;

public interface PatientService extends AbstractService<PatientModel> {

    void create(SignUpModel signUpModel);
}
