package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.WatchListModel;

public interface WatchListRepository extends CrudRepository<WatchListModel,Integer>{

}
