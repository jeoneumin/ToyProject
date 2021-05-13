package com.spring.test2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonExample01 {
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		
		User user = setUser();
		
		try {
			
			//객체를 JSON 타입의 파일로 변환
			mapper.writeValue(new File("c:user.json"), user);
			
			//객체를 JSON 타입의 String으로 변환
			String jsonInString01 = mapper.writeValueAsString(user);
			System.out.println(jsonInString01);
			
			//객체를 JSON타입의 String으로 변환 및 정렬
			String jsonInString02 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
			System.out.println(jsonInString02);
		}catch (JsonGenerationException e) {
			e.printStackTrace();
		}catch (JsonMappingException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static User setUser() {
		User user = new User();
		user.setName("JSON");
		user.setAge(10);
		
		List<String> list = new ArrayList<String>();
		list.add("JSON은 자바스크립트를 확장하여 만들어졌습니다.");
		list.add("JSON은 자바스크립트 객체 표기법을 따릅니다.");
        list.add("JSON은 사람과 기계가 모두 읽기 편하도록 고안되었습니다.");
        list.add("JSON은 프로그래밍 언어와 운영체제에 독립적입니다.");
        user.setMessages(list);
        
        return user;
	}
}
