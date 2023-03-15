package com.boukriinfo.manage_hospital.entities;

import com.boukriinfo.manage_hospital.enums.StatusAppointment;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@AllArgsConstructor @NoArgsConstructor @Data @Builder
@ToString
public class Appointment  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatusAppointment statusAppointment;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
    @OneToOne(mappedBy = "appointment")
    private Consultation consultation;
}
