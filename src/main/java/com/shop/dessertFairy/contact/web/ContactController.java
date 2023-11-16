package com.shop.dessertFairy.contact.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.common.RowInterPage;
import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.contact.dto.ContactDTO;
import com.shop.dessertFairy.contact.service.ContactService;
import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.member.service.MemberService;
import com.shop.dessertFairy.review.dto.ReviewDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ContactController {
	
	
	@Autowired
	ContactService contactService;
	
	@Autowired
	MemberService memberService;
	
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
		model.addAttribute("contactList", reSet.get("contactList"));
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
			   contentsJsp = "/custom/mypage/ContactWrite";
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
	
	@RequestMapping("/contactWriteProc") //리뷰글쓰기 폼
	   public String ContactWriteProc (HttpServletRequest request, HttpServletResponse response,
	         Model model, ContactDTO tdto) {

		   //변수 선언
		   String msg = null;
		   String url = "/contactList";
		   
		   //세션 받아오기
		   HttpSession session = request.getSession();
		   MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");

		   //rdto.setM_id(세션) 세션에서 member_id를 빼서 rdto에 넣어주기
		   tdto.setM_id(sdto.getM_id());

		   //결과 처리
		   int result = contactService.contactWrite(tdto);

		   //결과에 따른 메세지 출력
		   if(result>0) {
			   msg = "문의글이 등록되었습니다.";
		   } else {
			   msg = "문의글 등록에 실패했습니다.";
		   }
	      
		   //경로 및 메세지 저장
		   model.addAttribute("url",url);
		   model.addAttribute("msg",msg);
	      
		   //세션 저장
		   session.setAttribute("ssKey", sdto);
		   
		   return "MsgPage";
	   }
	
	
	
	@RequestMapping("/contactContent") //리뷰 내용보기
	   public String ContactContent (HttpServletRequest request, HttpServletResponse response,
	         Model model, ContactDTO tdto, PageDTO pageDto) {
		   
		   //세션 받아오기
		   HttpSession session = request.getSession();
		   
		   //변수 선언해주기
		   String contentsJsp = "/custom/mypage/ContactContent";
			String page = null;
			
			//ssKey 세션에 있는 정보를 MemberDTO 타입의 mdto에 저장
			MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
			
			
			ContactDTO contact = contactService.getContactcontent(tdto);
			model.addAttribute("contact", contact);
			
			//페이지 불러오기
			page = "custom/mypage/ContactContent";
			
			//세션에 저장
			session.setAttribute("ssKey", mdto);
			model.addAttribute("contentsJsp", page);
			
			
			return "Main";
		}
	
	
	
	
	
	
	
	
	
	//내 글보기
	@RequestMapping("/myContact") //내 글보기 목록
	   public String MyContact(HttpServletRequest request, HttpServletResponse response,
			   Model model, ContactDTO tdto,
			   PageDTO pageDto) { 
		   
		   //변수 선언
		   String page = null;
		   String msg = null;
		   String url = null;
		   MemberDTO ssKey = null;
		   String contentsJsp = "/custom/mypage/MyContactList";
		   
		   //HttpSession 세션 객체 생성 및 세션 정보 받아오기
		   HttpSession session = request.getSession();
		   
		   //세션이 있으면 ReviewMyList 페이지로 보내고 없으면 로그인 창으로 보내기
		   if(session.getAttribute("ssKey")!=null) {
			   ssKey = (MemberDTO) session.getAttribute("ssKey");
			   MemberDTO mdto = memberService.getMember(ssKey);
			   tdto.setM_id(ssKey.getM_id());
			   page = "Main";
			   url = "myContact";
		   }
		   else {
			   msg = "로그인이 필요합니다.";
			   page = "MsgPage";
			   url = "login";
		   }
		   
		   
		   //리스트 목록과 페이지 수 계산한것을 불러온 것
		   Map<String, Object> reSet = contactService.getMyContactList(tdto, pageDto);
		   
		   
		   List<ContactDTO>list=(List<ContactDTO>) reSet.get("myContact");
			
		   //세션 저장
		   session.setAttribute("tdto", ssKey);
		   //데이터 저장
		   model.addAttribute("cnt", reSet.get("cnt"));
		   model.addAttribute("myContact", list);
		   model.addAttribute("pBlock", RowInterPage.PAGE_OF_BLOCK);
		   model.addAttribute("contentsJsp",contentsJsp);
		   model.addAttribute("pageDto",pageDto);
		   model.addAttribute("page",page);
		   model.addAttribute("url",url);
		   model.addAttribute("msg",msg);
		   
		   
		   return page;
	   }
	
	
	
	
	
	
	
	
	
	
}
