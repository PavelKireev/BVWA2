package cz.upce.bvwa2.service;

import cz.upce.bvwa2.db.repository.DoctorRepository;
import cz.upce.bvwa2.model.doctor.DoctorCreateModel;
import cz.upce.bvwa2.model.doctor.DoctorModel;
import cz.upce.bvwa2.model.doctor.DoctorUpdateModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public DoctorModel getOneByUuid(String uuid) {
        return null;
    }

    @Override
    public List<DoctorModel> getAll() {
        return repository.findAll()
                         .stream()
                         .map(DoctorModel::new)
                         .toList();
    }

    @Override
    public void create(DoctorCreateModel model) {
        model.setPassword(passwordEncoder.encode(model.getPassword()));
        repository.save(model.toEntity());
    }

    @Override
    public void update(DoctorUpdateModel model) {
        repository.save(model.toEntity());
    }

    @Override
    public void deleteByUuid(String uuid) {
        repository.deleteByUserUuid(uuid);
    }
}
