package com.boukriinfo.manage_hospital.services;

import com.boukriinfo.manage_hospital.entities.Patient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface PatientService {
    public Page<Patient> getAllPatients(int page, int size);
    public Patient getPatient(Long id);
    public Patient savePatient(Patient patient);
    public Patient updatePatient(Patient patient);
    public void deletePatient(Long id);
    Page<Patient> getAllPatientsWithNameAndPage(String name, int page, int size);
}
