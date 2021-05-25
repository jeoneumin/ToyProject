package com.spring.test2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.test2.dao.MemberDao;
import com.spring.test2.dto.Member;
import com.spring.test2.service.MemberListGet;

@Controller
public class ListController {

	@Autowired
	private MemberListGet mlg;

	@RequestMapping("/list")
	public String init(Model model) {

		int pageSize = mlg.getPageSize();
		int scope = mlg.getPageScope(); // 페이지네비 범위
		int total = mlg.getTotal(); // 전체일반회원수
		int firstPage = 1; // 첫페이지
		List<Member> memberList = mlg.getMemberList(firstPage); // db에서 memberList가져오기
		/*
		 * for(Member member : memberList) { System.out.println("memberId: " +
		 * member.getMemberId()); System.out.println("userName: " +
		 * member.getUserName()); System.out.println("pw: " + member.getPw());
		 * System.out.println("answer: " + member.getAnswer());
		 * System.out.println("manageValue: " + member.getManageValue()); }
		 */

		int lastPage = (total % pageSize == 0) ? (total / pageSize) : (int) (total / pageSize) + 1;

		System.out.println("pageSize : " + pageSize + ", " + "scope : " + scope + ", " + "total : " + total + ", "
				+ "firstPage : " + firstPage + ", " + "lastPage : " + lastPage);

		// 모델에 첨부
		model.addAttribute("scope", scope);
		model.addAttribute("total", total);
		model.addAttribute("firstPage", firstPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("memberList", memberList);

		return "ajaxlist/listPage";

	}

	@RequestMapping(value = "/list/linkAjax", method = { RequestMethod.POST })
	@ResponseBody
	public List<Member> linkAjax(@RequestParam(value = "clickValue") String clickValue) {
		System.out.println("clickValue : " + clickValue);
		int currentPage = Integer.parseInt(clickValue);
		System.out.println("currentPage : " + currentPage);

		List<Member> memberList = mlg.getMemberList(currentPage);
		/*for (Member member : memberList) {
			System.out.println("memberId: " + member.getMemberId());
			System.out.println("userName: " + member.getUserName());
			System.out.println("pw: " + member.getPw());
			System.out.println("answer: " + member.getAnswer());
			System.out.println("manageValue: " + member.getManageValue());
		}*/
		return memberList;
	}

}
