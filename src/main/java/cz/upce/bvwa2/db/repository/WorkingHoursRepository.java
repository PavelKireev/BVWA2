package cz.upce.bvwa2.db.repository;

import cz.upce.bvwa2.db.entity.WorkingHours;
import cz.upce.bvwa2.model.workinghours.WorkingHoursModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkingHoursRepository extends JpaRepository<WorkingHours, Long> {

    List<WorkingHoursModel> findAllByDoctorUuid(String doctorUuid);

}
