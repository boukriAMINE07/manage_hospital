package com.boukriinfo.manage_hospital.web;

import com.boukriinfo.manage_hospital.entities.Appointment;
import com.boukriinfo.manage_hospital.entities.Doctor;
import com.boukriinfo.manage_hospital.services.DoctorService;
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
public class DoctorRestController {
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public ResponseEntity<Map<String, Object>> getDoctors(@RequestParam(required = false) String name
                                 , @RequestParam(name = "page",defaultValue = "0") int page,
                                                          @RequestParam(name = "size",defaultValue = "6") int size) {
        try {
            Page<Doctor> doctorPage;
            List<Doctor> doctors = new ArrayList<Doctor>();
            if (name == null || name.isEmpty()) {
                doctorPage = doctorService.getAllDoctors(page, size);
            } else {
                doctorPage = doctorService.getAllDoctorsWithNameAndPage(name, page, size);
            }
            doctors = doctorPage.getContent();
            Map<String, Object> response = new HashMap<>();
            response.put("doctors", doctors);
            response.put("currentPage", doctorPage.getNumber());
            response.put("totalItems", doctorPage.getTotalElements());
            response.put("totalPages", doctorPage.getTotalPages());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);

        }
    }
    @GetMapping("/doctors/all")
    public List<Doctor> getDoctor() {
        return doctorService.getAllDoctors();
    }
    @GetMapping("/doctors/{id}")
    public Doctor getDoctor(@PathVariable(name = "id") Long id) {
        return doctorService.getDoctor(id);
    }
    @PostMapping("/doctors")
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }
    @PutMapping("/doctors/{id}")
    public Doctor updateDoctor(@PathVariable(name = "id") Long id,
                               @RequestBody Doctor doctor) {
        doctor.setId(id);
        return doctorService.updateDoctor(doctor);
    }
    @DeleteMapping("/doctors/{id}")
    public void deleteDoctor(@PathVariable(name = "id") Long id) {
        doctorService.deleteDoctor(id);
    }

}
