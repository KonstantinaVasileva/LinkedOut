package bg.softuni.LinkedOut.service.impl;

import bg.softuni.LinkedOut.model.dto.AddEmployeeDTO;
import bg.softuni.LinkedOut.model.entity.Employee;
import bg.softuni.LinkedOut.repository.EmployeeRepository;
import bg.softuni.LinkedOut.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String addEmployees(AddEmployeeDTO addEmployeeDTO) {
        Employee employee = modelMapper.map(addEmployeeDTO, Employee.class);
        employeeRepository.save(employee);
        return employee.getId();
    }

    @Override
    public AddEmployeeDTO getEmployee(String id) {
        return modelMapper.map(employeeRepository.findById(id), AddEmployeeDTO.class);
    }

}
