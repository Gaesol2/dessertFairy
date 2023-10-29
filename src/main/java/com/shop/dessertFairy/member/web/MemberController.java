package com.shop.dessertFairy.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.MemberDTO;
import com.shop.dessertFairy.memberService.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/register")
	  public String  join(HttpServletRequest request,
			              HttpServletResponse response,
			              Model model,
			              MemberDTO mdto) {
		  return "member/MemberJoin";
	  }
	
	@RequestMapping("login")
	public String login(HttpServletRequest request,
						HttpServletResponse response,
						MemberDTO mdto,
						Model model) {
		
		return "member/Login";
		
	}

	@RequestMapping("loginProc")
	public String loginProc(HttpServletRequest request,
							HttpServletResponse response,
							MemberDTO mdto,
							Model model) {
		
		HttpSession session = request.getSession();			// 현재 사용자의 세션을 얻어옴
//		MemberDTO memDto = memberService.getMember();		
		return "MsgPage";
		
	}
	 

}
