package cz.upce.bvwa2.service;

import cz.upce.bvwa2.model.doctor.DoctorModel;
import cz.upce.bvwa2.model.doctor.DoctorUpdateModel;

public interface DoctorService extends AbstractService<DoctorModel> {
    void create(DoctorModel model);
    void update(DoctorUpdateModel model);
    void deleteByUuid(String uuid);
}
