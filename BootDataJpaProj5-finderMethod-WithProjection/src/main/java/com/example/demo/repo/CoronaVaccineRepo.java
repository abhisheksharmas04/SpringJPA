package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CoronaVaccine;
import com.example.demo.type.ResultView;

public interface CoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
	public List<ResultView> findByPriceGreaterThanEqualOrderByPrice(double startPrice);

}