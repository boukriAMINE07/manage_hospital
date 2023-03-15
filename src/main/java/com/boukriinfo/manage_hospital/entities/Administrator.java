package com.boukriinfo.manage_hospital.entities;

import com.boukriinfo.manage_hospital.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor @Data
public class Administrator extends Employee{
    @Enumerated(EnumType.STRING)
    private Role role;

}
