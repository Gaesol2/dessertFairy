package com.shop.dessertFairy.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.wrapper.OrderWrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

	@Autowired
	OrderWrapper orderWrapper;
	
	@RequestMapping("orderProc")
	public String OrderProc(HttpServletRequest request) {
		
		
		
		return "Main";
	}
	
}
