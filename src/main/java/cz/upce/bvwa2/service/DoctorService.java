package cz.upce.bvwa2.service;

import cz.upce.bvwa2.model.doctor.DoctorCreateModel;
import cz.upce.bvwa2.model.doctor.DoctorModel;
import cz.upce.bvwa2.model.doctor.DoctorUpdateModel;

public interface DoctorService extends AbstractService<DoctorModel> {
    void create(DoctorCreateModel model);
    void update(DoctorUpdateModel model);
    void deleteByUuid(String uuid);
}
