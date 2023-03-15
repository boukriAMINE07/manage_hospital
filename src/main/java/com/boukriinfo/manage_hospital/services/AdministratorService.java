package com.boukriinfo.manage_hospital.services;

import com.boukriinfo.manage_hospital.entities.Administrator;
import org.springframework.data.domain.Page;



public interface AdministratorService {
    public Page<Administrator> getAllAdministrators(int page, int size);
    public Administrator getAdministrator(Long id);
    public Administrator saveAdministrator(Administrator administrator);
    public Administrator updateAdministrator(Administrator administrator);
    public void deleteAdministrator(Long id);
    Page<Administrator> getAllAdministratorsWithNameAndPage(String name, int page, int size);
}
