package com.poolcarz.dto;


import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class UserDTO {
	private Integer userId;
	private String roles;

	private String userName;
	private String userPassword;
//	@Embedded
//	private LoginDTO loginDTO;	
}
