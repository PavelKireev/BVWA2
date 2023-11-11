package cz.upce.bvwa2.service;

import cz.upce.bvwa2.db.entity.Patient;
import cz.upce.bvwa2.db.repository.PatientRepository;
import cz.upce.bvwa2.model.auth.SignUpModel;
import cz.upce.bvwa2.model.patient.PatientModel;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    @SneakyThrows
    public PatientModel getOneByUuid(String uuid) {
        return new PatientModel(patientRepository.findByUuid(uuid).orElseThrow(EntityExistsException::new));
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
        patientRepository.save(new Patient());
    }
}
