package com.exatametal.employeereg.service;

import com.exatametal.employeereg.model.DTO.EmployeeDTO;
import com.exatametal.employeereg.model.Employee;
import com.exatametal.employeereg.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    ModelMapper modelMapper = new ModelMapper();

    public Employee save(Employee employee){
        employee = employeeRepository.save(employee);
        return employee;
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public EmployeeDTO findById(Long id) throws ChangeSetPersister.NotFoundException {
         var employee =  employeeRepository
                 .findById(id)
                 .orElseThrow(ChangeSetPersister.NotFoundException::new);
         return modelMapper.map(employee, EmployeeDTO.class);
    }
}
