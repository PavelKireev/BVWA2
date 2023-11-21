package cz.upce.bvwa2.service;

import cz.upce.bvwa2.db.repository.AdminRepository;
import cz.upce.bvwa2.model.admin.AdminCreateModel;
import cz.upce.bvwa2.model.admin.AdminModel;
import cz.upce.bvwa2.model.admin.AdminUpdateModel;
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
        return repository.findByUserUuid(uuid)
                         .map(AdminModel::fromEntity)
                         .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<AdminModel> getAll() {
        return repository.findAll()
                         .stream()
                         .map(AdminModel::fromEntity)
                         .toList();
    }

    @Override
    public void create(AdminCreateModel adminModel) {
        repository.save(adminModel.toEntity());
    }

    @Override
    public void delete(String uuid) {
        repository.deleteByUserUuid(uuid);
    }

    @Override
    public void update(AdminUpdateModel adminModel) {
        repository.save(adminModel.toEntity());
    }

}
