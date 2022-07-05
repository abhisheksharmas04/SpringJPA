package com.example.demo.service;

import java.util.List;

import com.example.demo.type.ResultView;

public interface ICoronaVaccineManagementService {
	public List<ResultView> searchVaccinesByStartPrice(double price);
}
