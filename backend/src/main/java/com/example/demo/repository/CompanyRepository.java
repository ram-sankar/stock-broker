package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.models.CompanyModel;

public interface CompanyRepository extends CrudRepository<CompanyModel,Integer>{

}
