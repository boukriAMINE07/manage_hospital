package com.boukriinfo.manage_hospital;

import com.boukriinfo.manage_hospital.entities.*;
import com.boukriinfo.manage_hospital.enums.Gender;
import com.boukriinfo.manage_hospital.enums.Role;
import com.boukriinfo.manage_hospital.enums.Speciality;
import com.boukriinfo.manage_hospital.enums.StatusAppointment;
import com.boukriinfo.manage_hospital.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ManageHospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageHospitalApplication.class, args);
    }


    //@Bean
    CommandLineRunner savePatient(PatientRepository patientRepository) {
        return args -> {
            Stream.of("Mohamed", "Fati", "Ahmed", "Sara", "Hajar", "Abdol")
                    .forEach(name -> {
                        Patient patient = Patient.builder().
                                name(name)
                                .email(name + "@gmail.com")
                                .address("adresse de " + name)
                                .birthdate(new Date())
                                .isSick(Math.random() > 0.5 ? false : true)
                                .gender(Math.random() > 0.5 ? Gender.FEMALE : Gender.MALE)
                                .phone("0623456789")
                                .build();
                        patientRepository.save(patient);
                    });
        };
    }

    //@Bean
    CommandLineRunner saveDoctor(DoctorRepository doctorRepository) {
        return args -> {
            Stream.of("Amir", "Malak", "Sara", "Ayoub", "Karim")
                    .forEach(name -> {
                        Doctor doctor = new Doctor();
                        doctor.setName(name);
                        doctor.setAddress("adresse de " + name);
                        doctor.setGender(Math.random() > 0.5 ? Gender.MALE : Gender.FEMALE);
                        doctor.setPhone("0623456789");
                        doctor.setEmail(name + "@gmail.com");
                        doctor.setSpeciality(Math.random() > 0.5 ? Speciality.DERMATOLOGIST : Speciality.NEUROLOGIST);
                        doctor.setPassword("123456");
                        doctorRepository.save(doctor);
                    });
        };
    }

    //@Bean
    CommandLineRunner saveAdministrator(AdministratorRepository administratorRepository) {
        return args -> {
            Stream.of("Adnan", "Amine", "Khalid")
                    .forEach(name -> {
                        Administrator administrator = new Administrator();
                        administrator.setName(name);
                        administrator.setAddress("adresse de " + name);
                        administrator.setEmail(name + "@gmail.com");
                        administrator.setPhone("0623456789");
                        administrator.setRole(Math.random() > 0.5 ? Role.CHIEF_OPERATING : Role.CHIEF_TECHNOLOGY);
                        administrator.setPassword("123456");
                        administratorRepository.save(administrator);
                    });
        };
    }
    //@Bean
    CommandLineRunner saveAppointment(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        return args -> {
            List<Doctor> doctors = doctorRepository.findAll();
            doctors.forEach(doctor -> {
                List<Patient> patients = patientRepository.findAll();
                patients.forEach(patient -> {
                    Appointment appointment = new Appointment();
                    appointment.setStatusAppointment(Math.random() > 0.5 ? StatusAppointment.WAITING : StatusAppointment.CANCELED);
                    appointment.setDoctor(doctor);
                    appointment.setPatient(patient);
                    appointment.setDate(new Date());
                    appointmentRepository.save(appointment);
                });
            });
        };
    }
    //@Bean
    CommandLineRunner saveConsultation(AppointmentRepository appointmentRepository, ConsultationRepository consultationRepository) {
        return args -> {
            List<Appointment> appointments = appointmentRepository.findAll();
            appointments.forEach(appointment -> {
                Consultation consultation = new Consultation();
                consultation.setAppointment(appointment);
                consultation.setDate(new Date());
                consultation.setPrice(Math.random()*1000);
                consultation.setRapport("Rapport de consultation");
                consultationRepository.save(consultation);
            });
        };
    }
}
