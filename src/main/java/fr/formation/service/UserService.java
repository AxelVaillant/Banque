package fr.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.models.User;
import fr.formation.repository.IUserRepository;
@Service

public class UserService implements IUserService {
	@Autowired
	 IUserRepository userrepository;
	@Autowired
	BCryptPasswordEncoder cryptageService;
	@Bean
	BCryptPasswordEncoder passwordEncoder() {

	    return new BCryptPasswordEncoder();
	}
	@Override
	public List<User> getAllUser() {
		
		return userrepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		Optional<User> listuser=userrepository.findById(id);
		User user = new User();
		if(listuser.isPresent()) {
			user=listuser.get();
		}
		
		return user;
	}

	@Override
	public User createUser(User user) {
		if(userrepository.findByNomuser(user.getNomuser())== null) {
		user.setPassword(cryptageService.encode( user.getPassword()));}
		return userrepository.save(user);
	}

	@Override
	public long deleteUser(long id) {
		try {
			
			userrepository.deleteById(id);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	@Override
	public User updateUser(User user) {
		user.setPassword(cryptageService.encode( user.getPassword()));
		return userrepository.save(user);
	}
	@Override
	public User identification(String nomuser, String password) {
		User  u= userrepository.findByNomuser(nomuser);
		if (u!= null) {
		u=this.getByLogin(nomuser);
		if(cryptageService.matches(password, u.getPassword())) {
			System.out.println("Access granted ");
			return u;
		}}
		System.err.println("Access denied");
		return new User();
	}
	@Override
	public User getByLogin(String nomuser) {
		// TODO Auto-generated method stub
		return userrepository.findByNomuser(nomuser);
	}

}
