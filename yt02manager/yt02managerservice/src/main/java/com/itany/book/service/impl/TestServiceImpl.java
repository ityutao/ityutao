package com.itany.book.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.mapper.UserMapper;
import com.itany.pojo.User;
import com.itany.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED)
public class TestServiceImpl implements ITestService{

	@Autowired
	UserMapper userMapper;
	
	
	@Transactional(readOnly=true)
	public PageInfo<User> findUserAll(Integer page,Integer rows) {
		PageHelper.startPage(page, rows);
		List<User> list = userMapper.findUserAll();
		PageInfo<User> info = new PageInfo<User>(list);
		return info;
	}

}
