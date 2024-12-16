package bg.softuni.LinkedOut.model.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record AddCompanyDTO(
        @Size(min = 2, max = 10,
        message = "{add.company.name.length}")
        String name,
        @Size(min = 2, max = 10,
        message = "{add.company.town.length}")
        String town,
        @Size(min = 10,
        message = "{add.company.description.length}")
        String description,
        @Positive(message = "{add.company.budget.positive}")
        BigDecimal budget
) {
}
