package com.curd.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curd.example.entity.CoronaVaccine;

@Repository
public interface CoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
	public List<CoronaVaccine> findByCompany(String company);
	public List<CoronaVaccine>findByCompanyEquals(String company);
	public List<CoronaVaccine>findByPriceLessThan(Double price);
	public List<CoronaVaccine>findByPriceBetween(double startprice, double endPrice);
	public List<CoronaVaccine>findByNameLike(String initCharacter);
	public List<CoronaVaccine>findByNameStartingWith(String startLetters);
	public List<CoronaVaccine>findByNameEndingWith(String endLetters);
	public List<CoronaVaccine>findByNameContaining(String letters);
	public List<CoronaVaccine>findByCountryIn(List<String>countries);
	public List<CoronaVaccine>findByPriceOrderByPriceAsc(double price); // By default desc order
	public List<CoronaVaccine>findByPriceGreaterThanOrderByPriceAsc(double price); // By default desc order
	public List<CoronaVaccine>findByCountryNot(String country); // fetch country not from country.

}