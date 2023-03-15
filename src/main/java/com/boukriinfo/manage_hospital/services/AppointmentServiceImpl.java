package com.boukriinfo.manage_hospital.services;

import com.boukriinfo.manage_hospital.entities.Appointment;
import com.boukriinfo.manage_hospital.repositories.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;
    @Override
    public Page<Appointment> getAllAppointments(int page, int size) {
        Page<Appointment> pageAllAppointments = appointmentRepository.findAll(PageRequest.of(page, size));
        return pageAllAppointments;
    }

    @Override
    public Appointment getAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found by Id : " + id + " !"));

        return appointment;
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        Appointment saveAppointment = appointmentRepository.save(appointment);
        return saveAppointment;
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        Appointment saveAppointment = appointmentRepository.save(appointment);
        return saveAppointment;
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public Page<Appointment> getAllAppointmentsWithNameAndPage(String name, int page, int size) {
        Page<Appointment> pageAllAppointments = appointmentRepository.findByPatientNameContaining(name, PageRequest.of(page, size));
        return pageAllAppointments;
    }
}
