package bg.softuni.LinkedOut.service.impl;

import bg.softuni.LinkedOut.model.dto.AddCompanyDTO;
import bg.softuni.LinkedOut.model.entity.Company;
import bg.softuni.LinkedOut.repository.CompanyRepository;
import bg.softuni.LinkedOut.service.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public long addCompany(AddCompanyDTO addCompanyDTO) {
        Company company = mapToCompany(addCompanyDTO);
        companyRepository.save(company);
        return company.getId();
    }

    @Override
    public AddCompanyDTO getCompany(Long id) {
        return companyRepository.findById(id)
                .map(CompanyServiceImpl::mapToCompanyDTO)
                .orElse(null);
    }

    public static AddCompanyDTO mapToCompanyDTO(Company company) {
        return new AddCompanyDTO(
                company.getName(),
                company.getTown(),
                company.getDescription(),
                company.getBudget()
        );
    }

    private static Company mapToCompany(AddCompanyDTO addCompanyDTO) {
        return new Company()
                .setName(addCompanyDTO.name())
                .setTown(addCompanyDTO.town())
                .setDescription(addCompanyDTO.description())
                .setBudget(addCompanyDTO.budget());
    }
}
