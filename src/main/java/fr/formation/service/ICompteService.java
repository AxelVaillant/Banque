package fr.formation.service;

import java.util.List;

import fr.formation.models.Compte;

public interface ICompteService {

	public List<Compte> getAllCompte();
	public Compte getCompteById(long id);
	public Compte createCompte(Compte compte);
	public long deleteCompte(long id);
	public Compte updateCompte(Compte compte);
}
