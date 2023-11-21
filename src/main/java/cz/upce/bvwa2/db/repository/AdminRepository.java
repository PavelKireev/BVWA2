package cz.upce.bvwa2.db.repository;

import cz.upce.bvwa2.db.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUserUuid(String uuid);
    void deleteByUserUuid(String uuid);
}
