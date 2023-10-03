package com.poolcarz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poolcarz.dto.LoginDTO;
import com.poolcarz.dto.MessageDTO;
import com.poolcarz.dto.UserDTO;
import com.poolcarz.exception.PoolCarzException;
import com.poolcarz.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserRestController {
	
	@Autowired
	UserService userService;

//	@PostMapping("/login")
//	public ResponseEntity<MessageDTO> login(@RequestBody LoginDTO loginDTO) throws PoolCarzException{
//		return ResponseEntity.status(HttpStatus.OK).body(
//				userService.login(loginDTO)
//				);
//	}
	
	@PostMapping("/register")
	public ResponseEntity<MessageDTO> register(@RequestBody UserDTO userDTO) throws PoolCarzException{
		return ResponseEntity.status(HttpStatus.CREATED).body(
				userService.createUser(userDTO)
				
				);
	}
}
