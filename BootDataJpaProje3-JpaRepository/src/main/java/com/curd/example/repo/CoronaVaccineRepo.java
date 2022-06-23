package com.curd.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curd.example.entity.CoronaVaccine;

@Repository
public interface CoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

}
