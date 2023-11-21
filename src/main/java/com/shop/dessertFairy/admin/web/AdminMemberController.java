package com.shop.dessertFairy.admin.web;

import java.util.List;
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
							PageDTO pdto) {
		HttpSession session = request.getSession();			//현재 사용자의 세션을 받아옴
		MemberDTO ssKey = null;
		String page = null;
		
		if(session.getAttribute("ssKey") != null) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			if(ssKey.getM_role().equals("admin")) {
				Map<String, Object> resultSet = memberService.getMembers(mdto, pdto);
				model.addAttribute("memberTot", resultSet.get("memberTot"));
				model.addAttribute("members", resultSet.get("members"));
				model.addAttribute("pdto", resultSet.get("pdto"));
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
								ReviewDTO rdto,
								PageDTO pageDto) {
		
	//변수 선언
	   String page = null;
	   String msg = null;
	   String url = null;
	   MemberDTO ssKey = null;
	   String contentsJsp = "/admin/member/MemberReviewList";
	   
	   //HttpSession 세션 객체 생성 및 세션 정보 받아오기
	   HttpSession session = request.getSession();
	   
	   String m_id = request.getParameter("m_id");
	   rdto.setM_id(m_id);
	   
	   //세션이 있으면 ReviewMyList 페이지로 보내고 없으면 로그인 창으로 보내기
	   if(session.getAttribute("ssKey")!=null) {
		   ssKey = (MemberDTO) session.getAttribute("ssKey");
		   page = "Main";
		   url = "mReviewMgt";
	   }
	   else {
		   msg = "로그인이 필요합니다.";
		   page = "MsgPage";
		   url = "login";
	   }
	   
	   
	   //리스트 목록과 페이지 수 계산한것을 불러온 것
	   Map<String, Object> reSet = reviewService.getMemList(rdto, pageDto);
	   List<ReviewDTO>list=(List<ReviewDTO>) reSet.get("memList");
		for(ReviewDTO rvdto : list) {
			 String ratings = "";
			  for(int i=0; i <rvdto.getR_star(); i++) {
				   ratings += "★";
			   }
			   for(int i=0; i <5-rvdto.getR_star(); i++) {
				    ratings += "☆";
			   }
			   rvdto.setRatings(ratings);
		}
	   //세션 저장
	   session.setAttribute("ssKey", ssKey);
	   //데이터 저장
	   model.addAttribute("cnt", reSet.get("cnt"));
	   model.addAttribute("memList", list);
	   model.addAttribute("pBlock", RowInterPage.PAGE_OF_BLOCK);
	   model.addAttribute("contentsJsp",contentsJsp);
	   model.addAttribute("pageDto",pageDto);
	   model.addAttribute("page",page);
	   model.addAttribute("url",url);
	   model.addAttribute("msg",msg);
	   
	   
	   return page;
   }
	
	@RequestMapping("mOrderList")									// admin 고객관리-주문내역
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
