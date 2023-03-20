package com.boukriinfo.manage_hospital.web;

import com.boukriinfo.manage_hospital.entities.Administrator;
import com.boukriinfo.manage_hospital.entities.Patient;
import com.boukriinfo.manage_hospital.services.AdministratorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class AdministratorRestController {
    private AdministratorService administratorService;

    @GetMapping("/administrators")
    public ResponseEntity<Map<String, Object>> getAdministrators(@RequestParam(required = false) String name
            , @RequestParam(name = "page", defaultValue = "0") int page,
                                                           @RequestParam(name = "size", defaultValue = "6") int size) {
        try {
            Page<Administrator> administratorPage;
            List<Administrator> administrators = new ArrayList<Administrator>();
            if (name == null || name.isEmpty()) {
                administratorPage = administratorService.getAllAdministrators(page, size);
            } else {
                administratorPage = administratorService.getAllAdministratorsWithNameAndPage(name, page, size);
            }
            administrators = administratorPage.getContent();
            Map<String, Object> response = new HashMap<>();
            response.put("administrators", administrators);
            response.put("currentPage", administratorPage.getNumber());
            response.put("totalItems", administratorPage.getTotalElements());
            response.put("totalPages", administratorPage.getTotalPages());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);

        }

    }
    @GetMapping("/administrators/all")
    public List<Administrator> getAllAdministrators() {
        return administratorService.getAdministrators();
    }

    @GetMapping("/administrators/{id}")
    public Administrator getAdministratorById(@PathVariable(name = "id") Long id) {
        return administratorService.getAdministrator(id);
    }

    @PostMapping("/administrators")
    public Administrator saveAdministrator(@RequestBody Administrator administrator) {
        return administratorService.saveAdministrator(administrator);
    }

    @PutMapping("/administrators/{id}")
    public Administrator updateAdministrator(@PathVariable(name = "id") Long id,
                                             @RequestBody Administrator administrator) {
        administrator.setId(id);
        return administratorService.updateAdministrator(administrator);
    }

    @DeleteMapping("/administrators/{id}")
    public void deleteAdministrator(@PathVariable(name = "id") Long id) {
        administratorService.deleteAdministrator(id);
    }

}