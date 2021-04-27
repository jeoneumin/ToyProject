package com.spring.test2.member.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.test2.member.Member;

@Controller
public class MemberController {
	
	@Autowired
	private 

	@RequestMapping("memberJoinForm")
	public String memberRegist() {
		return "registration";
	}
	
	@RequestMapping(value = "memberJoinProc", method = {RequestMethod.POST} )
	public String memberInput(Locale locale, Model model, String userName, Member member) {
		model.addAttribute("username", userName);
		model.addAttribute("username2", member.getUserName());
		model.addAttribute("memberid", member.getMemberId());
		model.addAttribute("pw", member.getPw());
		model.addAttribute("answer",member.getAnswer());
		return "memberInputTest";
	}
}
