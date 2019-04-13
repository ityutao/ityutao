package com.itany.user.api;

import com.itany.exception.SmsCodeException;
import com.itany.exception.UserAlreadyLoginException;
import com.itany.exception.UserNotFoundException;
import com.itany.exception.UserPasswordException;
import com.itany.pojo.User;

import java.util.List;

public interface TestUserService {

    public User login(User user) throws UserNotFoundException, UserAlreadyLoginException;

    public List<User> findUsers();

    public void register(User user,String code) throws UserPasswordException, SmsCodeException;

}
