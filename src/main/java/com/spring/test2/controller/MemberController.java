package com.spring.test2.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.test2.dao.MemberDao;
import com.spring.test2.dto.Member;
import com.spring.test2.service.MemberLoginService;
import com.spring.test2.service.MemberRegisterService;
import com.spring.test2.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberRegisterService mrs;
	@Autowired
	private MemberLoginService mls;
	
	@RequestMapping("/")
	public String home(Locale locale) {
		return "login";
	}

	@RequestMapping("memberJoinForm")
	public String memberRegist(Locale locale) {
		return "registration";
	}
	
	@RequestMapping(value = "memberJoinProc", method = {RequestMethod.POST} )
	public String memberInput(Locale locale, Model model, String userName, Member member,HttpSession session) {
		/*model.addAttribute("username", userName);
		model.addAttribute("username2", member.getUserName());
		model.addAttribute("memberid", member.getMemberId());
		model.addAttribute("pw", member.getPw());
		model.addAttribute("answer",member.getAnswer());*/
		
		int result = 0;
		result = mrs.memberRegister(member);
		if(result == 1) {
			//회원가입 성공
			//model.addAttribute("username", member.getUserName());
			session.setAttribute("member", member);
			return "cart";
		}else {
			//회원가입 실패
			return "registration";
		}
		
	}
	
	@RequestMapping(value = "memberLoginForm")
	public String memberLoginForm(Locale locale) {
		return "login";
	}
	
	@RequestMapping(value = "memberLogin")
	public String memberLogin(Locale locale, String memberId, String pw,HttpSession session) {
		int result = mls.tryLogin(memberId,pw);
		if(result ==1) {
			//로그인 성공
			session.setAttribute("memberId", memberId);
			return "cart";
		}else {
			//로그인 실패
			return "login";
		}
		
	}
	
	@RequestMapping(value="logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
}
