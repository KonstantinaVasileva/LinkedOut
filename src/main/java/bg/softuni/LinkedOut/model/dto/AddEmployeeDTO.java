package bg.softuni.LinkedOut.model.dto;

import bg.softuni.LinkedOut.model.entity.Company;
import bg.softuni.LinkedOut.model.enums.EducationLevel;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AddEmployeeDTO(
        String firstName,
        String lastName,
        EducationLevel educationLevel,
        Company company,
        String jobTitle,
        LocalDate birthDate,
        BigDecimal salary
) {

}
