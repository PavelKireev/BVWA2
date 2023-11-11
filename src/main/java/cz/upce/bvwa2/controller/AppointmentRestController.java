package cz.upce.bvwa2.controller;

import cz.upce.bvwa2.model.appointment.AppointmentModel;
import cz.upce.bvwa2.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appointment")
@RequiredArgsConstructor
public class AppointmentRestController {

    private final AppointmentService appointmentService;

    @GetMapping("list")
    public List<AppointmentModel> list(){
        return appointmentService.getAll();
    }

    @GetMapping("{uuid}")
    public AppointmentModel getOne(
        @PathVariable String uuid
    ) {
        return appointmentService.getOneByUuid(uuid);
    }

    @PostMapping("create")
    public void create(
        @RequestBody String s
    ) {

    }

    @PostMapping("update")
    public void update(
        @RequestBody String s
    ){

    }

    @DeleteMapping("delete/{uuid}")
    public void delete(
        @PathVariable String uuid
    ) {

    }
}
