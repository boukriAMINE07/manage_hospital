package com.boukriinfo.manage_hospital.repositories;

import com.boukriinfo.manage_hospital.entities.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Page<Appointment> findAll(Pageable pageable);
    Page<Appointment> findByPatientNameContaining(String name, Pageable pageable);
}
