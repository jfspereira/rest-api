package com.cofco.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cofco.data.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}