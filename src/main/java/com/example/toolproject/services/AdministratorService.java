package com.example.toolproject.services;

import com.example.toolproject.entities.Administrator;
import com.example.toolproject.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public List<Administrator> getAll(){
        return administratorRepository.getAll();
    }

    public Optional<Administrator> getAdministrator(int id){
        return administratorRepository.getAdministrator(id);
    }

    public Administrator save(Administrator administrator){
        if(administrator.getId() == null){
            return administratorRepository.save(administrator);
        }
        else {
            Optional<Administrator> e = administratorRepository.getAdministrator(administrator.getId());

            if(e.isPresent()){
                return administrator;
            }
            else {
                return administratorRepository.save(administrator);
            }
        }
    }

    public Administrator update(Administrator administrator) {
        if (administrator.getId() != null) {
            Optional<Administrator> e = administratorRepository.getAdministrator(administrator.getId());

            if (e.isPresent()) {

                if (administrator.getName() != null) {
                    e.get().setName(administrator.getName());
                }

                if (administrator.getEmail() != null) {
                    e.get().setEmail(administrator.getEmail());
                }

                if (administrator.getPassword() != null) {
                    e.get().setPassword(administrator.getPassword());
                }

                administratorRepository.save(e.get());
                return e.get();
            } else {
                return administrator;
            }
        } else {
            return administrator;
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Administrator> e = administratorRepository.getAdministrator(id);
        if(e.isPresent()){
            administratorRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }

}
