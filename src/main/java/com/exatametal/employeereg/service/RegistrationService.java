package com.exatametal.employeereg.service;


import com.exatametal.employeereg.model.Employee;
import com.exatametal.employeereg.model.Registration;
import com.exatametal.employeereg.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    public Registration save(Registration registration){
        return registrationRepository.save(registration);
    }

    public List<Registration> findAll(){
        return registrationRepository.findAll();
    }
}
