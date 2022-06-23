package com.curd.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.curd.example.entity.CoronaVaccine;
import com.curd.example.repo.CoronaVaccineRepo;

@Service("vaccineManagementService")
public class CoronaVaccineManagementServiceImpl implements ICoronaVaccineManagementService {
	
	@Autowired
	private CoronaVaccineRepo coronaRepo;

	@Override
	public List<CoronaVaccine> SearchVaccinesByGivenData(CoronaVaccine vaccine, boolean ascOrder, String... props) {
		// Prepare Example Object
		Example<CoronaVaccine> example = Example.of(vaccine);
		Sort sort = Sort.by(ascOrder?Direction.ASC:Direction.DESC,props);
		List<CoronaVaccine>listEntites = coronaRepo.findAll(example,sort);
		return listEntites;
		/* use of this example is search box */
	}

}
