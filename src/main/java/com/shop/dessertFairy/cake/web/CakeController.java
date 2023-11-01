package com.shop.dessertFairy.cake.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.cake.dto.CakeDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CakeController {
	@RequestMapping("/cake")
	public String cake(HttpServletRequest request,
			                HttpServletResponse response,
			                Model model,
			                CakeDTO cdto) {
		
		model.addAttribute("contentsJsp", "custom/cake/CakeOrder");
		
		return "Main";
	}

}
