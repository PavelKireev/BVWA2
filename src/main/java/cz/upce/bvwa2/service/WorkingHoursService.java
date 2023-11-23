package cz.upce.bvwa2.service;

import cz.upce.bvwa2.model.workinghours.WorkingHoursCreateModel;
import cz.upce.bvwa2.model.workinghours.WorkingHoursModel;

import java.util.List;

public interface WorkingHoursService extends AbstractService<WorkingHoursModel> {
    List<WorkingHoursModel> create(WorkingHoursCreateModel workingHoursModel);
    List<WorkingHoursModel> deleteByUuid(String uuid);
    List<WorkingHoursModel> getAllByDoctorUuid(String doctorUuid);
}
