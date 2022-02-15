package com.example.demo2.services;

import com.example.demo2.models.Result;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultRepository extends CrudRepository<Result, Long> {
    public List<Result> findTop10ByOrderByResultDesc();


}
