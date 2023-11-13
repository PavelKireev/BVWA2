package cz.upce.bvwa2.db.repository;

import cz.upce.bvwa2.db.entity.WorkingHours;
import cz.upce.bvwa2.model.workinghours.WorkingHoursModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkingHoursRepository extends JpaRepository<WorkingHours, Long> {

    List<WorkingHours> findAllByDoctorUuid(String doctorUuid);
    Optional<WorkingHours> findByUuid(String uuid);
    void deleteByUuid(String uuid);

}
