package fr.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.models.Compte;
import fr.formation.models.Operations;
import fr.formation.repository.ICompteRepository;
import fr.formation.repository.IOperationsRepository;
@Service
public class OperationsService implements IOperationsService {
@Autowired
	IOperationsRepository operationsrepository;
@Autowired
ICompteRepository compterepository;
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
		Compte emetteur =operations.getEmetteur();
		Compte receveur=operations.getReceveur();
		
		Optional<Compte> compte1 = compterepository.findById(emetteur.getIdcompte());
		Optional<Compte> compte2 = compterepository.findById(receveur.getIdcompte());
		
		if(compte1.isPresent() && compte2.isPresent()) {
			emetteur=compte1.get();
			receveur=compte2.get();
			
			receveur.setSoldecompte(receveur.getSoldecompte()+operations.getMontant());
			emetteur.setSoldecompte(emetteur.getSoldecompte()-operations.getMontant());
		
		compterepository.save(emetteur);
		compterepository.save(receveur);
		}
		
		
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
