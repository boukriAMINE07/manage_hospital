package com.boukriinfo.manage_hospital.entities;

import com.boukriinfo.manage_hospital.enums.Gender;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder @ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 4,max = 25)
    private String name;
    @NotEmpty
    private String phone;
    @NotEmpty
    @Column(length = 100)
    private String email;
    @NotEmpty
    private String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    private boolean isSick;
}
