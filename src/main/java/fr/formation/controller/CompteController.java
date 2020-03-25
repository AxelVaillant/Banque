package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.models.Compte;
import fr.formation.service.ICompteService;

@RestController
@RequestMapping("compte")
@CrossOrigin("http://localhost:4200")
public class CompteController {
	@Autowired
	ICompteService compteservice;
	@GetMapping("/all")
	public List<Compte> getAllCompte(){
		return compteservice.getAllCompte();
	}
	@GetMapping("/byid/{id}")
	public Compte getCompteById(@PathVariable long id){
		return compteservice.getCompteById(id);
	}
	@PostMapping("/save")
	public Compte createCompte(@RequestBody Compte compte) {
		return compteservice.createCompte(compte);
	}
	@PostMapping("/delete/{id}")
	public long deleteCompte(@PathVariable long id) {
		return compteservice.deleteCompte(id);
	}
	
	@PutMapping("/update/{id}")
	public Compte updateCompte(@PathVariable long id, @RequestBody Compte compte) {
		Compte comptemodif=compteservice.getCompteById(id);
		comptemodif.setNomcompte(compte.getNomcompte());
		comptemodif.setClient(compte.getClient());
		comptemodif.setConseiller(compte.getConseiller());
		comptemodif.setSoldecompte(compte.getSoldecompte());
		return compteservice.updateCompte(compte);
	
}}
