package com.boukriinfo.manage_hospital.web;

import com.boukriinfo.manage_hospital.entities.Administrator;
import com.boukriinfo.manage_hospital.entities.Appointment;
import com.boukriinfo.manage_hospital.services.AppointmentService;
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
public class AppointmentRestController {
    private AppointmentService appointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<Map<String, Object>> getAppointments(@RequestParam(required = false) String name
                                      , @RequestParam(name = "page",defaultValue = "0") int page,
                                      @RequestParam(name = "size",defaultValue = "6") int size) {
        try {
            Page<Appointment> appointmentPage;
            List<Appointment> appointments = new ArrayList<Appointment>();
            if (name == null || name.isEmpty()) {
                appointmentPage = appointmentService.getAllAppointments(page, size);
            } else {
                appointmentPage = appointmentService.getAllAppointmentsWithNameAndPage(name, page, size);
            }
            appointments = appointmentPage.getContent();
            Map<String, Object> response = new HashMap<>();
            response.put("appointments", appointments);
            response.put("currentPage", appointmentPage.getNumber());
            response.put("totalItems", appointmentPage.getTotalElements());
            response.put("totalPages", appointmentPage.getTotalPages());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);

        }
    }
    @GetMapping("/appointments/all")
    public List<Appointment> getAppointment() {
        return appointmentService.getAllAppointments();
    }
    @GetMapping("/appointments/{id}")
    public Appointment getAppointment(@PathVariable(name = "id") Long id) {
        return appointmentService.getAppointment(id);
    }
    @PostMapping("/appointments")
    public Appointment saveAppointment(@RequestBody Appointment appointment) {
        return appointmentService.saveAppointment(appointment);
    }
    @PutMapping("/appointments/{id}")
    public Appointment updateAppointment(@PathVariable(name = "id") Long id,
                                         @RequestBody Appointment appointment) {
        appointment.setId(id);
        return appointmentService.updateAppointment(appointment);
    }
    @DeleteMapping("/appointments/{id}")
    public void deleteAppointment(@PathVariable(name = "id") Long id) {
        appointmentService.deleteAppointment(id);
    }


}
