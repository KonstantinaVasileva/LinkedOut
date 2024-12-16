package bg.softuni.LinkedOut.service;

import bg.softuni.LinkedOut.model.dto.AddCompanyDTO;

public interface CompanyService {
    long addCompany(AddCompanyDTO addCompanyDTO);
    AddCompanyDTO getCompany(Long id);
}
