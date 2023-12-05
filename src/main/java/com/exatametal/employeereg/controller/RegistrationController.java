package com.exatametal.employeereg.controller;


import com.exatametal.employeereg.model.Registration;
import com.exatametal.employeereg.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public ResponseEntity<List<Registration>> consult(){
        return ResponseEntity.ok(registrationService.findAll());
    }

    @PostMapping
    public ResponseEntity<Registration> save(@RequestBody Registration registration){
        return ResponseEntity.ok(registrationService.save(registration));
    }
}
