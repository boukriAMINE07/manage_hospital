package com.boukriinfo.manage_hospital.web;

import com.boukriinfo.manage_hospital.entities.Consultation;
import com.boukriinfo.manage_hospital.services.ConsultationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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
public class ConsultationRestController {
    private ConsultationService consultationService;

    @GetMapping("/consultations")
    public ResponseEntity<Map<String, Object>> getConsultations(@RequestParam(required = false) String name
                                      , @RequestParam(name = "page",defaultValue = "0") int page,
                                                                @RequestParam(name = "size",defaultValue = "6") int size) {
        try {
            Page<Consultation> consultationPage;
            List<Consultation> consultations = new ArrayList<Consultation>();
            if (name == null || name.isEmpty()) {
                consultationPage = consultationService.getAllConsultations(page, size);
            } else {
                consultationPage = consultationService.getAllConsultationsWithNameAndPage(name, page, size);
            }
            consultations = consultationPage.getContent();


            Map<String, Object> response = new HashMap<>();
            response.put("consultations", consultations);
            response.put("currentPage", consultationPage.getNumber());
            response.put("totalItems", consultationPage.getTotalElements());
            response.put("totalPages", consultationPage.getTotalPages());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @GetMapping("/consultations/{id}")
    public Consultation getConsultation(@PathVariable(name = "id") Long id) {
        return consultationService.getConsultation(id);
    }
    @PostMapping("/consultations")
    public Consultation saveConsultation(@RequestBody Consultation consultation) {
        return consultationService.saveConsultation(consultation);
    }
    @PutMapping("/consultations/{id}")
    public Consultation updateConsultation(@PathVariable(name = "id") Long id,
                                           @RequestBody Consultation consultation) {
        consultation.setId(id);
        return consultationService.updateConsultation(consultation);
    }
    @DeleteMapping("/consultations/{id}")
    public void deleteConsultation(@PathVariable(name = "id") Long id) {
        consultationService.deleteConsultation(id);
    }

}
