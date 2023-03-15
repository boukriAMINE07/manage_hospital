package com.boukriinfo.manage_hospital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data @Builder @ToString
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rapport;
    private Date date;
    private double price;
    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Appointment appointment;

}
