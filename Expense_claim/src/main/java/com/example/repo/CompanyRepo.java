package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;  


import com.example.model.Company;


public interface CompanyRepo extends JpaRepository<Company, Long> {
		
	}
	


