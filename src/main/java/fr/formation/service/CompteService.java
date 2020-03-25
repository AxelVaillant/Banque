package fr.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.models.Compte;
import fr.formation.repository.ICompteRepository;

public class CompteService implements ICompteService{
	@Autowired
ICompteRepository compterepository;
	@Override
	public List<Compte> getAllCompte() {
		return compterepository.findAll();
	}

	@Override
	public Compte getCompteById(long id) {
		Optional<Compte> compte1 = compterepository.findById(id);
		Compte compte=new Compte();
		if(compte1.isPresent()) {
			compte=compte1.get();
		}
		return compte;
	}

	@Override
	public Compte createCompte(Compte compte) {
		return compterepository.save(compte);
	}

	@Override
	public long deleteCompte(long id) {
		try {
			compterepository.deleteById(id);
		} catch (Exception e) {
			return 0;
		}
		
		return 1;
	}

	@Override
	public Compte updateCompte(Compte compte) {
		return compterepository.save(compte);
	}

}
