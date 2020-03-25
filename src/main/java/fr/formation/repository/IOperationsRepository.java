package fr.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.models.Operations;

public interface IOperationsRepository extends JpaRepository<Operations, Long> {

}
