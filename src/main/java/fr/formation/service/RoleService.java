package fr.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.models.Role;
import fr.formation.repository.IRoleRepository;

public class RoleService implements IRoleService {
@Autowired
	IRoleRepository rolerepository;
	@Override
	public List<Role> getAllRole() {
		
		return rolerepository.findAll();
	}

	@Override
	public Role getRoleById(long id) {
		Optional<Role> role1=rolerepository.findById(id);
		Role role=new Role();
		if(role1.isPresent()) {
			role=role1.get();		}
		return role;
	}

	@Override
	public Role createRole(Role role) {
		
		return rolerepository.save(role);
	}

	@Override
	public long deleteRole(long id) {
		try {
			rolerepository.deleteById(id);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	@Override
	public Role updateRole(Role role) {
		
		return rolerepository.save(role);
	}

}
