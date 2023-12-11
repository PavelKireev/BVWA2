package cz.upce.bvwa2.controller;

import cz.upce.bvwa2.model.doctor.DoctorCreateModel;
import cz.upce.bvwa2.model.doctor.DoctorModel;
import cz.upce.bvwa2.model.doctor.DoctorUpdateModel;
import cz.upce.bvwa2.model.patient.PatientModel;
import cz.upce.bvwa2.service.DoctorService;
import cz.upce.bvwa2.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/doctor")
@RequiredArgsConstructor
public class DoctorRestController {
    private final DoctorService doctorService;
    @GetMapping("list")
    public List<DoctorModel> list() {
        return doctorService.getAll();
    }

    @GetMapping("{uuid}")
    public DoctorModel getOne(
        @PathVariable String uuid
    ) {
        return doctorService.getOneByUuid(uuid);
    }

    @PostMapping("create")
    public void create(
        @RequestBody DoctorCreateModel model
    ) {
        doctorService.create(model);
    }

    @PostMapping("update")
    public void update(
        @RequestBody DoctorUpdateModel model
    ) {
        doctorService.update(model);
    }

    @DeleteMapping("delete/{uuid}")
    public void delete(
        @PathVariable String uuid
    ) {
        doctorService.deleteByUuid(uuid);
    }

}
