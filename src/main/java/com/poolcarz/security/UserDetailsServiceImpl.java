package com.poolcarz.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.poolcarz.entity.UserEntity;
import com.poolcarz.repository.UserRepository;
import com.poolcarz.utility.PoolCarzMessages;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserEntity> optional=userRepository.findByLoginDTOUserName(username);
//		if(!optional.isPresent()) throw new UsernameNotFoundException(PoolCarzMessages.USER_NOT_FOUND.toString() + username);
//		UserEntity userEntity=mapper.map(optional, UserEntity.class);
//		Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
//		return optional.map(UserDetailsImpl::new)
//	                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
		
		return optional
			.map(UserDetailsImpl::new)
			.orElseThrow(
					()->new UsernameNotFoundException(PoolCarzMessages.USER_NOT_FOUND.toString() + username)
					);
		
	}

}
