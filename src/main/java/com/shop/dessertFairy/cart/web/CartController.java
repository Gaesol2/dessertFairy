package com.shop.dessertFairy.cart.web;

import java.util.Hashtable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.order.dto.OrderDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	@RequestMapping("cartList")
	public String CartList (HttpServletRequest request, HttpServletResponse response,
			Model model) {
		
		HttpSession session = request.getSession();
		
		String msg = null;
		String page = null;
		String url = null;
		
		if(session.getAttribute("ssKey")==null) {
			msg = "로그인이 필요합니다.";
			url = "redirect:/login";
		} else {
			
			
			
		}
	
		return page;
	}
}
