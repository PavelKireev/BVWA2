package cz.upce.bvwa2.service;

import cz.upce.bvwa2.model.appointment.AppointmentModel;

import java.util.List;

public interface AppointmentService extends AbstractService<AppointmentModel> {
    void deleteByUuid(String uuid);
    void create(AppointmentModel model);
    List<AppointmentModel> getAllByDoctorUuid(String doctorUuid);
    List<AppointmentModel> getAllByPatientUuid(String patientUuid);

}
