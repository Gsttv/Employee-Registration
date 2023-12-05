package com.exatametal.employeereg.model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDTO {
    private String name;
    private String cpf;
}
