package cz.upce.bvwa2.service;

import cz.upce.bvwa2.db.entity.Admin;
import cz.upce.bvwa2.db.repository.AdminRepository;
import cz.upce.bvwa2.model.admin.AdminModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository repository;

    @Override
    public Admin getOneByUuid(String uuid) {
        return repository.findByUuid(uuid)
                         .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Admin> getAll() {
        return repository.findAll();
    }
}
