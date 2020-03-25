package fr.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.models.Compte;

public interface ICompteRepository extends JpaRepository<Compte, Long> {

}
 