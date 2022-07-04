package com.curd.example.service;

import java.util.List;

import javax.transaction.Transactional;

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

	@Override
	@Transactional
	public CoronaVaccine getVaccineByRegNo(Long regNo) {
		return coronaRepo.getById(regNo);
		/*requrired: spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true while working this method*/
		/*getById(), getOne() methods implementation depends on underlying spring data jpa.
		 	Since spring data jpa by default uses hibernate to perform this load operation internally through lazy loading 
		 	we need to place the additional properties in application.properties filespring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
		 	In older versions of spring boot the above properties si not required rather @Transactional annotation we 
		 	need to place on the top of service class methods.
		 */
	}

	@Override
	public String removeVaccinesByRegNo(Iterable<Long> regNos) {
		Iterable<CoronaVaccine> listEntites = coronaRepo.findAllById(regNos);
		List<CoronaVaccine> list = (List<CoronaVaccine>) listEntites;
		if(list.size() != 0){
			coronaRepo.deleteAllById(regNos);
			return "Number of Records deleted: " + list.size();
		}else {
			return "No Record found for deletion";
		}
	}

}
