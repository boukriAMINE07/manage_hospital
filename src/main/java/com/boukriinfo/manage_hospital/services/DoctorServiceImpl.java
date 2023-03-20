package com.boukriinfo.manage_hospital.services;

import com.boukriinfo.manage_hospital.entities.Doctor;
import com.boukriinfo.manage_hospital.repositories.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private DoctorRepository doctorRepository;
    @Override
    public Page<Doctor> getAllDoctors(int page, int size) {
        Page<Doctor> pageAllDoctors = doctorRepository.findAll(PageRequest.of(page, size));
        return pageAllDoctors;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found by Id : " + id + " !"));
        return doctor;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        Doctor saveDoctor = doctorRepository.save(doctor);
        return saveDoctor;
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        Doctor saveDoctor = doctorRepository.save(doctor);
        return saveDoctor;
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Page<Doctor> getAllDoctorsWithNameAndPage(String name, int page, int size) {
        Page<Doctor> pageAllDoctors = doctorRepository.findByNameContaining(name, PageRequest.of(page, size));
        return pageAllDoctors;
    }
}
