package cz.upce.bvwa2.db.repository;

import cz.upce.bvwa2.db.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByUuid(String uuid);
    void deleteByUuid(String uuid);
}
