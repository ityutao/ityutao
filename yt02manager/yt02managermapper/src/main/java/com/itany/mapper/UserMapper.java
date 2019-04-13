package com.itany.mapper;

import com.itany.pojo.User;

import java.util.List;

public interface UserMapper {
	
	 List<User> findUserAll();

	 void addUser(User user);

	 User login(User user);

}
