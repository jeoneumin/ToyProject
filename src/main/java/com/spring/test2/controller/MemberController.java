package com.spring.test2.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.test2.dao.MemberDao;
import com.spring.test2.dto.Member;
import com.spring.test2.service.ManagerRegisterService;
import com.spring.test2.service.MemberListGet;
import com.spring.test2.service.MemberLoginService;
import com.spring.test2.service.MemberRegisterService;
import com.spring.test2.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberRegisterService mrs;
	@Autowired
	private MemberLoginService mls;
	@Autowired
	private ManagerRegisterService managerRS;
	@Autowired
	private MemberListGet mLG;

	@RequestMapping("/")
	public String home(Locale locale) {
		return "login";
	}

	@RequestMapping("memberJoinForm")
	public String memberRegist(Locale locale) {
		return "registration";
	}

	@RequestMapping("superManager")
	public String goSuperManagerPage(Locale locale, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Member member = (Member) session.getAttribute("member");
		if (member != null) {
			if (member.getManageValue() == 2) {
				// 수퍼매니저 -> 접근 허락
				return "superManager";
			} else if (member.getManageValue() == 1) {
				// 접근불가
				return "managerHome";
			} else {
				return "cart";
			}
		} else {
			return "login";
		}

	}

	@RequestMapping("managerRegist")
	public String managerRegist() {
		return "managerRegistration";
	}

	@RequestMapping("managerJoinProc")
	public String managerJoinProc(Locale locale, Model model, Member member) {
		int result = 0;
		result = managerRS.managerRegister(member);
		if (result == 1) {
			// 메니저 회원가입 성공
			return "superManager";
		} else {
			// 매니저 회원가입 실패
			return "managerRegistration";
		}

	}

	@RequestMapping("managerHome")
	public String managerHome(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("member");
		Integer pageNum = (Integer) req.getAttribute("pageNum");

		if ((member == null)) {

			return "login";
		} else {
			if (member.getManageValue() == 0) {
				return "cart";
			}

			List<Member> memberList;

			if (pageNum == null) {
				pageNum = 1;
			} 
			
			memberList = mLG.getMemberList(pageNum);
			

			int pageScope = mLG.getPageScope();
			int total = mLG.getTotal(); // 전체 row수

			session.setAttribute("memberList", memberList);
			session.setAttribute("scope", pageScope);
			session.setAttribute("total", total);
			session.setAttribute("pageNum", pageNum);

			return "managerHome";
		}
	}

	@RequestMapping(value = "memberJoinProc", method = { RequestMethod.POST })
	public String memberInput(Locale locale, Model model, Member member, HttpSession session) {
		/*
		 * model.addAttribute("username", userName); model.addAttribute("username2",
		 * member.getUserName()); model.addAttribute("memberid", member.getMemberId());
		 * model.addAttribute("pw", member.getPw());
		 * model.addAttribute("answer",member.getAnswer());
		 */

		int result = 0;
		result = mrs.memberRegister(member);
		if (result == 1) {
			// 회원가입 성공
			// model.addAttribute("username", member.getUserName());
			return "login";
		} else {
			// 회원가입 실패
			return "registration";
		}

	}

	@RequestMapping(value = "memberLoginForm")
	public String memberLoginForm(Locale locale) {
		return "login";
	}

	@RequestMapping(value = "memberLogin")
	public String memberLogin(Locale locale, Member member, HttpServletRequest req) {
		Member result = mls.tryLogin(member);
		if (result != null) {
			// 로그인 성공
			HttpSession session = req.getSession();
			session.setAttribute("member", result);
			if (result.getManageValue() == 0) {
				// 일반회원
				return "cart";
			} else {
				return "redirect:managerHome";
			}
		} else {
			// 로그인 실패
			return "login";
		}

	}

	@RequestMapping(value = "logout")
	public String logout(HttpSession session, HttpServletRequest req) {
		session.removeAttribute("member");
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping(value = "cart")
	public String goCart(Locale locale) {
		return "cart";
	}
	
	@RequestMapping(value ="test")
	public String test(Locale locale,HttpSession session) {
		int pageScope = mLG.getPageScope();
		session.setAttribute("Scope", pageScope);
		return "test";
	}

}
