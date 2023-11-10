package com.shop.dessertFairy.order.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.member.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class OrderController {
	
	@RequestMapping("/orderList")
	  public String  orderList(HttpServletRequest request,
			              HttpServletResponse response,
			              Model model,
			              MemberDTO mdto) {
		 
			model.addAttribute("contentsJsp", "custom/mypage/OrderList");		// 회원가입 클릭 시 Register.jsp로 보냄
		  return "Main";
	  }
}
