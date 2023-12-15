package com.shop.dessertFairy.admin.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.dessert.dto.DessertDTO;
import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.order.dto.OrderDTO;
import com.shop.dessertFairy.order.service.OrderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminOrderController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping("orderMgt")											// 주문 목록
	public String OrderMgt( HttpServletRequest request,
							HttpServletResponse response,
							Model model,
							MemberDTO mdto,
							OrderDTO odto) {
		String page = null;
		String url = null;
		String msg = null;
		HttpSession session = request.getSession();
		Map<String, Object> resultSet = null;
		MemberDTO ssKey = (MemberDTO) session.getAttribute("ssKey");
		
		if(session.getAttribute("ssKey") != null) {
			
			if(ssKey.getM_role().equals("admin")) {
				 resultSet = orderService.getAdminOrderList(odto);
				   model.addAttribute("adminOrderList", resultSet.get("adminOrderList"));
				   model.addAttribute("totalPrice",resultSet.get("totalPrice"));
				   model.addAttribute("contentsJsp", "admin/order/OrderMgt");
				   session.setAttribute("ssKey", ssKey);
				   page = "Main";
			}
			else page = "redirect:/";
		}else {
	         msg = "로그인 먼저 필요합니다.";
	         url = "/login";
	         model.addAttribute("msg", msg);
	         model.addAttribute("url", url);
	         page = "MsgPage";
	      }
		
		return page;
	}
	
	@RequestMapping("orderMgtProc")										// 주문 목록페이지에서 상태 수정 프로세스
	public void OrderMgtProc( HttpServletRequest request,
								HttpServletResponse response,
								Model model,
								PageDTO pdto,
								@RequestParam(value="tdArr[]") ArrayList<String> tdArr) {
		
		HttpSession session = request.getSession();
		MemberDTO ssKey = (MemberDTO) session.getAttribute("ssKey");
		if(ssKey != null && ssKey.getM_role().equals("admin")) {
			try {
				orderService.orderStateUpdate(tdArr);
			}catch (Exception e) {
				e.getMessage();
			}
		}
		
		session.setAttribute("ssKey", ssKey);
		
	}
	
	@RequestMapping("orderDetail")												// 주문 상세
	public String OrderDetail(  HttpServletRequest request,
								HttpServletResponse response,
								OrderDTO odto,
								Model model) {
		String page = null;
		String msg = null;
		HttpSession session = request.getSession();
		MemberDTO ssKey = (MemberDTO) session.getAttribute("ssKey");
		
		if(ssKey != null && ssKey.getM_role().equals("admin")) {
			List<OrderDTO> DetailList = new ArrayList<>();
			 DetailList = orderService.OrderDetail(odto);
			model.addAttribute("DetailList", DetailList);
			model.addAttribute("contentsJsp", "admin/order/OrderDetail");
			session.setAttribute("ssKey", ssKey);
			page = "Main";
		}else {
			msg = "관리자 로그인이 필요합니다.";
			model.addAttribute("msg", msg);
			model.addAttribute("url", "/login");
			page = "MsgPage";
		}
		
		return page;
	}

	@RequestMapping("updateOrder")										// 주문 수정
	public String UpdateOrder(  HttpServletRequest request,
								HttpServletResponse response,
								OrderDTO odto,
								Model model) {
		String page = null;
		String msg = null;
		HttpSession session = request.getSession();
		MemberDTO ssKey = (MemberDTO) session.getAttribute("ssKey");
		
		if(ssKey != null && ssKey.getM_role().equals("admin")) {
			orderService.updateOrder(odto);
			page = "redirect:/orderMgt";
		}else {
			msg = "관리자 로그인이 필요합니다.";
			model.addAttribute("msg", msg);
			model.addAttribute("url", "/login");
			page = "MsgPage";
		}
		session.setAttribute("ssKey", ssKey);
		
		return page;
	}
	
	@RequestMapping("cakeOrderMgt")											// 주문 목록
	public String CakeOrderMgt( HttpServletRequest request,
							HttpServletResponse response,
							Model model,
							MemberDTO mdto,
							OrderDTO odto) {
		String page = null;
		String url = null;
		String msg = null;
		HttpSession session = request.getSession();
		Map<String, Object> resultSet = null;
		MemberDTO ssKey = (MemberDTO) session.getAttribute("ssKey");
		
		if(session.getAttribute("ssKey") != null) {
			
			if(ssKey.getM_role().equals("admin")) {
				 resultSet = orderService.getAdminCakeOrderList(odto);
				   model.addAttribute("adminCakeOrderList", resultSet.get("adminCakeOrderList"));
				   model.addAttribute("totalPrice",resultSet.get("totalPrice"));
				   model.addAttribute("contentsJsp", "admin/order/OrderCakeMgt");
				   session.setAttribute("ssKey", ssKey);
				   page = "Main";
			}
			else page = "redirect:/";
		}else {
	         msg = "로그인 먼저 필요합니다.";
	         url = "/login";
	         model.addAttribute("msg", msg);
	         model.addAttribute("url", url);
	         page = "MsgPage";
	      }
		
		return page;
	}
	
	@RequestMapping("orderDel")
	   public String OrderCancel(   HttpServletRequest request,
	                        HttpServletResponse response,
	                        OrderDTO odto,
	                        Model model) {
	      String page = null;
	      String msg = null;
	      String url = null;
	      HttpSession session = request.getSession();
	      MemberDTO ssKey = (MemberDTO) session.getAttribute("ssKey");

	      if(ssKey != null && ssKey.getM_role().equals("admin")) {
	    	 List<OrderDTO> dessert = new ArrayList<>();
	    	 List<Integer> dnoList = orderService.dessertMgt(odto);
	    	 
	    	 for(int i=0;i<dnoList.size();i++) {
	    		 OrderDTO list = new OrderDTO();
	    		 list.setD_no(dnoList[i]);
	    		 dessert.add(list);
	    	 }
	    	 
	    	 System.out.println("결과 : "+dessert);
	         orderService.orderCancel(odto);
	         msg = "주문취소 완료.";
	         url = "/orderMgt";
	         
	      }else {
	         msg = "관리자 권한이 필요합니다.";
	         url = "/login";
	      }
	      
	      session.setAttribute("ssKey", ssKey);
	      model.addAttribute("msg", msg);
	        model.addAttribute("url", url);
	      page = "MsgPage";
	      
	      return page;
	   }
}
