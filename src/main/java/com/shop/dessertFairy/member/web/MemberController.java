package com.shop.dessertFairy.member.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.member.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("register")
	  public String  join(HttpServletRequest request,
			              HttpServletResponse response,
			              Model model,
			              MemberDTO mdto) {
		 
			model.addAttribute("contentsJsp", "member/Register");
		  return "Main";
	  }

	@RequestMapping("registerProc")
	public String  registerProc(HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			MemberDTO mdto) {
		System.out.println("mdto확인 :"+mdto.getM_id());
		int r = memberService.memberJoin(mdto);
		
		
		return "redirect:/";
	}
	
	@RequestMapping("login")
	public String login(HttpServletRequest request,
						HttpServletResponse response,
						MemberDTO mdto,
						Model model) {
		model.addAttribute("contentsJsp", "member/Login");
		return "Main";
		
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
