package cz.upce.bvwa2.service;

import cz.upce.bvwa2.model.workinghours.WorkingHoursCreateModel;
import cz.upce.bvwa2.model.workinghours.WorkingHoursModel;

public interface WorkingHoursService extends AbstractService<WorkingHoursModel> {
    void create(WorkingHoursCreateModel workingHoursModel);
    void deleteByUuid(String uuid);
}
