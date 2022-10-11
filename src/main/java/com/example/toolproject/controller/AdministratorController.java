package com.example.toolproject.controller;

import com.example.toolproject.entities.Administrator;
import com.example.toolproject.entities.Category;
import com.example.toolproject.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/all")
    public List<Administrator> getAll(){
        return administratorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Administrator> getAdministrator(@PathVariable("id") int id){return administratorService.getAdministrator(id);}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrator save(@RequestBody Administrator administrator){return administratorService.save(administrator);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){return administratorService.delete(id);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrator update(@RequestBody Administrator administrator) {return administratorService.update(administrator);}
}
