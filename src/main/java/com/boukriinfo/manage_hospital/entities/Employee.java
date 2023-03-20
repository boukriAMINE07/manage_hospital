package com.boukriinfo.manage_hospital.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.TABLE)
        private Long id;
        @NotEmpty
        @Size(min = 3,max = 25)
        private String name;
        @NotEmpty
        @Column(length = 100)
        private String email;
        @NotEmpty
        @Size(min = 6,max = 25)
        private String password;
        @NotEmpty
        private String address;
        @NotEmpty
        private String phone;


}
