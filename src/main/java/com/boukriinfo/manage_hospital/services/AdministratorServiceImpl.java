package com.boukriinfo.manage_hospital.services;

import com.boukriinfo.manage_hospital.entities.Administrator;
import com.boukriinfo.manage_hospital.repositories.AdministratorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AdministratorServiceImpl implements AdministratorService {
    private AdministratorRepository administratorRepository;
    @Override
    public Page<Administrator> getAllAdministrators(int page, int size) {
        return administratorRepository.findAll(PageRequest.of(page, size)) ;
    }

    @Override
    public List<Administrator> getAdministrators() {
        return administratorRepository.findAll();
    }

    @Override
    public Administrator getAdministrator(Long id) {
        Administrator administrator = administratorRepository.findById(id).orElseThrow(() -> new RuntimeException("Administrator not found by Id : " + id + " !"));
        return administrator;
    }

    @Override
    public Administrator saveAdministrator(Administrator administrator) {
        Administrator saveAdministrator = administratorRepository.save(administrator);
        return saveAdministrator;
    }

    @Override
    public Administrator updateAdministrator(Administrator administrator) {
        Administrator saveAdministrator = administratorRepository.save(administrator);
        return saveAdministrator;
    }

    @Override
    public void deleteAdministrator(Long id) {
        administratorRepository.deleteById(id);

    }

    @Override
    public Page<Administrator> getAllAdministratorsWithNameAndPage(String name, int page, int size) {
        Page<Administrator> pageAllAdministrators = administratorRepository.findByNameContaining(name, PageRequest.of(page, size));
        return pageAllAdministrators;
    }
}
