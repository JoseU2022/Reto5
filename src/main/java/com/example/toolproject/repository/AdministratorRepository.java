package com.example.toolproject.repository;

import com.example.toolproject.entities.Administrator;
import com.example.toolproject.repository.crudRepository.AdministratorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdministratorRepository {

    @Autowired
    private AdministratorCrudRepository administratorCrudRepository;

    public List<Administrator> getAll(){
        return (List<Administrator>) administratorCrudRepository.findAll();
    }

    public Optional<Administrator> getAdministrator(int id){
        return administratorCrudRepository.findById(id);
    }

    public Administrator save(Administrator administrator){
        return administratorCrudRepository.save(administrator);
    }

    public void delete(Administrator administrator){
        administratorCrudRepository.delete(administrator);
    }
}
