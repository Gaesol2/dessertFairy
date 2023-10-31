package com.shop.dessertFairy.mypage.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class MypageController {

	
	@RequestMapping("/myPage")
	
	public String myPage(HttpServletRequest request,
			             HttpServletResponse response,
			             Model model) {

		
		
		      model.addAttribute("contentsJsp", "custom/mypage/MyPage");
		      return "Main";
	}
	
	
	@RequestMapping("/cartList")
	public String cartList(HttpServletRequest request,
			             HttpServletResponse response,
			             Model model) {
	
		
		
		model.addAttribute("contentsJsp", "custom/mypage/CartList");
		return "Main";
	}
	
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
