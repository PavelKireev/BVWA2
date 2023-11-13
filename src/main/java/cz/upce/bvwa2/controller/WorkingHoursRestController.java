package cz.upce.bvwa2.controller;

import cz.upce.bvwa2.model.workinghours.WorkingHoursCreateModel;
import cz.upce.bvwa2.service.WorkingHoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
