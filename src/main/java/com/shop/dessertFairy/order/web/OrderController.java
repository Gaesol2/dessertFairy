package com.shop.dessertFairy.order.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.cart.service.CartService;
import com.shop.dessertFairy.common.RowInterPage;
import com.shop.dessertFairy.common.dto.PageDTO;
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
   
   
   @RequestMapping("/orderList")
	  public String  contactList( HttpServletRequest request,
					              HttpServletResponse response,
					              Model model,
					              MemberDTO mdto,
					              OrderDTO odto) {
		 
	   String page = null;
	   String msg = null;
	   String url = null;
	   HttpSession session = request.getSession();
	   MemberDTO ssKey = (MemberDTO)session.getAttribute("ssKey");
	   Map<String, Object> resultSet = null;
	   if(ssKey != null) {
		   
		   if(ssKey.getM_role().equals("mem")) {
			   odto.setM_id(ssKey.getM_id());
			   resultSet = orderService.getOrderList(odto);
			   model.addAttribute("m_name", ssKey.getM_name());
			   model.addAttribute("orderList", resultSet.get("orderList"));
			   session.setAttribute("ssKey", ssKey);
			   model.addAttribute("contentsJsp", "custom/mypage/OrderList");	
			   page = "Main";
		   }
	   }else {
	         msg = "로그인 먼저 필요합니다.";
	         url = "/login";
	         model.addAttribute("msg", msg);
	         model.addAttribute("url", url);
	         page = "MsgPage";
	      }
		
		  return page;
	  }
   
   //바로 결제
   @RequestMapping("directOrderProc")
   public String directOrderProc(HttpServletRequest request, HttpServletResponse response,
         Model model, OrderDTO odto) {
      //세션 받아와서 저장
      HttpSession session = request.getSession();
      MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");
      
      String msg = null;
      String url = null;
      String page = null;
      String contentsJsp = null;
      
      if(sdto==null) {
         msg = "로그인이 필요합니다.";
         url = "login";
         page = "MsgPage";
         
      } else {
    	  if(odto==null) {
    		  msg = "결제가 취소되었습니다.";
    		  url = "cartList";
    		  page = "MsgPage";
    		  
    	  } else {
    		  Hashtable<Integer, OrderDTO> hDirectPay = new Hashtable<>();
    		  //장바구니에 상품 담기
    		  hDirectPay = cartService.addDirectPay(odto);
    		  cartService.setCartList(hCartList);
    		  
	         //dessert 재고 수 줄이고, order 테이블에 등록
	         orderWrapper.orderProc(odto, hCartList);
	         
	         //최신 ono 받아오기
	         int ono = orderService.getRecentOno();
	         
	         odto.setO_no(ono);
	         odto = orderWrapper.getOrderDetail(odto);
	         
	         model.addAttribute("odto",odto);
	
	         page = "Main";
	         contentsJsp = "custom/pay/PayForm";
    	  }
      }
      
      model.addAttribute("msg", msg);
      model.addAttribute("url", url);
      model.addAttribute("contentsJsp",contentsJsp);
      session.setAttribute("ssKey", sdto);
      
      return page;
   }
   
   //장바구니 결제
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
    	  if(odto==null) {
    		  msg = "결제가 취소되었습니다.";
    		  url = "cartList";
    		  page = "MsgPage";
    		  
    		  
    	  } else {
	         //dessert 재고 수 줄이고, order 테이블에 등록
	         orderWrapper.orderProc(odto, hCartList);
	         
	         //최신 ono 받아오기
	         int ono = orderService.getRecentOno();
	         
	         odto.setO_no(ono);
	         odto = orderWrapper.getOrderDetail(odto);
	         
	         model.addAttribute("odto",odto);
	
	         page = "Main";
	         contentsJsp = "custom/pay/PayForm";
    	  }
      }
      
      model.addAttribute("msg", msg);
      model.addAttribute("url", url);
      model.addAttribute("contentsJsp",contentsJsp);
      session.setAttribute("ssKey", sdto);
      session.setAttribute("hCartList", hCartList);
      
      return page;
   }
   
   @RequestMapping("/productOrder")
   public String ProductOrder(HttpServletRequest request, HttpServletResponse response,
		   Model model, OrderDTO odto) {
	   
		   
	   model.addAttribute("contentsJsp", "custom/order/ProductOrder");
		
		return "Main";
	}
   
   @RequestMapping("/memOrderDetail")  // 회원 마이페이지 order 목록
   public String MemOrderDetail(HttpServletRequest request,
		   						HttpServletResponse response,
		   						OrderDTO odto,
		   						MemberDTO mdto,
		   						Model model) {
	   String page = null;
	   HttpSession session = request.getSession();
	   MemberDTO ssKey = (MemberDTO)session.getAttribute("ssKey");
	   if(ssKey != null) {
		   List<OrderDTO> DetailList = new ArrayList<>();
		   DetailList = orderService.OrderDetail(odto);
			
		   model.addAttribute("DetailList", DetailList);
		   model.addAttribute("contentsJsp", "custom/mypage/OrderDetail");
		   
		   page = "Main";
	   }else {
		   String msg = "로그인이 필요합니다.";
		   model.addAttribute("msg", msg);
		   model.addAttribute("url", "/login");
		   page="MsgPage";
	   }
	   
	   model.addAttribute("m_name", ssKey.getM_name());
	   session.setAttribute("ssKey", ssKey);
	   
	   return page;
   }
   
   @RequestMapping("orderCancel")
   public String OrderCancel (HttpServletRequest request, HttpServletResponse response,
		   Model model, OrderDTO odto) {
	   
	    HttpSession session = request.getSession();
		MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");
		
		String msg = null;
		String page = null;
		String url = null;
		String contentsJsp = null;
		
		if(sdto==null) {
			msg = "로그인이 필요합니다.";
			page = "MsgPage";
			url = "login";
		} else {
			page = "Main";
			contentsJsp = "redirect:orderList";
			orderWrapper.orderCancel(odto);
		}
	   
	   return page;
   }
}