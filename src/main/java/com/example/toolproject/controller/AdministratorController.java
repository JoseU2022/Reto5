package com.example.toolproject.controller;

import com.example.toolproject.entities.Administrator;
import com.example.toolproject.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/all")
    public List<Administrator> getAll(){
        return administratorService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrator save(@RequestBody Administrator administrator){
        return administratorService.save(administrator);
    }
}
