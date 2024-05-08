package it.corso.service;

import java.util.List;

import it.corso.dto.UserLoginRequestDto;
import it.corso.dto.UserRegistrationDto;
import it.corso.dto.UserShowDto;
import it.corso.dto.UserUpdateDto;
import it.corso.model.User;

public interface UserService {

	void userRegistration(UserRegistrationDto userRegistrationDto);

	boolean existsByEmail(String email);

	List<UserShowDto> findAll();
	
	User findByEmail(String email);
	
	UserShowDto findUserByEmail(String email);
	
	void userUpdate(UserUpdateDto userRegistrationDto);
	
	void userDelete(String email);
	
	boolean userLogin(UserLoginRequestDto userLoginRequestDto);

}
