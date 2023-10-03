package com.poolcarz.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.poolcarz.dto.LoginDTO;
import com.poolcarz.dto.MessageDTO;
import com.poolcarz.dto.UserDTO;
import com.poolcarz.entity.UserEntity;
import com.poolcarz.exception.PoolCarzException;
import com.poolcarz.repository.UserRepository;
import com.poolcarz.utility.PoolCarzMessages;

import jakarta.transaction.Transactional;

//@Transactional
@Service
public class UserService{

	@Autowired
	UserRepository repository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	ModelMapper mapper;
	
//	@Autowired
//	AuthenticationManager authenticationManager;
	
//	public MessageDTO login(LoginDTO loginDTO) throws PoolCarzException{
////		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUserName(), loginDTO.getUserPassword()));
//		return MessageDTO.builder().build();
//	}
	
	public MessageDTO createUser(UserDTO userDTO) throws PoolCarzException{
		userDTO.setUserPassword(passwordEncoder.encode(userDTO.getUserPassword()));
		UserEntity savedUser=repository.save(mapper.map(userDTO, UserEntity.class));
		
		return MessageDTO.builder()
				.message(PoolCarzMessages.REGISTRATION_SUCCESS.toString() + savedUser.getUserId())	
				.build();
	}
}
