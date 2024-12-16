package bg.softuni.LinkedOut.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String town;
    private String description;
    private BigDecimal budget;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getTown() {
        return town;
    }

    public Company setTown(String town) {
        this.town = town;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Company setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public Company setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }
}
