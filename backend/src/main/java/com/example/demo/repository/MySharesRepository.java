package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.MySharesModel;

public interface MySharesRepository extends CrudRepository<MySharesModel,Integer>{

}
