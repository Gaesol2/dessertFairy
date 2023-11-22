package com.shop.dessertFairy.cake.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.cake.dto.CakeDTO;
import com.shop.dessertFairy.cake.service.CakeService;
import com.shop.dessertFairy.member.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CakeController {
	
	@Autowired
	CakeService cakeService;
	
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
		//멀티파트 추가하기
		
		HttpSession session = request.getSession();
		MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");
		
		String msg = null;
		String page = null;
		String url = null;
		String contentsJsp = null;
		
		if(sdto==null) {
			msg = "로그인이 필요합니다.";
			page = "MsgPage";
			url = "login";
		} else {
			page = "Main";
			contentsJsp = "CakeComplete";
		}
		
		int result = cakeService.cakeOrderProc(cdto);
		
		
		System.out.println("케이크=========>"+cdto);
		model.addAttribute("msg",msg);
		model.addAttribute("url",url);
		model.addAttribute("contentsJsp",contentsJsp);
		model.addAttribute("cdto",cdto);
		session.setAttribute("ssKey", sdto);
		
		return page;
	}
}
