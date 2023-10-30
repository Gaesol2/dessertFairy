package com.shop.dessertFairy.member.web;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		 
			model.addAttribute("contentsJsp", "custom/member/Register");
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
	
	@RequestMapping("/idCheck")
	@ResponseBody
	public int idCheck(HttpServletRequest request,
					   HttpServletResponse response,
					   Model model,
					   MemberDTO mdto) {
		  int cnt = 0;
		    if(mdto.getM_id()!=null) {
		    	cnt = memberService.idCheck(mdto.getM_id());
		    }
		  return cnt;
	  }
	
	@RequestMapping("login")
	public String login(HttpServletRequest request,
						HttpServletResponse response,
						MemberDTO mdto,
						Model model) {
		model.addAttribute("contentsJsp", "custom/member/Login");
		return "Main";
		
	}

	@RequestMapping("loginProc")
	public String loginProc(HttpServletRequest request,
							HttpServletResponse response,
							MemberDTO mdto,
							Model model) {
		
		HttpSession session = request.getSession();
		MemberDTO sdto = memberService.getMember(mdto);
		String url="/";
	    String msg;
	    System.out.println("sdto"+sdto);
		if(sdto!=null) {
		//회원 맞음
			if(sdto.getM_role().equals("admin")) {
				//관리자용 페이지로 url
				url="/admin/";
			}else {
				url="/";
			}
			MemberDTO ssKey = new MemberDTO();
			ssKey.setM_id(sdto.getM_id());
			ssKey.setM_passwd(sdto.getM_passwd());
			ssKey.setM_name(sdto.getM_name());
			ssKey.setM_role(sdto.getM_role());
		    msg =  sdto.getM_name()+"님 반값습니다.!!";
			session.setAttribute("ssKey", ssKey);
		} else msg="아이디 또는 패스워드 맞지 않습니다.";
			
		model.addAttribute("msg",msg);
		model.addAttribute("url", url);
		
		return "MsgPage";
	}
	 
}
