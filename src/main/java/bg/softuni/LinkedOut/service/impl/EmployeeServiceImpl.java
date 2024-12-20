package bg.softuni.LinkedOut.service.impl;

import bg.softuni.LinkedOut.model.dto.AddEmployeeDTO;
import bg.softuni.LinkedOut.model.entity.Employee;
import bg.softuni.LinkedOut.repository.EmployeeRepository;
import bg.softuni.LinkedOut.service.EmployeeService;
import jakarta.transaction.Transactional;
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
    @Transactional
    public String addEmployees(AddEmployeeDTO addEmployeeDTO) {
//        Employee employee = modelMapper.map(addEmployeeDTO, Employee.class);
//        employeeRepository.save(employee);
//        return employee.getId();

        System.out.println("Received DTO: " + addEmployeeDTO); // Debug log

        try {
            Employee employee = mapToEmployee(addEmployeeDTO);
            System.out.println("Mapped to entity: " + employee); // Debug log

            Employee savedEmployee = employeeRepository.save(employee);
            System.out.println("Saved employee: " + savedEmployee); // Debug log

            return savedEmployee.getId();
        } catch (Exception e) {
            System.out.println("Error during employee creation: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }

    }

    private static Employee mapToEmployee(AddEmployeeDTO addEmployeeDTO) {
       return new Employee().setFirstName(addEmployeeDTO.firstName())
        .setLastName(addEmployeeDTO.lastName())
        .setEducationLevel(addEmployeeDTO.educationLevel())
        .setCompany(addEmployeeDTO.company())
        .setJobTitle(addEmployeeDTO.jobTitle())
        .setBirthDate(addEmployeeDTO.birthDate())
        .setSalary(addEmployeeDTO.salary());
    }

    @Override
    public AddEmployeeDTO getEmployee(String id) {
return employeeRepository.findById(id)
        .map(EmployeeServiceImpl::mapToAddEmployeeDTO)
        .orElse(null);
    }

    public static AddEmployeeDTO mapToAddEmployeeDTO(Employee employee) {
        return new AddEmployeeDTO(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEducationLevel(),
                employee.getCompany(),
                employee.getJobTitle(),
                employee.getBirthDate(),
                employee.getSalary()
        );
    }

}
