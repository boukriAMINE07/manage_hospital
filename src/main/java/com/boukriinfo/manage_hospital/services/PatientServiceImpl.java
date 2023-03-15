package com.boukriinfo.manage_hospital.services;

import com.boukriinfo.manage_hospital.entities.Patient;
import com.boukriinfo.manage_hospital.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;
    @Override
    public Page<Patient> getAllPatients(int page, int size) {
        Page<Patient> pageAllPatients = patientRepository.findAll(PageRequest.of(page, size));
        return pageAllPatients;
    }

    @Override
    public Patient getPatient(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found by Id : " + id + " !"));
        return patient;
    }

    @Override
    public Patient savePatient(Patient patient) {
        Patient savePatient = patientRepository.save(patient);
        return savePatient;
    }

    @Override
    public Patient updatePatient(Patient patient) {
        Patient updatePatient = patientRepository.save(patient);
        return updatePatient;
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Page<Patient> getAllPatientsWithNameAndPage(String name, int page, int size) {
        Page<Patient> pageAllPatients = patientRepository.findByNameContaining(name, PageRequest.of(page, size));
        return pageAllPatients;
    }
}
