package cz.upce.bvwa2.service;

import cz.upce.bvwa2.db.entity.Patient;
import cz.upce.bvwa2.db.repository.PatientRepository;
import cz.upce.bvwa2.model.auth.SignUpModel;
import cz.upce.bvwa2.model.patient.PatientCreateModel;
import cz.upce.bvwa2.model.patient.PatientModel;
import cz.upce.bvwa2.model.patient.PatientUpdateModel;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PasswordEncoder passwordEncoder;
    private final PatientRepository patientRepository;

    @Override
    @SneakyThrows
    public PatientModel getOneByUuid(String uuid) {
        return new PatientModel(patientRepository.findByUserUuid(uuid).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<PatientModel> getAll() {
        return patientRepository.findAll()
                                .stream()
                                .map(PatientModel::new)
                                .toList();
    }

    @Override
    public void create(SignUpModel signUpModel) {
        Patient patient = new Patient();
        patient.getUser().setFirstName(signUpModel.getFirstName());
        patient.getUser().setLastName(signUpModel.getLastName());
        patient.getUser().setEmail(signUpModel.getEmail());
        patient.getUser().setPassword(signUpModel.getPassword());
        patient.getUser().setRole("PATIENT");
        patientRepository.save(patient);
    }

    @Override
    public void update(PatientUpdateModel model) {
        Patient patient = patientRepository.findByUserUuid(model.getUuid())
                                           .orElseThrow(EntityNotFoundException::new);
        patientRepository.save(model.toEntity(patient));
    }

    @Override
    public void create(PatientCreateModel patientCreateModel) {
        patientCreateModel.setPassword(passwordEncoder.encode(patientCreateModel.getPassword()));
        patientRepository.save(patientCreateModel.toEntity());
    }

    @Override
    public void deleteByUuid(String uuid) {
        patientRepository.deleteByUserUuid(uuid);
    }
}
