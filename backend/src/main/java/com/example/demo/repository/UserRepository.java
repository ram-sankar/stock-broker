package com.example.demo.repository;

import com.example.demo.models.*;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel,Integer> {

}
