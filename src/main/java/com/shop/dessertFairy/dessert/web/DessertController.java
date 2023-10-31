package com.shop.dessertFairy.dessert.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DessertController {
		@RequestMapping("/dessert")
		public String dessert(HttpServletRequest request,
				                HttpServletResponse response,
				                Model model) {
			
			model.addAttribute("contentsJsp", "custom/dessert/DessertOrder");
			
			return "Main";
		}
		
		@RequestMapping("/dessertOrder")
		public String dessertOrder(HttpServletRequest request,
				HttpServletResponse response,
				Model model) {
			
			model.addAttribute("contentsJsp", "custom/dessert/DessertOrder");
			
			return "Main";
		}

		@RequestMapping("/cookieOrder")
		public String cookieOrder(HttpServletRequest request,
				HttpServletResponse response,
				Model model) {
			
			model.addAttribute("contentsJsp", "custom/dessert/CookieOrder");
			
			return "Main";
		}
		
		@RequestMapping("/breadOrder")
		public String breadOrder(HttpServletRequest request,
				HttpServletResponse response,
				Model model) {
			
			model.addAttribute("contentsJsp", "custom/dessert/BreadOrder");
			
			return "Main";
		}
		
		@RequestMapping("/puddingOrder")
		public String puddingOrder(HttpServletRequest request,
				HttpServletResponse response,
				Model model) {
			
			model.addAttribute("contentsJsp", "custom/dessert/PuddingOrder");
			
			return "Main";
		}
	}
