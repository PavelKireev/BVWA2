package cz.upce.bvwa2.service;

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
    public AdminModel getOneByUuid(String uuid) {
        return repository.findByUuid(uuid)
                         .map(AdminModel::new)
                         .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<AdminModel> getAll() {
        return repository.findAll()
                         .stream()
                         .map(AdminModel::new)
                         .toList();
    }

}
