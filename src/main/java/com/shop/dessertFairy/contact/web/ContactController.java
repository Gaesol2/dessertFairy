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
	
	@RequestMapping("/contactWrite") //리뷰 글쓰기 경로
	   public String ContactWrite (HttpServletRequest request, HttpServletResponse response,
	         Model model, ContactDTO tdto) {

		   //HttpSession 세션 객체 생성 및 세션 정보 받아오기
		   HttpSession session = request.getSession();

		   //ssKey 세션에 있는 정보를 MemberDTO 타입의 sdto에 저장
		   MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");

		   //변수 선언
		   String url = null;
		   String msg = null;
		   String page = null;
		   String contentsJsp = null;
		   
		   //세션이 없으면 로그인 먼저 하라고 로그인 페이지로 보내기
		   if(sdto!=null) {
			   contentsJsp = "/custom/review/ReviewWrite";
			   page = "Main";
			   model.addAttribute("m_id",sdto.getM_id());
		   } else {
			   msg = "로그인이 필요합니다.";
			   page = "MsgPage";
			   url = "login";
		   }
		   
		   //데이터 저장
		   model.addAttribute("contentsJsp",contentsJsp);
		   model.addAttribute("msg",msg);
		   model.addAttribute("url",url);
	      
		   //세션 저장해주기
		   session.setAttribute("ssKey", sdto);
		   
		   return page;
	   }
}
