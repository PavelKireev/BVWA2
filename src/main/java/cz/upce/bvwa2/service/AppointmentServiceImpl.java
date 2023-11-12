package cz.upce.bvwa2.service;

import cz.upce.bvwa2.db.repository.AppointmentRepository;
import cz.upce.bvwa2.model.appointment.AppointmentModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;

    @Override
    public AppointmentModel getOneByUuid(String uuid) {
        return new AppointmentModel(repository.findByUuid(uuid)
                                              .orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<AppointmentModel> getAllByDoctorUuid(String doctorUuid) {
        return repository.findAppointmentByDoctorUuid(doctorUuid)
                         .stream()
                         .map(AppointmentModel::new)
                         .toList();
    }

    @Override
    public List<AppointmentModel> getAllByPatientUuid(String patientUuid) {
        return repository.findAppointmentByPatientUuid(patientUuid)
                         .stream()
                         .map(AppointmentModel::new)
                         .toList();
    }

    @Override
    public List<AppointmentModel> getAll() {
        return repository.findAll()
                         .stream()
                         .map(AppointmentModel::new)
                         .toList();
    }

    @Override
    public void deleteByUuid(String uuid) {
        repository.deleteByUuid(uuid);
    }

    @Override
    public void create(AppointmentModel model) {

    }
}
