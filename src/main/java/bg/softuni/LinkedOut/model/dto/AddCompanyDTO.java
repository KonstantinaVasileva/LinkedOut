package bg.softuni.LinkedOut.model.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record AddCompanyDTO(
        @Size(min = 2, max = 10)
        String name,
        @Size(min = 2, max = 10)
        String town,
        @Size(min = 10)
        String description,
        @Positive
        BigDecimal budget
) {
}
