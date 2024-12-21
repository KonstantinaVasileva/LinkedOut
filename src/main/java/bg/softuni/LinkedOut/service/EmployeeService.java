package bg.softuni.LinkedOut.service;

import bg.softuni.LinkedOut.model.dto.AddEmployeeDTO;
import bg.softuni.LinkedOut.model.entity.Employee;

import java.util.List;

public interface EmployeeService {

    String addEmployees(AddEmployeeDTO addEmployeeDTO);
    AddEmployeeDTO getEmployee(String id);
    List<Employee> getAllEmployees();
}
