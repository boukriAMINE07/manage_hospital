package com.boukriinfo.manage_hospital.repositories;

import com.boukriinfo.manage_hospital.entities.Administrator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator,Long> {
    Page<Administrator> findAll(Pageable pageable);
    Page<Administrator> findByNameContaining(String name, Pageable pageable);
}
