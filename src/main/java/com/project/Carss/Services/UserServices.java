package com.project.Carss.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Carss.Dto.AddUserDto;
import com.project.Carss.Repository.UserRepository;
import com.project.Carss.entities.User;

@Service
public class UserServices {

	@Autowired
	public UserRepository userRepository;
	
	public User create(AddUserDto addUserDto) {
		User user=new User();
		
		user.setName(addUserDto.getName());
		user.setPNumber(addUserDto.getPNumber());
		
		this.userRepository.save(user);
		return user;
	}
	
	public List<User> getAll(){
		List<User> user=this.userRepository.findAll();
		return user;
	}
	
	public User getUser(Integer id) {
		User user=new User();
		user=this.userRepository.findById(id).orElse(null);
		return user;
	}
	
	public void DeleteUser(Integer id) {
		User user=getUser(id);
		this.userRepository.delete(user);
	}
	
}
