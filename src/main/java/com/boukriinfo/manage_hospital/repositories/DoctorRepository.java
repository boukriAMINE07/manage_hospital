package com.boukriinfo.manage_hospital.repositories;

import com.boukriinfo.manage_hospital.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findAll(Pageable pageable);
    Page<Doctor> findByNameContaining(String name, Pageable pageable);
}
