package cz.upce.bvwa2.controller;

import cz.upce.bvwa2.model.workinghours.WorkingHoursCreateModel;
import cz.upce.bvwa2.model.workinghours.WorkingHoursModel;
import cz.upce.bvwa2.service.WorkingHoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/working-hours")
@RequiredArgsConstructor
public class WorkingHoursRestController {

    private final WorkingHoursService workingHoursService;

    @PostMapping("create")
    public List<WorkingHoursModel> create(
        @RequestBody WorkingHoursCreateModel model
    ) {
        return workingHoursService.create(model);
    }

    @GetMapping("list")
    public List<WorkingHoursModel> list(
        @RequestParam String doctorUuid
    ) {
        return workingHoursService.getAllByDoctorUuid(doctorUuid);
    }

    @DeleteMapping("delete")
    public List<WorkingHoursModel> delete(
        @RequestParam String uuid
    ) {
        return workingHoursService.deleteByUuid(uuid);
    }
}
