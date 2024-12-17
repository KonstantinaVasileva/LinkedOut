package bg.softuni.LinkedOut.service;

import bg.softuni.LinkedOut.model.dto.AddCompanyDTO;

public interface CompanyService {
    String addCompany(AddCompanyDTO addCompanyDTO);
    AddCompanyDTO getCompany(String id);
}
