package com.poolcarz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.poolcarz.dto.MessageDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PoolCarzException.class)
	public ResponseEntity<MessageDTO> poolCarzHandler(PoolCarzException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				MessageDTO.builder()
				.message(e.getMessage())
				.build()
				
				);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MessageDTO> poolCarzHandler(Exception e){
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(
				MessageDTO.builder()
				.message("got some error")
				.build()
				
				);
	}
}
