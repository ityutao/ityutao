package com.itany.dao;

import com.itany.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
	
	public List<User> findUserAll();
	
	public User login(User user);

	public void insertUser(User user);

}
