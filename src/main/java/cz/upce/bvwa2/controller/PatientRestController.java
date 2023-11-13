package cz.upce.bvwa2.controller;

import cz.upce.bvwa2.model.patient.PatientCreateModel;
import cz.upce.bvwa2.model.patient.PatientModel;
import cz.upce.bvwa2.model.patient.PatientUpdateModel;
import cz.upce.bvwa2.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patient")
@RequiredArgsConstructor
public class PatientRestController {

    private final PatientService patientService;

    @GetMapping("list")
    public List<PatientModel> list(){
        return patientService.getAll();
    }

    @GetMapping("{uuid}")
    public PatientModel getOne(
        @PathVariable String uuid
    ) {
        return patientService.getOneByUuid(uuid);
    }

    @PostMapping("create")
    public void create(
        @RequestBody PatientCreateModel model
    ) {
        patientService.create(model);
    }

    @PostMapping("update")
    public void update(
        @RequestBody PatientUpdateModel model
    ){
        patientService.update(model);
    }

    @DeleteMapping("delete/{uuid}")
    public void delete(
        @PathVariable String uuid
    ) {
        patientService.deleteByUuid(uuid);
    }

}
