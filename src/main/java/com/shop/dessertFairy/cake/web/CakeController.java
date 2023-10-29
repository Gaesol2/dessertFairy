package com.shop.dessertFairy.cake.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CakeController {
	@RequestMapping("/cakeOrder")
	public String cakeOrder(HttpServletRequest request,
			                HttpServletResponse response,
			                Model model) {
		
		model.addAttribute("contentsJsp", "custom/cake/CakeOrder");
		
		return "Main";
	}

}
