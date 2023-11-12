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

    @GetMapping("all")
    public List<AppointmentModel> list(){
        return appointmentService.getAll();
    }

    @GetMapping("{uuid}")
    public AppointmentModel getOne(
        @PathVariable String uuid
    ) {
        return appointmentService.getOneByUuid(uuid);
    }

    @GetMapping("patient")
    public List<AppointmentModel> patient(
        @RequestParam String patientUuid
    ) {
        return appointmentService.getAllByPatientUuid(patientUuid);
    }

    @GetMapping("doctor")
    public List<AppointmentModel> doctor(
        @RequestParam String doctorUuid
    ) {
        return appointmentService.getAllByDoctorUuid(doctorUuid);
    }

    @PostMapping("create")
    public void create(
        @RequestBody AppointmentModel model
    ) {

    }

    @DeleteMapping("delete/{uuid}")
    public void delete(
        @PathVariable String uuid
    ) {

    }
}
