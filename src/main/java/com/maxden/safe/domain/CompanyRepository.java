package com.maxden.safe.domain;

import com.maxden.safe.domain.model.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}