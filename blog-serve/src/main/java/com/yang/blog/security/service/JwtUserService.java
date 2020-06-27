package com.yang.blog.security.service;

import com.yang.blog.pojo.User;
import com.yang.blog.security.mapper.UserDetailMapper;
import com.yang.blog.security.pojo.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class JwtUserService implements UserDetailsService{

	@Autowired
	private UserDetailMapper userDetailMapper;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = new User();
		user.setUsername(username);
		user = userDetailMapper.findByUsername(username);
		UserDetail userDetail = new UserDetail();
		userDetail.setUsername(user.getUsername());
		userDetail.setPassword(user.getPassword());
		userDetail.setRoles(user.getRoles());
		userDetail.getAuthorities();
		return userDetail;
	}
	

}
