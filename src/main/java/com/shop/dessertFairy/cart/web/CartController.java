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
			Model model, OrderDTO odto) {
		
		//세션 받아오기
		HttpSession session = request.getSession();
		MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");
		
		//변수 선언
		String msg = null;
		String page = null;
		String url = null;
		String contentsJsp = null;
		
		//로그인 세션 확인
		if(sdto==null) {
			msg = "로그인이 필요합니다.";
			url = "login";
			page = "MsgPage";
		} else {
			@SuppressWarnings("unchecked")
			Hashtable<Integer, OrderDTO> hCartList = (Hashtable<Integer, OrderDTO>) session.getAttribute("hCartList");
			session.setAttribute("hCartList", hCartList);
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
		
		String msg = null;
		String url = null;
		String conf = null;
		String page = "MsgPage";
		
		//세션 받아오기
		HttpSession session = request.getSession();
		MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");
		
		//회원에 따라서 여러 주문을 저장해 장바구니를 형성한다.
		//회원 메인키 m_id (int)를 키로 저장, 장바구니에 들어갈 주문 하나씩 (OrderDTO)을 값으로 저장하기 위해 <Integer, OrderDTO> 제네릭 사용
		//세션에 저장하기 위해 세션(hCartList)에 해당 해시테이블(hCartList)를 저장 
		Hashtable<Integer, OrderDTO> hCartList = (Hashtable<Integer, OrderDTO>) session.getAttribute("hCartList");
		
		if(hCartList == null) hCartList = new Hashtable<Integer, OrderDTO>();
		
		//세션에서 받아온 hCartList를 cartSerivce의 hCartList에 저장하는 setter 호출
		cartService.setCartList(hCartList);

		//세션이 없으면 로그인 페이지로 보내기
		if(sdto==null) {
			msg = "로그인이 필요합니다.";
			url = "login";
		} else {
			//세션에서 m_id를 받아서 odto에 저장
			odto.setM_id(sdto.getM_id());
		
			String flag = request.getParameter("flag");
			
			switch(flag) {
				case "insert" : {
					hCartList = cartService.addCartList(odto);
					System.out.println("hCart========<>"+hCartList);
					conf = "장바구니에 담았습니다. 장바구니로 이동하시겠습니까?";
					url = "cartList";								
					break;
				}
				
				case "update" : {
					hCartList = cartService.updateCartList(odto);
					break;
				}
				
				case "delete" : {
					hCartList = cartService.deleteCartList(odto);
					break;
				}
			}

		}
		model.addAttribute("conf",conf);
		model.addAttribute("msg",msg);
		model.addAttribute("url",url);
		session.setAttribute("hCartList", hCartList);
		session.setAttribute("ssKey", sdto);
		return page; 
	}
}
