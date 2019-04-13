package com.itany.service;


import com.github.pagehelper.PageInfo;
import com.itany.pojo.User;

public interface ITestService {

	/**
	 *
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageInfo<User> findUserAll(Integer page, Integer rows);
	
}
