package com.shop.dessertFairy.mypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class MypageController {
	
	

	
	@RequestMapping("/orderList")
	public String orderList(HttpServletRequest request,
			             HttpServletResponse response,
			             Model model) {
		
		
		model.addAttribute("contentsJsp", "custom/mypage/OrderList");
		return "Main";
	}
	
	@RequestMapping("/contactList")
	public String contactList(HttpServletRequest request,
			HttpServletResponse response,
			Model model) {
		
		
		model.addAttribute("contentsJsp", "custom/mypage/ContactList");
		return "Main";
	}
}
