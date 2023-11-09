package com.shop.dessertFairy.order.web;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.cart.service.CartService;
import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.order.dto.OrderDTO;
import com.shop.dessertFairy.order.service.OrderService;
import com.shop.dessertFairy.wrapper.OrderWrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

	@Autowired
	OrderWrapper orderWrapper;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("orderProc")
	public String OrderProc(HttpServletRequest request, HttpServletResponse response,
			Model model, OrderDTO odto) {
		//세션 받아와서 저장
		HttpSession session = request.getSession();
		MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");
		
		String msg = null;
		String url = null;
		String page = null;
		String contentsJsp = null;
		
		//hCartList getter로 가져오기
		Hashtable<Integer, OrderDTO> hCartList = cartService.getCartList();

		if(sdto==null) {
			msg = "로그인이 필요합니다.";
			url = "login";
			page = "MsgPage";
			
		} else {
			
			//dessert 재고 수 줄이고, order 테이블에 등록
			orderWrapper.orderProc(odto, hCartList);
			
			contentsJsp = "OrderDone";
			page = "Main";
		}
		
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		model.addAttribute("contentsJsp",contentsJsp);
		session.setAttribute("ssKey", sdto);
		session.setAttribute("hCartList", hCartList);
		return "page";
	}
	
}
