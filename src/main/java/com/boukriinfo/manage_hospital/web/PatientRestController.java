package com.boukriinfo.manage_hospital.web;

import com.boukriinfo.manage_hospital.entities.Patient;
import com.boukriinfo.manage_hospital.repositories.PatientRepository;
import com.boukriinfo.manage_hospital.services.PatientService;
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
public class PatientRestController {
    private PatientService patientService;

    @GetMapping("/patients/all")
    public List<Patient> getPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients")
    public ResponseEntity<Map<String, Object>> getPatients(@RequestParam(required = false) String name
            , @RequestParam(name = "page", defaultValue = "0") int page,
                                                           @RequestParam(name = "size", defaultValue = "8") int size) {
        try {
            Page<Patient> patientPage;
            List<Patient> patients = new ArrayList<Patient>();
            if (name == null || name.isEmpty()) {
                patientPage = patientService.getAllPatients(page, size);
            } else {
                patientPage = patientService.getAllPatientsWithNameAndPage(name, page, size);
            }
            patients = patientPage.getContent();
            Map<String, Object> response = new HashMap<>();
            response.put("patients", patients);
            response.put("currentPage", patientPage.getNumber());
            response.put("totalItems", patientPage.getTotalElements());
            response.put("totalPages", patientPage.getTotalPages());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);

        }

    }


    @GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable(name = "id") Long id) {
        return patientService.getPatient(id);
    }

    @PostMapping("/patients")
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @PutMapping("/patients/{id}")
    public Patient updatePatient(@PathVariable(name = "id") Long id,
                                 @RequestBody Patient patient) {
        patient.setId(id);
        return patientService.updatePatient(patient);
    }

    @DeleteMapping("/patients/{id}")
    public void deletePatient(@PathVariable(name = "id") Long id) {
        patientService.deletePatient(id);
    }
}
