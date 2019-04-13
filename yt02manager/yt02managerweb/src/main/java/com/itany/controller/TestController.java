package com.itany.controller;


import com.github.pagehelper.PageInfo;
import com.itany.pojo.User;
import com.itany.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	ITestService testService;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public Map<String,Object> findAll(@RequestParam(defaultValue="1")Integer page,
			                          @RequestParam(defaultValue="10")Integer rows){
		
		Map<String,Object> map = new HashMap<String, Object>();
		PageInfo<User> info = testService.findUserAll(page, rows);
		map.put("total", info.getTotal());
		map.put("rows", info.getList());
		return map;
	}

}
