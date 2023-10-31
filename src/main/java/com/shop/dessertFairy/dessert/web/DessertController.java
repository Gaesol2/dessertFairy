package com.shop.dessertFairy.dessert.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.dessert.service.DessertService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DessertController {
	
	@Autowired
	DessertService dessertService;
	
	@RequestMapping("/dessert")
	public String dessertOrder(HttpServletRequest request,
			HttpServletResponse response,
			Model model) {			
		//로그인 안 해도 접속 가능
		
		//데이터베이스 가서 전체 디저트 개수 받아오기
		//데이터베이스에서 ddto로 받아와서 이미지 정보도 주어야 한다

		String flag = request.getParameter("flag");
		
		Map<String, Object> resultSet = new HashMap<>();
		
		resultSet = dessertService.getDessertList(flag);
		
		
		//받아온 정보 jsp로 보내서
		
		model.addAttribute("endBox",resultSet.get("endBox"));
		model.addAttribute("dessert",resultSet.get("dessert"));
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
