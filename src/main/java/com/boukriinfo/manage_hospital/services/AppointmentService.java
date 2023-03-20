package com.boukriinfo.manage_hospital.services;


import com.boukriinfo.manage_hospital.entities.Appointment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AppointmentService {
    Page<Appointment> getAllAppointments(int page, int size);
    List<Appointment> getAllAppointments();
    Appointment getAppointment(Long id);
    Appointment saveAppointment(Appointment appointment);
    Appointment updateAppointment(Appointment appointment);
    void deleteAppointment(Long id);
    Page<Appointment> getAllAppointmentsWithNameAndPage(String name, int page, int size);

}
