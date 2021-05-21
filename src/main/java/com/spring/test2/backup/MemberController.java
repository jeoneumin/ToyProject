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
import com.spring.test2.service.ManagerDeleteService;
import com.spring.test2.service.ManagerListGet;
import com.spring.test2.service.ManagerRegisterService;
import com.spring.test2.service.MemberDeleteService;
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
	private MemberListGet mLG;
	@Autowired
	private MemberDeleteService mds;
	@Autowired
	private ManagerRegisterService managerRS;
	@Autowired
	private ManagerListGet maLG;
	@Autowired
	private ManagerDeleteService mads;


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
		

		boolean isSuccess;
		isSuccess = mrs.memberRegister(member);
		if (isSuccess) {
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
			if (result.getManageValue().equals("member")) {
				// 일반회원
				return "redirect:cart";
			} else {
				return "forward:managerHomeProc";
			}
		} else {
			// 로그인 실패
			model.addAttribute("msg","아이디와 비밀번호를 다시 확인해주세요." );
			return "redirect:login";
		}

	}
	
	
	
	@RequestMapping(value="managerHomeProc")
	public String managerHomeProc(HttpSession session, Model model,@RequestParam(required = false) Integer pageNum) {
		
		Member member = (Member) session.getAttribute("member");

		if ((member == null)) {

			return "redirect:login";
		} else {
			if (member.getManageValue().equals("member")) {
				return "redirect:cart";
			}

			List<Member> memberList;
			
			//로그인 직후 pageNum
			if( pageNum ==  null) {
				pageNum=1;
			}

			
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
	public String superManagerProc( HttpServletRequest req,@RequestParam(required = false) Integer pageNum) {
		HttpSession session = req.getSession(false);
		Member member = (Member) session.getAttribute("member");
		if (member != null) {
			if (member.getManageValue().equals("superManager")) {
				// 수퍼매니저 -> 접근 허락
				
				List<Member> managerList;
				
				//로그인 직후 pageNum
				if( pageNum ==  null) {
					pageNum=1;
				}

				
				managerList = maLG.getManagerList(pageNum);
				

				int pageScope = maLG.getPageScope();
				int total = maLG.getTotal(); // 전체 row수

				session.setAttribute("managerList", managerList);
				session.setAttribute("scope", pageScope);
				session.setAttribute("total", total);
				session.setAttribute("pageNum", pageNum);
				
				return "redirect:superManager";
			} else if (member.getManageValue().equals("manager")) {
				// 접근불가
				return "redirect:managerHomeProc";
			} else {
				return "redirect:cart";
			}
		} else {
			return "redirect:login";
		}

	}
	

	@RequestMapping("managerRegistProc")
	public String managerRegistProc(Model model, Member member) {
		boolean isSuccess;
		isSuccess = managerRS.managerRegister(member);
		if (isSuccess) {
			// 메니저 회원가입 성공
			model.addAttribute("msg", "회원가입 성공");
			return "redirect:superManager";
		} else {
			// 매니저 회원가입 실패
			model.addAttribute("msg", "회원가입 실패");
			return "redirect:managerRegistration";
		}

	}
	
	@RequestMapping("memberUpdateProc")
	public String memberUpdateProc() {
		
		//데이터받기

		//데이터처리하기
		
		return "forward:managerHomeProc";
	}
	
	@RequestMapping("memberDeleteProc")
	public String memberDeleteProc(HttpServletRequest req) {
		
		boolean isSuccess=false;
		
		//view에서 선택한 memberId가 담기는 배열
		String[] stData=req.getParameterValues("memberIdArr");
		
		if(stData == null) {
			//넘어온 데이터 없음
			return "forward:managerHomeProc";
		}
		
		String[] memberIdArr = stData[0].split(",");
		
		for(String memberId:memberIdArr) {
			isSuccess = mds.deleteMember(memberId);
			if(!isSuccess) {
				//삭제 실패시
				return "forward:managerHomeProc";
			}
		}
		//삭제 성공시
		return "forward:managerHomeProc";
	}
	
	@RequestMapping("managerDeleteProc")
	public String managerDeleteProc(HttpServletRequest req) {
		boolean isSuccess=false;
		
		String[] stData=req.getParameterValues("managerIdArr");
		
		if(stData == null) {
			//넘어온 데이터 없음
			System.out.println("넘어온 managerIdArr 없음");
			return "forward:managerHomeProc";
		}
		
		System.out.println("stData: "+ stData[0]);
		
		String[] managerIdArr = stData[0].split(",");
		
		for(String managerId:managerIdArr) {
			isSuccess = mads.deleteManager(managerId);
			if(!isSuccess) {
				System.out.println(managerId+"삭제 실패");
				return "forward:superManagerProc";
			}
		}
		
		return "forward:superManagerProc";
	}

	
	/*로그아웃 처리*/
	@RequestMapping(value = "logout")
	public String logout(HttpSession session, HttpServletRequest req) {
		session.removeAttribute("member");
		session.invalidate();
		return "redirect:login";
	}

	

}
