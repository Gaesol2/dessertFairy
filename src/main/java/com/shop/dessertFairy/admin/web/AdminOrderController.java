package com.shop.dessertFairy.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.member.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminOrderController {

	@RequestMapping("orderMgt")
	public String OrderMgt(HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			MemberDTO adto) {
		HttpSession session = request.getSession();
		MemberDTO ssKey = null;
		String page = null;
		
		if(session.getAttribute("ssKey") != null) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			if(ssKey.getM_role().equals("admin")) {
				model.addAttribute("contentsJsp", "admin/order/OrderMgt");
				page = "Main";
			}
			else page = "redirect:/";
		}
		return page;
	}
}
