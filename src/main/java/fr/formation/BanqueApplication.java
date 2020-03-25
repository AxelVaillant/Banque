package fr.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.service.ICompteService;
import fr.formation.service.IOperationsService;
import fr.formation.service.IRoleService;
import fr.formation.service.IUserService;

@SpringBootApplication
public class BanqueApplication implements CommandLineRunner {
	@Autowired
	private IUserService userservice;
	@Autowired
	private ICompteService compteservice;
	@Autowired
	private IOperationsService operationsservice;
	@Autowired
	private IRoleService roleservice;
	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
