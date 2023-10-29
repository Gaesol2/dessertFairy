package com.shop.dessertFairy.custom.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

	@Controller
	public class CustomController {
		@RequestMapping("/")
		public String index(HttpServletRequest request, HttpServletResponse response,
				Model model) {
			String pages = "Main";
			model.addAttribute("contentsJsp", "RollingBanner");
		 
		  return pages;
		}
	
}
