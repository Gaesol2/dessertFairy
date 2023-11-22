package com.shop.dessertFairy.cake.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.cake.dto.CakeDTO;
import com.shop.dessertFairy.member.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CakeController {
	@RequestMapping("/cake")
	public String cake(HttpServletRequest request,
			                HttpServletResponse response,
			                Model model) {
		
		model.addAttribute("contentsJsp", "custom/cake/CakeOrder");
		
		return "Main";
	}

	@RequestMapping("cakeRequest")
	public String CakeRequest(HttpServletRequest request, HttpServletResponse response) {
		return "custom/cake/CakeRequest";
	}
	
	@RequestMapping("cakeOrderProc")
	public String CakeOrderProc(HttpServletRequest request, HttpServletResponse response,
			Model model, CakeDTO cdto) {
		
		HttpSession session = request.getSession();
		MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");
		
		String msg = null;
		String page = null;
		String url = null;
		
		if(sdto==null) {
			msg = "로그인이 필요합니다.";
			page = "MsgPage";
			url = "login";
		} else {
			
		}
		
		System.out.println("케이크=========>"+cdto);
		return page;
	}
}
