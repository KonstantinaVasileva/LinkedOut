package bg.softuni.LinkedOut.service;

import bg.softuni.LinkedOut.model.dto.AddCompanyDTO;
import bg.softuni.LinkedOut.model.entity.Company;

import java.util.List;

public interface CompanyService {
    String addCompany(AddCompanyDTO addCompanyDTO);

    AddCompanyDTO getCompany(String id);

    List<Company> getAllCompanies();
}
