package com.boukriinfo.manage_hospital.repositories;

import com.boukriinfo.manage_hospital.entities.Consultation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    Page<Consultation> findAll(Pageable pageable);
    Page<Consultation> findByAppointmentDoctorNameContaining(String name, Pageable pageable);
}
