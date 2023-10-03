package com.poolcarz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poolcarz.dto.MessageDTO;

@RestController
@RequestMapping("/rides")
@CrossOrigin
public class RidesRestController {

	@GetMapping
	public ResponseEntity<MessageDTO> testingAuthentication(){
		return ResponseEntity.status(HttpStatus.OK).body(
				MessageDTO.builder()
				.message("You're authenticated")
				.build()
				);
	}
}
