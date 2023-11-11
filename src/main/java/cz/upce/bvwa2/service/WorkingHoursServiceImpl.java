package cz.upce.bvwa2.service;

import cz.upce.bvwa2.model.workinghours.WorkingHoursModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingHoursServiceImpl implements WorkingHoursService {
    @Override
    public WorkingHoursModel getOneByUuid(String uuid) {
        return null;
    }

    @Override
    public List<WorkingHoursModel> getAll() {
        return null;
    }
}
