package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.RoleDao;
import it.corso.dao.UserDao;
import it.corso.dto.UserLoginRequestDto;
import it.corso.dto.UserRegistrationDto;
import it.corso.dto.UserShowDto;
import it.corso.dto.UserUpdateDto;
import it.corso.model.Role;
import it.corso.model.User;

@Service
public class UserServiceImpl implements UserService {

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Override
	public void userRegistration(UserRegistrationDto userRegistrationDto) {

		userRegistrationDto.setPassword(DigestUtils.sha256Hex(userRegistrationDto.getPassword()));

		User user = modelMapper.map(userRegistrationDto, User.class);

		Optional<Role> role = roleDao.findById(userRegistrationDto.getRoleId());

		user.getRoleList().add(role.get());

		userDao.save(user);

	}

	@Override
	public boolean existsByEmail(String email) {

		return userDao.existsByEmail(email);

	}

	@Override
	public List<UserShowDto> findAll() {

		List<User> userList = userDao.findAll();

		List<UserShowDto> userShowDtoList = new ArrayList<>();

		userList.forEach(u -> userShowDtoList.add(modelMapper.map(u, UserShowDto.class)));

		return userShowDtoList;

	}

	@Override
	public User findByEmail(String email) {

		return userDao.findByEmail(email);

	}

	@Override
	public UserShowDto findUserByEmail(String email) {

		User user = findByEmail(email);

		UserShowDto userShowDto = modelMapper.map(user, UserShowDto.class);

		return userShowDto;
	}

	@Override
	public void userUpdate(UserRegistrationDto userRegistrationDto) {

		User user = findByEmail(userRegistrationDto.getEmail());

		if (user != null) {

			user.setName(userRegistrationDto.getName());
			user.setSurname(userRegistrationDto.getSurname());
			user.setPassword(DigestUtils.sha256Hex(userRegistrationDto.getPassword()));

			List<Role> roleList = new ArrayList<>();
			Optional<Role> role = roleDao.findById(userRegistrationDto.getRoleId());

			if (role.isPresent()) {

				Role r = role.get();

				r.setId(userRegistrationDto.getRoleId());

				roleList.add(r);

				user.setRoleList(roleList);

			}

			userDao.save(user);

		}

	}

	@Override
	public void userDelete(String email) {

		User user = userDao.findByEmail(email);

		if (user != null) {

			userDao.delete(user);

		}

	}

	@Override
	public boolean userLogin(UserLoginRequestDto userLoginRequestDto) {
		
		String hashedPassoword = DigestUtils.sha256Hex(userLoginRequestDto.getPassword());

		return userDao.findByEmailAndPassword(userLoginRequestDto.getEmail(), hashedPassoword) != null ? true
				: false;
	}

}
