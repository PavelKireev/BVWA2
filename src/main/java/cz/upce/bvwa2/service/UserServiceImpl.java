package cz.upce.bvwa2.service;

import cz.upce.bvwa2.db.entity.User;
import cz.upce.bvwa2.db.repository.AdminRepository;
import cz.upce.bvwa2.db.repository.DoctorRepository;
import cz.upce.bvwa2.db.repository.PatientRepository;
import cz.upce.bvwa2.db.repository.UserRepository;
import cz.upce.bvwa2.model.user.UserCreateModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final AdminRepository adminRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public void create(UserCreateModel model) {

        User user = new User();
        
        repository.save(user);
    }
}
