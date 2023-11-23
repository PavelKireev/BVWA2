package cz.upce.bvwa2.service;

import cz.upce.bvwa2.db.entity.WorkingHours;
import cz.upce.bvwa2.db.repository.DoctorRepository;
import cz.upce.bvwa2.db.repository.UserRepository;
import cz.upce.bvwa2.db.repository.WorkingHoursRepository;
import cz.upce.bvwa2.model.workinghours.WorkingHoursCreateModel;
import cz.upce.bvwa2.model.workinghours.WorkingHoursModel;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkingHoursServiceImpl implements WorkingHoursService {

    private final WorkingHoursRepository workingHoursRepository;
    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;

    @Override
    public WorkingHoursModel getOneByUuid(String uuid) {
        WorkingHours workingHours = workingHoursRepository.findByUuid(uuid)
                                                          .orElseThrow();
        return WorkingHoursModel.builder()
                                .uuid(workingHours.getUuid())
                                .hourFrom(workingHours.getHourFrom())
                                .hoursCount(workingHours.getHoursCount())
                                .dayOfWeek(workingHours.getDayOfWeek())
                                .doctorName(workingHours.getDoctor().getFirstName() + " " +
                                            workingHours.getDoctor().getLastName())
                                .doctorUuid(workingHours.getDoctor().getUuid()).build();
    }

    @Override
    public List<WorkingHoursModel> getAll() {
        return workingHoursRepository.findAll()
                                     .stream()
                                     .map(
                                         workingHours -> WorkingHoursModel.builder()
                                                                          .uuid(workingHours.getUuid())
                                                                          .hourFrom(workingHours.getHourFrom())
                                                                          .hoursCount(workingHours.getHoursCount())
                                                                          .dayOfWeek(workingHours.getDayOfWeek())
                                                                          .doctorName(workingHours.getDoctor()
                                                                                                  .getFirstName() +
                                                                                      " " +
                                                                                     workingHours.getDoctor()
                                                                                                 .getLastName())
                                                                         .doctorUuid(workingHours.getDoctor()
                                                                                                 .getUuid())
                                                                         .build())
                                     .toList();
    }

    @Override
    public List<WorkingHoursModel> create(WorkingHoursCreateModel model) {
        WorkingHours workingHours = WorkingHours.builder()
                                                .doctor(userRepository.findByUuid(model.getDoctorUuid())
                                                                      .orElseThrow())
                                                .hourFrom(model.getHourFrom())
                                                .hoursCount(model.getHoursCount())
                                                .dayOfWeek(model.getDayOfWeek())
                                                .build();
        workingHoursRepository.save(workingHours);
        return workingHoursRepository.findAllByDoctorUuid(model.getDoctorUuid())
                                     .stream()
                                     .map(WorkingHoursModel::new)
                                     .toList();
    }

    @Override
    @Transactional
    public List<WorkingHoursModel> deleteByUuid(String uuid) {
        String doctorUuid = workingHoursRepository.findByUuid(uuid)
                                                  .orElseThrow(EntityExistsException::new)
                                                  .getDoctor()
                                                  .getUuid();
        workingHoursRepository.deleteByUuid(uuid);
        return workingHoursRepository.findAllByDoctorUuid(doctorUuid)
                                     .stream()
                                     .map(WorkingHoursModel::new)
                                     .toList();
    }

    @Override
    public List<WorkingHoursModel> getAllByDoctorUuid(String doctorUuid) {
        return workingHoursRepository.findAllByDoctorUuid(doctorUuid)
                                     .stream()
                                     .map(
                                         workingHours -> WorkingHoursModel.builder()
                                                                          .uuid(workingHours.getUuid())
                                                                          .hourFrom(workingHours.getHourFrom())
                                                                          .hoursCount(workingHours.getHoursCount())
                                                                          .dayOfWeek(workingHours.getDayOfWeek())
                                                                          .doctorName(workingHours.getDoctor()
                                                                                                  .getFirstName() +
                                                                                      " " +
                                                                                     workingHours.getDoctor()
                                                                                                 .getLastName())
                                                                          .doctorUuid(workingHours.getDoctor()
                                                                                                  .getUuid())
                                                                          .build())
                                     .toList();
    }
}
