package com.iteye.wwwcomy.webdiary2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@RequestMapping(method = RequestMethod.GET)
	public String test1() {
		return "This is a test";
	}

}
