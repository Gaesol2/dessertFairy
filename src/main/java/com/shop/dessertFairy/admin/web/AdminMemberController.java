package com.shop.dessertFairy.admin.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.common.RowInterPage;
import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.member.service.MemberService;
import com.shop.dessertFairy.order.dto.OrderDTO;
import com.shop.dessertFairy.order.service.OrderService;
import com.shop.dessertFairy.review.dto.ReviewDTO;
import com.shop.dessertFairy.review.service.ReviewService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminMemberController {
	
	@Autowired MemberService memberService;
	@Autowired ReviewService reviewService;
	@Autowired OrderService orderService;
	
	@RequestMapping("memberMgt")
	public String MemberMgt(HttpServletRequest request,
							HttpServletResponse response,
							Model model,
							MemberDTO mdto,
							PageDTO pageDto) {
		HttpSession session = request.getSession();			//현재 사용자의 세션을 받아옴
		MemberDTO ssKey = null;
		String page = null;
		
		if(session.getAttribute("ssKey") != null) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			if(ssKey.getM_role().equals("admin")) {
				Map<String, Object> resultSet = memberService.getMembers(mdto, pageDto);
				model.addAttribute("memberTot", resultSet.get("memberTot"));
				model.addAttribute("members", resultSet.get("members"));
				model.addAttribute("pageDto", resultSet.get("pageDto"));
				model.addAttribute("contentsJsp", "admin/member/MemberList");
				session.setAttribute("ssKey", ssKey);
				page = "Main";
			}
			else page = "redirect:/";
		} else page = "redirect:/";
		
		
		return page;
	}

	@RequestMapping("memberDetail")
	public String MemberDetail(	HttpServletRequest request,
								HttpServletResponse response,
								Model model,
								MemberDTO mdto) {
		String page = null;
		MemberDTO ssKey = null;
		HttpSession session = request.getSession();			//현재 사용자의 세션을 받아옴
		
		if(session.getAttribute("ssKey") != null) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			if(ssKey.getM_role().equals("admin")) {
				MemberDTO member = memberService.getMemberDetail(mdto.getM_id());
				model.addAttribute("member", member);
				model.addAttribute("contentsJsp", "admin/member/MemberDetail");
				session.setAttribute("ssKey", ssKey);
				page = "Main";
			}
			else page = "redirect:/";
		} else page = "redirect:/";
		
		
		return page;
	}
	
	@RequestMapping("mReviewMgt")									// admin 고객관리-회원리뷰
	public String mReviewMgt(	HttpServletRequest request,
								HttpServletResponse response,
								Model model,
								ReviewDTO rdto) {
		String page = null;
		MemberDTO ssKey = null;
		HttpSession session = request.getSession();			//현재 사용자의 세션을 받아옴
		
		if(session.getAttribute("ssKey") != null) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			if(ssKey.getM_role().equals("admin")) {
				Map<String, Object> reviews = new HashMap<String, Object>();
				reviews = reviewService.getMemberReview(rdto.getM_id());
				model.addAttribute("reviewTot", reviews.get("reviewTot"));
				model.addAttribute("reviews", reviews.get("reviews"));
				model.addAttribute("contentsJsp", "admin/member/MemberReview");
				session.setAttribute("ssKey", ssKey);
				page = "Main";
			}
			else page = "redirect:/";
		} else page = "redirect:/";
		
		return page;
	}
	@RequestMapping("mOrderList")									// admin 고객관리-회원리뷰
	public String MemOrderList(	HttpServletRequest request,
								HttpServletResponse response,
								Model model,
								OrderDTO odto,
								PageDTO pdto) {
		String page = null;
		String url = null;
		String msg = null;
		Map<String, Object> resultSet = null;
		HttpSession session = request.getSession();			//현재 사용자의 세션을 받아옴
		MemberDTO ssKey = (MemberDTO) session.getAttribute("ssKey");
		odto.setM_id(request.getParameter("m_id"));
			if(ssKey != null && ssKey.getM_role().equals("admin")) {
				resultSet = orderService.getOrderList(odto, pdto);
				model.addAttribute("m_id", odto.getM_id());
				model.addAttribute("pBlock", RowInterPage.PAGE_OF_BLOCK);
			    model.addAttribute("pdto", resultSet.get("pdto"));
			    model.addAttribute("oCnt", resultSet.get("oCnt"));
			    model.addAttribute("orderList", resultSet.get("orderList"));
			    session.setAttribute("ssKey", ssKey);
			    model.addAttribute("contentsJsp", "admin/member/MemberOrderList");	
			    page = "Main";
			}
			else {
				 msg = "로그인 먼저 필요합니다.";
		         url = "/login";
		         model.addAttribute("msg", msg);
		         model.addAttribute("url", url);
		         page = "MsgPage";
			}
		
		return page;
	}
	
	 @RequestMapping("/mOrderDetail")
	   public String MemOrderDetail(HttpServletRequest request,
			   						HttpServletResponse response,
			   						OrderDTO odto,
			   						Model model) {
		 	String page = null;
			String msg = null;
			HttpSession session = request.getSession();
			MemberDTO ssKey = (MemberDTO) session.getAttribute("ssKey");
			
			if(ssKey != null && ssKey.getM_role().equals("admin")) {
				odto = orderService.OrderDetail(odto);
				model.addAttribute("odto", odto);
				model.addAttribute("contentsJsp", "admin/member/MemberOrderDetail");
				page = "Main";
			}else {
				msg = "관리자 로그인이 필요합니다.";
				model.addAttribute("msg", msg);
				model.addAttribute("url", "/login");
				page = "MsgPage";
			}
			
			session.setAttribute("ssKey", ssKey);
			
		   return page;
	   }
	 
	 @RequestMapping("mUpdateOrder")										// 주문 수정
		public String MUpdateOrder(  HttpServletRequest request,
									HttpServletResponse response,
									OrderDTO odto,
									Model model) {
		 	String url = null;
			String msg = null;
			int result = 0;
			HttpSession session = request.getSession();
			MemberDTO ssKey = (MemberDTO) session.getAttribute("ssKey");
			
			if(ssKey != null && ssKey.getM_role().equals("admin")) {
				result = orderService.MUpdateOrder(odto);
				if(result > 0) msg = "상품등록 성공";
				else msg = "상품등록 실패";
				model.addAttribute("odto", odto);
				url = "memberMgt";
			}else {
				msg = "관리자 로그인이 필요합니다.";
				url = "login";
			}
			
			model.addAttribute("msg", msg);
			model.addAttribute("url", url);
			session.setAttribute("ssKey", ssKey);
			
			return "MsgPage";
		}

}
