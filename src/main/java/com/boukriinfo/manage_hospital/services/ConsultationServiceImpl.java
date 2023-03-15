package com.boukriinfo.manage_hospital.services;

import com.boukriinfo.manage_hospital.entities.Consultation;
import com.boukriinfo.manage_hospital.repositories.ConsultationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ConsultationServiceImpl implements ConsultationService {
    private ConsultationRepository consultationRepository;
    @Override
    public Page<Consultation> getAllConsultations(int page, int size) {
        Page<Consultation> pageConsultations = consultationRepository.findAll(PageRequest.of(page, size));
        return pageConsultations;
    }

    @Override
    public Consultation getConsultation(Long id) {
        Consultation consultation = consultationRepository.findById(id).orElseThrow(() -> new RuntimeException("Consultation not found by Id : " + id + " !"));
        return consultation;
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        Consultation saveConsultation = consultationRepository.save(consultation);
        return saveConsultation;
    }

    @Override
    public Consultation updateConsultation(Consultation consultation) {
        Consultation saveConsultation = consultationRepository.save(consultation);
        return saveConsultation;
    }

    @Override
    public void deleteConsultation(Long id) {
                    consultationRepository.deleteById(id);
    }

    @Override
    public Page<Consultation> getAllConsultationsWithNameAndPage(String name, int page, int size) {
        Page<Consultation> pageAllConsultations = consultationRepository.findByAppointmentDoctorNameContaining(name, PageRequest.of(page, size));
        return pageAllConsultations;
    }
}
