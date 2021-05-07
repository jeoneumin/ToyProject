package com.spring.test2.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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


@Controller
public class MemberController {
	
	//static Logger logger = Logger.getLogger(MemberController.class);
	

	@Autowired
	private MemberRegisterService mrs;
	@Autowired
	private MemberLoginService mls;
	@Autowired
	private ManagerRegisterService managerRS;
	@Autowired
	private MemberListGet mLG;

	@RequestMapping("/")
	public String home() {
		return "login";
	}
	
	@RequestMapping("registration")
	public String registration() {
		return "registration";
	}
	
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("cart")
	public String cart() {
		return "cart";
	}
	
	@RequestMapping("managerHome")
	public String managerHome() {
		return "managerHome";
	}
	
	@RequestMapping("superManager")
	public String superManager() {
		return "superManager";
	}
	
	@RequestMapping("managerRegistration")
	public String managerRegistration() {
		return "managerRegistration";
	}
	
	@RequestMapping(value="memberJoinProc", method = {RequestMethod.GET})
	public String memberJoinProc(Model model) {
		model.addAttribute("msg","폼을 먼저 작성해주세요.");
		return "redirect:registration";
	}
	
	@RequestMapping(value = "memberJoinProc", method = { RequestMethod.POST })
	public String memberJoinProc(Model model, Member member,HttpSession session) {
		

		int result = 0;
		result = mrs.memberRegister(member);
		if (result == 1) {
			// 회원가입 성공
			//model.addAttribute("msg", "success");
			//session.setAttribute("msg", "success");
			return "redirect:login";
		} else {
			// 회원가입 실패
			//model.addAttribute("msg", "fail");
			//session.setAttribute("msg","fail");
			return "redirect:registration";
		}

	}
	

	@RequestMapping(value = "memberLoginProc", method = { RequestMethod.GET })
	public String memberLoginProc() {
		return "redirect:login";
	}
	
	@RequestMapping(value = "memberLoginProc", method = { RequestMethod.POST })
	public String memberLoginProc(Model model,Member member, HttpServletRequest req) {
		Member result = mls.tryLogin(member);
		if (result != null) {
			// 로그인 성공
			HttpSession session = req.getSession();
			session.setAttribute("member", result);
			if (result.getManageValue() == 0) {
				// 일반회원
				return "redirect:cart";
			} else {
				return "redirect:managerHomeProc?pageNum=1";
			}
		} else {
			// 로그인 실패
			model.addAttribute("msg","아이디와 비밀번호를 다시 확인해주세요." );
			return "redirect:login";
		}

	}
	
	
	
	@RequestMapping(value="managerHomeProc")
	public String managerHomeProc(HttpServletRequest req, Model model, int pageNum) {
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("member");

		if ((member == null)) {

			return "redirect:login";
		} else {
			if (member.getManageValue() == 0) {
				return "redirect:cart";
			}

			List<Member> memberList;

			
			memberList = mLG.getMemberList(pageNum);
			

			int pageScope = mLG.getPageScope();
			int total = mLG.getTotal(); // 전체 row수

			session.setAttribute("memberList", memberList);
			session.setAttribute("scope", pageScope);
			session.setAttribute("total", total);
			session.setAttribute("pageNum", pageNum);

			return "redirect:managerHome";
		}
	}

	@RequestMapping("superManagerProc")
	public String superManagerProc( HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Member member = (Member) session.getAttribute("member");
		if (member != null) {
			if (member.getManageValue() == 2) {
				// 수퍼매니저 -> 접근 허락
				return "redirect:superManager";
			} else if (member.getManageValue() == 1) {
				// 접근불가
				return "redirect:managerHomeProc?pageNum=1";
			} else {
				return "redirect:cart";
			}
		} else {
			return "redirect:login";
		}

	}
	

	@RequestMapping("managerRegistProc")
	public String managerRegistProc(Model model, Member member) {
		int result = 0;
		result = managerRS.managerRegister(member);
		if (result == 1) {
			// 메니저 회원가입 성공
			model.addAttribute("msg", "회원가입 성공");
			return "redirect:superManager";
		} else {
			// 매니저 회원가입 실패
			model.addAttribute("msg", "회원가입 실패");
			return "redirect:managerRegistration";
		}

	}

	
	/*로그아웃 처리*/
	@RequestMapping(value = "logout")
	public String logout(HttpSession session, HttpServletRequest req) {
		session.removeAttribute("member");
		session.invalidate();
		return "redirect:login";
	}

	

}
