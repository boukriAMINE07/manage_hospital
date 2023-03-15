package com.boukriinfo.manage_hospital.entities;

import com.boukriinfo.manage_hospital.enums.Gender;
import com.boukriinfo.manage_hospital.enums.Speciality;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data @Builder
@ToString
public class Doctor extends Employee{
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
    @Enumerated(EnumType.STRING)
    private Gender gender;



}
