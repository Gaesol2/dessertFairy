package com.shop.dessertFairy.admin.web;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.dessertFairy.common.RowInterPage;
import com.shop.dessertFairy.common.dto.PageDTO;
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
	
	@RequestMapping("orderMgt")
	public String OrderMgt( HttpServletRequest request,
							HttpServletResponse response,
							Model model,
							MemberDTO mdto,
				            PageDTO pdto,
							OrderDTO odto) {
		String page = null;
		String url = null;
		String msg = null;
		HttpSession session = request.getSession();
		Map<String, Object> resultSet = null;
		MemberDTO ssKey = (MemberDTO) session.getAttribute("ssKey");
		
		if(session.getAttribute("ssKey") != null) {
			
			if(ssKey.getM_role().equals("admin")) {
				 resultSet = orderService.getAdminOrderList(odto, pdto);
				   model.addAttribute("pBlock", RowInterPage.PAGE_OF_BLOCK);
				   model.addAttribute("pdto", resultSet.get("pdto"));
				   model.addAttribute("oCnt", resultSet.get("oCnt"));
				   model.addAttribute("adminOrderList", resultSet.get("adminOrderList"));
				   session.setAttribute("ssKey", ssKey);
				   model.addAttribute("contentsJsp", "admin/order/OrderMgt");
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
	
	@RequestMapping("orderMgtProc")
	public void OrderMgtProc( HttpServletRequest request,
								HttpServletResponse response,
								Model model,
								PageDTO pdto,
								@RequestParam(value="tdArr[]") ArrayList<String> tdArr) {
		HttpSession session = request.getSession();
		MemberDTO ssKey = (MemberDTO) session.getAttribute("ssKey");
		System.out.println("tdArr : "+tdArr);
		if(ssKey != null && ssKey.getM_role().equals("admin")) {
			try {
				orderService.orderStateUpdate(tdArr);
			}catch (Exception e) {
				e.getMessage();
			}
		}
	}
}
