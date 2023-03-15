package com.boukriinfo.manage_hospital.services;

import com.boukriinfo.manage_hospital.entities.Consultation;
import org.springframework.data.domain.Page;

public interface ConsultationService {
    Page<Consultation> getAllConsultations(int page, int size);
    Consultation getConsultation(Long id);
    Consultation saveConsultation(Consultation consultation);
    Consultation updateConsultation(Consultation consultation);
    void deleteConsultation(Long id);
    Page<Consultation> getAllConsultationsWithNameAndPage(String name, int page, int size);

}
