package bg.softuni.LinkedOut.repository;

import bg.softuni.LinkedOut.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,String> {

}
