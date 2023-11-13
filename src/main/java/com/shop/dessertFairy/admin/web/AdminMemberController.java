package com.shop.dessertFairy.admin.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.member.service.MemberService;
import com.shop.dessertFairy.review.dto.ReviewDTO;
import com.shop.dessertFairy.review.service.ReviewService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminMemberController {
	
	@Autowired MemberService memberService;
	@Autowired ReviewService reviewService;
	
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
	
	@RequestMapping("mReviewMgt")
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

	@RequestMapping("mOrder")
	public String MOrder(	HttpServletRequest request,
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
	
	
}
