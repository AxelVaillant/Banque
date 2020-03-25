package fr.formation.service;

import java.util.List;

import fr.formation.models.Operations;

public interface IOperationsService {

	public List<Operations> getAllOperations();
	public Operations getOperationsById(long id);
	public Operations createOperations(Operations operations);
	public long deleteOperations(long id);
	public Operations updateOperations(Operations operations);
}
