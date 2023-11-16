package com.shop.dessertFairy.order.web;

import java.util.Hashtable;
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
					              PageDTO pdto,
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
			   resultSet = orderService.getOrderList(odto, pdto);
			   model.addAttribute("pBlock", RowInterPage.PAGE_OF_BLOCK);
			   model.addAttribute("mdto", mdto);
			   model.addAttribute("pdto", resultSet.get("pdto"));
			   model.addAttribute("oCnt", resultSet.get("oCnt"));
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
         
    	  System.out.println("o_amount========"+hCartList);
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
   
   @RequestMapping("/memOrderDetail")
   public String MemOrderDetail(HttpServletRequest request,
		   						HttpServletResponse response,
		   						OrderDTO odto,
		   						Model model) {
	   String page = null;
	   HttpSession session = request.getSession();
	   MemberDTO ssKey = (MemberDTO)session.getAttribute("ssKey");
	   
	   if(ssKey != null) {
		   odto = orderService.memOrderDetail(odto);
		   model.addAttribute("odto", odto);
		   model.addAttribute("contentsJsp", "custom/mypage/OrderDetail");
		   page = "Main";
	   }else {
		   String msg = "로그인이 필요합니다.";
		   model.addAttribute("msg", msg);
		   model.addAttribute("url", "/login");
		   page="MsgPage";
	   }
	   
	   session.setAttribute("ssKey", ssKey);
	   
	   return page;
   }
}