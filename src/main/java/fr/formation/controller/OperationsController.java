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

import fr.formation.models.Operations;
import fr.formation.service.IOperationsService;



@RestController
@RequestMapping("operations")
@CrossOrigin("http://localhost:4200")
public class OperationsController {

	@Autowired
	IOperationsService operationsservice;
	@GetMapping("/all")
	public List<Operations> getAllOperations(){
		return operationsservice.getAllOperations();
	}
	@GetMapping("/byid/{id}")
	public Operations getOperationsById(@PathVariable long id){
		return operationsservice.getOperationsById(id);
	}
	@PostMapping("/save")
	public Operations createOperations(@RequestBody Operations operations) {
		return operationsservice.createOperations(operations);
	}
//	@PostMapping("/delete/{id}")
//	public long deleteOperations(@PathVariable long id) {
//		return operationsservice.deleteOperations(id);
//	}
	
//	@PutMapping("/update/{id}")
//	public Operations updateOperations(@PathVariable long id, @RequestBody Operations operations) {
//		Operations operationsmodif=operationsservice.getOperationsById(id);
//		operationsmodif.setNomoperations(operations.getNomoperations());
//		operationsmodif.setDateoperations(operations.getDateoperations());
//		operationsmodif.setEmetteur(operations.getEmetteur());
//		operationsmodif.setReceveur(operations.getReceveur());
//		operationsmodif.setMontant(operations.getMontant());
//		return operationsservice.updateOperations(operations);
//	}
}
