package com.spring.test2.controller;

import java.util.HashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.test2.dto.Jamong;

@Controller
public class TestController {
	
	private static final Logger logger = LogManager.getLogger(TestController.class);
	

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
	
	@RequestMapping(value="testconfig", produces="application/json;charset=UTF-8",method=RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> testconfig(@RequestBody HashMap<String, Object> params){
		
		System.out.println((Integer)params.get("age")*9);
		return params;
	}
	
	@RequestMapping("test2")
	public String test2() {
		return "test2";
	}
	
	@RequestMapping(value="/jsonTest", method=RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> jsonTest() throws Exception{
		logger.info("json 웹 출력 테스트");
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("test", "hello?");
		return resMap;
	}
	
	@RequestMapping(value="/requestObject", method=RequestMethod.POST)
	@ResponseBody
	public String simpleWithObject(Jamong jamong) {
		return jamong.getName() + jamong.getAge();
	}
	
	
	
}
