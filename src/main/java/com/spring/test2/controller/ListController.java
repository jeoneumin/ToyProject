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
	
	@RequestMapping(value = "/list/nextAjax", method = {RequestMethod.POST})
	@ResponseBody
	public String[] nextAjax(@RequestParam(value="lastNumAtagValue") String lastNumString) {
		System.out.println("in nextAjax Controller");
		System.out.println("lastNumString : " + lastNumString);
		
		int lastNum = Integer.parseInt(lastNumString);
		System.out.println("lastNum " + lastNum);
		
		int scope = mlg.getPageScope(); //페이지 범위 크기
		
		int startNum = lastNum + 1; //페이지 시작번호
		/*int endNum = lastNum + scope; */
		System.out.println("startNum : " + startNum);
		/*System.out.println("endNUm : " + endNum);*/
		System.out.println("scope : " + scope);
		
		String[] pageNumSet = new String[scope];
		for(int i = 0;i<scope;i++) {
			pageNumSet[i] = Integer.toString(startNum + i);
		}
		
		for(int i = 0; i<scope;i++) {
			System.out.printf("pageNumSet[%d] = %s\n",i,pageNumSet[i]);
		}
		
		
		return pageNumSet;
	}
	
	@RequestMapping(value="/list/preAjax", method= {RequestMethod.POST})
	@ResponseBody
	public String[] preAjax(@RequestParam("navAtagFirst") String firstNumStr) {
		System.out.println("preAjax controller 요청 받음");
		System.out.println("전달 데이터(navAtagFirst) : " + firstNumStr);
		
		int firstNum = Integer.parseInt(firstNumStr);
		System.out.println("firstNum : "+ firstNum);
		
		int scope = mlg.getPageScope();
		int startNum = firstNum - scope;
		System.out.println("scope : " +scope);
		System.out.println("startNum : " + startNum);
		String[] aTagScope = new String[scope];
		System.out.println("aTagScope length : " + aTagScope.length);
		
		for(int i=0;i<scope;i++) {
			aTagScope[i] = Integer.toString(startNum+i);
		}
		
		for(int i=0;i<scope;i++) {
			System.out.printf("aTagScope[%d] = %s\n" ,i,aTagScope[i]);
		}
		
		
		
		return aTagScope;
	}
	

}
