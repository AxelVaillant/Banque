package fr.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.models.Operations;
import fr.formation.repository.IOperationsRepository;

public class OperationsService implements IOperationsService {
@Autowired
	IOperationsRepository operationsrepository;
	@Override
	public List<Operations> getAllOperations() {
		
		return operationsrepository.findAll();
	}

	@Override
	public Operations getOperationsById(long id) {
		Optional<Operations> operations1=operationsrepository.findById(id);
		Operations operations = new Operations();
		if(operations1.isPresent()) {
			operations=operations1.get();
		}
		return operations;
	}

	@Override
	public Operations createOperations(Operations operations) {
		
		return operationsrepository.save(operations);
	}

	@Override
	public long deleteOperations(long id) {
	
		try {
			operationsrepository.deleteById(id);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	@Override
	public Operations updateOperations(Operations operations) {
		
		return operationsrepository.save(operations);
	}

}
