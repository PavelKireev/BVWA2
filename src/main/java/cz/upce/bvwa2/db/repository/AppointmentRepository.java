package cz.upce.bvwa2.db.repository;

import cz.upce.bvwa2.db.entity.Appointment;
import cz.upce.bvwa2.model.appointment.AppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    void deleteByUuid(String uuid);
    Optional<Appointment> findByUuid(String uuid);
    List<Appointment> findAppointmentByDoctorUuid(String doctorUuid);
    List<Appointment> findAppointmentByPatientUuid(String patientUuid);
}
