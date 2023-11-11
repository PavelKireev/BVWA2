package cz.upce.bvwa2.service;

import cz.upce.bvwa2.model.appointment.AppointmentModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Override
    public AppointmentModel getOneByUuid(String uuid) {
        return null;
    }

    @Override
    public List<AppointmentModel> getAll() {
        return null;
    }
}
