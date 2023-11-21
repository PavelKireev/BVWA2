package cz.upce.bvwa2.controller;

import cz.upce.bvwa2.model.admin.AdminCreateModel;
import cz.upce.bvwa2.model.admin.AdminModel;
import cz.upce.bvwa2.model.admin.AdminUpdateModel;
import cz.upce.bvwa2.service.AdminService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/admin")
public class AdminRestController {

    private final AdminService adminService;

    @GetMapping("{uuid}")
    public AdminModel adminModel(
        @PathVariable String uuid
    ) {
        return adminService.getOneByUuid(uuid);
    }

    @GetMapping("all")
    public List<AdminModel> getAllAdmins() {
        return adminService.getAll()
                           .stream()
                           .toList();
    }

    @PostMapping("create")
    public void createAdmin(
        AdminCreateModel adminModel
    ) {
        adminService.create(adminModel);
    }

    @PostMapping("update")
    public void updateAdmin(
        AdminUpdateModel adminModel
    ) {
        adminService.update(adminModel);
    }
}
