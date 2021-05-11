package com.spring.test2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("test")
	public void test() {
		
	}
	
	@RequestMapping("proc1")
	public String proc1() {
		return "forward:proc2";
	}
	
	@RequestMapping("proc2")
	public String proc2() {
		return "redirect:test";
	}
	
	
}
