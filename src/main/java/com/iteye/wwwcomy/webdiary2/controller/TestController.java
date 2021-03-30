package com.iteye.wwwcomy.webdiary2.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	JdbcTemplate template;

	@RequestMapping(method = RequestMethod.GET)
	public String test1() {
		return "This is a test";
	}

	@PostConstruct
	public void post() {
		List<Map<String, Object>> diaryList = template.queryForList("select * from diary");
		System.out.println(diaryList.toString());
	}

}
