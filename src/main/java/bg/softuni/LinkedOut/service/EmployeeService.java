package bg.softuni.LinkedOut.service;

import bg.softuni.LinkedOut.model.dto.AddEmployeeDTO;

public interface EmployeeService {

    String addEmployees(AddEmployeeDTO addEmployeeDTO);
    AddEmployeeDTO getEmployee(String id);
}
