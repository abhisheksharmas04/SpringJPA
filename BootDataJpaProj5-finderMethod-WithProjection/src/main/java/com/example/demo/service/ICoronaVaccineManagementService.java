package com.example.demo.service;

import java.util.List;

import com.example.demo.type.View;

public interface ICoronaVaccineManagementService {
	public <T extends View> List<T> searchVaccinesByCompany(String companyName, Class<T>clazz);
}
