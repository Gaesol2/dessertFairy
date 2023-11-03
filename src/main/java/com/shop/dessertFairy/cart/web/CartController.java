package com.shop.dessertFairy.cart.web;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.cart.service.CartService;
import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.order.dto.OrderDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping("cartList")
	public String CartList (HttpServletRequest request, HttpServletResponse response,
			Model model) {
		
		//세션 받아오기
		HttpSession session = request.getSession();
		MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");
		
		//변수 선언
		String msg = null;
		String page = null;
		String url = null;
		String contentsJsp = null;
		
		//로그인 세션 확인
		if(session.getAttribute("ssKey")==null) {
			msg = "로그인이 필요합니다.";
			url = "redirect:/login";
			page = "MsgPage";
		} else {
			@SuppressWarnings("unchecked")
			Hashtable<Integer, OrderDTO> hCartList = (Hashtable<Integer, OrderDTO>) session.getAttribute("hCartList");
			page = "Main";
			contentsJsp = "custom/mypage/CartList";
		}
	
		model.addAttribute("msg",msg);
		model.addAttribute("url", url);
		model.addAttribute("contentsJsp",contentsJsp);
		session.setAttribute("ssKey", sdto);
		return page;
	}
	
	@RequestMapping("cartProc")
	public String CartProc(HttpServletRequest request, HttpServletResponse response,
			Model model, OrderDTO odto){
		
		HttpSession session = request.getSession();
		MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");
		odto.setM_id(sdto.getM_id());
		
		Hashtable<Integer, OrderDTO> hCartList = (Hashtable<Integer, OrderDTO>) session.getAttribute("hCartList");
		
		
		
		
		
		return "";
	} 
}
