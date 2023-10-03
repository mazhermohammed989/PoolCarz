package com.poolcarz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import com.poolcarz.dto.LoginDTO;
import com.poolcarz.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	@Query("select u from users u where u.userName=:userName")
	public Optional<UserEntity> findByLoginDTOUserName(String userName );
}
