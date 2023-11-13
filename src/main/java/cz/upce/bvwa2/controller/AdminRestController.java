package cz.upce.bvwa2.controller;

import cz.upce.bvwa2.model.admin.AdminModel;
import cz.upce.bvwa2.service.AdminService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminRestController {

    private final AdminService adminService;

    @GetMapping("all")
    public List<AdminModel> getAllAdmins() {
        return adminService.getAll()
                           .stream()
                           .toList();
    }
}
