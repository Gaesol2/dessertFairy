package com.shop.dessertFairy.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.member.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	@RequestMapping("shopMgt")
	public String ShopMgt(HttpServletRequest request,
            			  HttpServletResponse response,
            			  Model model,
            			  MemberDTO mdto) {
		HttpSession session = request.getSession();
		MemberDTO ssKey = null;
		String page = null;
		
		if(session.getAttribute("ssKey") != null) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			if(ssKey.getM_role().equals("admin")) {
				model.addAttribute("contentsJsp", "admin/ShopMgt");
				page = "Main";
			}
			else page = "redirect:/";
		}
		return page;
	}

	@RequestMapping("productMgt")
	public String ProductMgt(HttpServletRequest request,
							 HttpServletResponse response,
							 Model model,
							 MemberDTO adto) {
		HttpSession session = request.getSession();
		MemberDTO ssKey = null;
		String page = null;
		
		if(session.getAttribute("ssKey") != null) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			if(ssKey.getM_role().equals("admin")) {
				model.addAttribute("contentsJsp", "admin/ProductMgt");
				page = "Main";
			}
			else page = "redirect:/";
		}
		return page;
	}

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
				model.addAttribute("contentsJsp", "admin/OrderMgt");
				page = "Main";
			}
			else page = "redirect:/";
		}
		return page;
	}
	
	@RequestMapping("memberMgt")
	public String MemberMgt(HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			MemberDTO adto) {
		HttpSession session = request.getSession();
		MemberDTO ssKey = null;
		String page = null;
		
		if(session.getAttribute("ssKey") != null) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			if(ssKey.getM_role().equals("admin")) {
				model.addAttribute("contentsJsp", "admin/MemberMgt");
				page = "Main";
			}
			else page = "redirect:/";
		}
		return page;
	}
}
