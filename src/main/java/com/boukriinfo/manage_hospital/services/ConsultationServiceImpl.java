package com.boukriinfo.manage_hospital.services;

import com.boukriinfo.manage_hospital.entities.Consultation;
import com.boukriinfo.manage_hospital.repositories.ConsultationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ConsultationServiceImpl implements ConsultationService {
    private ConsultationRepository consultationRepository;
    @Override
    public Page<Consultation> getAllConsultations(int page, int size) {
        Page<Consultation> pageConsultations = consultationRepository.findAll(PageRequest.of(page, size));
        return pageConsultations;
    }

    @Override
    public List<Consultation> getConsultations() {
        return consultationRepository.findAll();
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
        Consultation consultationToUpdated = consultationRepository.findById(consultation.getId()).orElseThrow(() -> new RuntimeException("Consultation not found by Id : " + consultation.getId() + " !"));
        consultationToUpdated.setRapport(consultation.getRapport());
        consultationToUpdated.setPrice(consultation.getPrice());
        consultationToUpdated.setDate(consultation.getDate());
        consultationToUpdated.setAppointment(consultation.getAppointment());
        log.info("Update Consultation : {}", consultationToUpdated.getAppointment());
        Consultation saveConsultation = consultationRepository.save(consultationToUpdated);
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
