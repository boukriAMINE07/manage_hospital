package com.boukriinfo.manage_hospital.services;

import com.boukriinfo.manage_hospital.entities.Doctor;
import org.springframework.data.domain.Page;

public interface DoctorService {
    Page<Doctor> getAllDoctors(int page, int size);
    Doctor getDoctor(Long id);
    Doctor saveDoctor(Doctor doctor);
    Doctor updateDoctor(Doctor doctor);
    void deleteDoctor(Long id);
    Page<Doctor> getAllDoctorsWithNameAndPage(String name, int page, int size);
}
