package com.shop.dessertFairy.contact.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.common.RowInterPage;
import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.contact.dto.ContactDTO;
import com.shop.dessertFairy.contact.service.ContactService;
import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.review.dto.ReviewDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ContactController {
	
	
	@Autowired
	ContactService contactService;
	
	@RequestMapping("/contactList")
	  public String  contactList(HttpServletRequest request,
			              HttpServletResponse response,
			              Model model,
			              ContactDTO tdto,
			              PageDTO pageDto) {
		
		//변수 선언
	    String page = null;
	    MemberDTO ssKey = null;
	    String contentsJsp = "/custom/mypage/ContactList";
	    
	    //HttpSession 세션 객체 생성 및 세션 정보 받아오기
		HttpSession session = request.getSession();
		
		ssKey = (MemberDTO) session.getAttribute("ssKey");
		contentsJsp = "/custom/mypage/ContactList";
		page = "Main";
		
		
		//리스트 목록과 페이지 수 계산한것을 불러온 것
		Map<String, Object> reSet = contactService.getContactList(tdto, pageDto);
		
		//세션 저장
		
		session.setAttribute("ssKey", ssKey);
		
		//데이터 저장
		model.addAttribute("cnt", reSet.get("cnt"));
		model.addAttribute("pBlock", RowInterPage.PAGE_OF_BLOCK);
		model.addAttribute("contentsJsp",contentsJsp);
		model.addAttribute("pageDto",pageDto);
		
		
		return page;
	}
}
