package com.poolcarz.entity;


import com.poolcarz.dto.LoginDTO;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity(name="users")
public class UserEntity {

	@Id
	@SequenceGenerator(name = "userIdGenerator",allocationSize = 1)
	@GeneratedValue(generator = "userIdGenerator")
	private Integer userId;
	private String roles;
	private String userName;
	private String userPassword;
//	@Embedded
//	private LoginDTO loginDTO;
	
}
