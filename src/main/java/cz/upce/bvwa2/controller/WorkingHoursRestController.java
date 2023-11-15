package cz.upce.bvwa2.controller;

import cz.upce.bvwa2.model.workinghours.WorkingHoursCreateModel;
import cz.upce.bvwa2.model.workinghours.WorkingHoursModel;
import cz.upce.bvwa2.service.WorkingHoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("working-hours")
@RequiredArgsConstructor
public class WorkingHoursRestController {

    private final WorkingHoursService workingHoursService;

    @PostMapping("create")
    public void create(
        @RequestBody WorkingHoursCreateModel model
    ) {
        workingHoursService.create(model);
    }

    @GetMapping("list")
    public List<WorkingHoursModel> list(
        @RequestParam String doctorUuid
    ) {
        return workingHoursService.getAllByDoctorUuid(doctorUuid);
    }

    @GetMapping("delete")
    public void delete(
        @RequestParam String uuid
    ) {
        workingHoursService.deleteByUuid(uuid);
    }
}
