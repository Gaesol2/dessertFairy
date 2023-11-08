package com.shop.dessertFairy.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.order.dto.OrderDTO;
import com.shop.dessertFairy.wrapper.OrderWrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

	@Autowired
	OrderWrapper orderWrapper;
	
	@RequestMapping("orderProc")
	public String OrderProc(HttpServletRequest request, HttpServletResponse response,
			Model model, OrderDTO odto) {
		HttpSession session = request.getSession();
		MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");
		
		
		return "Main";
	}
	
}
