package com.boukriinfo.manage_hospital.repositories;

import com.boukriinfo.manage_hospital.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findAll(Pageable pageable);
    Page<Patient> findByNameContaining(String name, Pageable pageable);
}
