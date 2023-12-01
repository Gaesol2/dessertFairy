package com.shop.dessertFairy.admin.web;

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
import com.shop.dessertFairy.review.service.ReviewService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@Controller
public class AdminShopController {
	
   @Autowired
   ReviewService reviewService;
   
   @Autowired
   ContactService contactService;
	
   @RequestMapping("/shopMgt")
   public String ShopMgt(HttpServletRequest request,
                       HttpServletResponse response,
                       Model model,
                       ReviewDTO rdto,
                       PageDTO pdto) {
	   
	   String page = null;
       MemberDTO ssKey = null;
       String contentsJsp = "admin/shop/ShopMgt";
      
       HttpSession session = request.getSession();
      
       if(session.getAttribute("ssKey") != null) {
         ssKey = (MemberDTO) session.getAttribute("ssKey");
         if(ssKey.getM_role().equals("admin")) {
        	 contentsJsp = "admin/shop/ShopMgt";
			   page = "Main";
         }else {
        	 page = "redirect:/";
         }
       }
    //리스트 목록과 페이지 수 계산한것을 불러온 것
		Map<String, Object> reSet = reviewService.getReplyList(rdto, pdto);
		
		
		List<ReviewDTO>list=(List<ReviewDTO>) reSet.get("replyList");
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
		model.addAttribute("replyList", list);
		model.addAttribute("pBlock", RowInterPage.PAGE_OF_BLOCK);
		model.addAttribute("contentsJsp",contentsJsp);
		model.addAttribute("pdto",pdto);
		
		
		return page;
	}
   
   @RequestMapping("/replyContent")
   public String ReplyContent(HttpServletRequest request,
		   HttpServletResponse response,
		   Model model,
		   ReviewDTO rdto,
		   PageDTO pageDto) {
	   
	 //세션 받아오기
	   HttpSession session = request.getSession();
	   
	   //변수 선언해주기
	   String contentsJsp = "/admin/shop/ReplyContent";
	   String page = null;
	   
	   //ssKey 세션에 있는 정보를 MemberDTO 타입의 mdto에 저장
	   MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
	   
	   //파라메터에서 r_no를 가져온것
	   int postNo = Integer.parseInt(request.getParameter("r_no"));
	   
	   //content 내용 가져오기
	   rdto.setStart(postNo);
	   rdto.setEnd(postNo+1);
	   ReviewDTO review = reviewService.getReplyContent(rdto);
	   model.addAttribute("review", review);
	   
	   
	   //점수를 별로 바꾸는 것(jsp에 value값)
	   String ratings = "";
	   for(int i=0; i <review.getR_star(); i++) {
		   ratings += "★";
	   }
	   
	   //모델에 저장
	   model.addAttribute("ratings", ratings);
	   model.addAttribute("ratingLength", ratings.length());
	   
	   //페이지 불러오기
	   page = "admin/shop/ReplyContent";
	   
	   //세션에 저장
	   session.setAttribute("ssKey", mdto);
	   model.addAttribute("contentsJsp", page);
	   
	   return "Main";
   }
   
   @RequestMapping("/replyWriteProc") //리뷰글쓰기 폼
   public String ReplyWriteProc (HttpServletRequest request, HttpServletResponse response,
         Model model, ReviewDTO rdto) {

	   //변수 선언
	   String msg = null;
	   String url = "/shopMgt";
	   
	   //세션 받아오기
	   HttpSession session = request.getSession();
	   
	   MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");
	   
	   //결과 처리
	   int result = reviewService.getReplyWrite(rdto);
	   //결과에 따른 메세지 출력
	   if(result>0) {
		   msg = "후기답글이 등록되었습니다.";
	   } else {
		   msg = "후기답글 등록에 실패했습니다.";
	   }
      
	   //경로 및 메세지 저장
	   model.addAttribute("url",url);
	   model.addAttribute("msg",msg);
	   model.addAttribute("reply",rdto);
	   //세션 저장
	   session.setAttribute("ssKey", sdto);
	   
	   return "MsgPage";
   }
   
   
   @RequestMapping("/replyupProc")
	public String ReplyUpProc(HttpServletRequest request, HttpServletResponse response,
			ReviewDTO rdto,
			Model model,
			PageDTO pageDto) {
	   
		HttpSession session = request.getSession();
		String contentsJsp = null;
		String page = null;
		MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
		
		 //결과 처리
		if(session.getAttribute("ssKey")!=null) {
			String msg = null;
			String url = null;
				
					page = "MsgPage";
					System.out.println(rdto);
					int r = reviewService.replyupProc(rdto);
					if(r>0) msg = "수정이 완료 되었습니다.";
					else msg = "수정을 실패했습니다.";
					url = "/shopMgt";
					
					
				   ReviewDTO review = reviewService.getReplyContent(rdto);
				   model.addAttribute("review", review);
				   //점수를 별로 바꾸는 것(jsp에 value값)
				   String ratings = "";
				   for(int i=0; i <review.getR_star(); i++) {
					   ratings += "★";
				   }
					   
				   //모델에 저장
				   model.addAttribute("ratings", ratings);
				   model.addAttribute("ratingLength", ratings.length());
				   
				   
				if(url!=null) model.addAttribute("url", url);
				if(msg!=null) model.addAttribute("msg", msg);
				
				
				
			}else {
				page = "Main";
				contentsJsp = "admin/shop/ShopMgt";
			}
		
		session.setAttribute("ssKey", mdto);
		model.addAttribute("contentsJsp", contentsJsp);
		
		return page;
	}
   
   @RequestMapping("/replydelProc")
   public String ReplyDelProc(HttpServletRequest request, HttpServletResponse response,
		   ReviewDTO rdto,
		   Model model,
		   PageDTO pageDto) {
	   
	   
	   HttpSession session = request.getSession();
	   String contentsJsp = null;
	   String page = null;
	   MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
	   if(session.getAttribute("ssKey")!=null) {
		   String msg = null;
		   String url = null;
		  
			   page = "MsgPage";
			   int r = reviewService.replydelProc(rdto);
			   if(r>0) msg = "답글삭제가 완료 되었습니다.";
			   else msg = "답글삭제를 실패했습니다.";
			   url = "/shopMgt";
		
		   if(url!=null) model.addAttribute("url", url);
		   if(msg!=null) model.addAttribute("msg", msg);
		   
	   }else {
		   page = "Main";
		   contentsJsp = "./admin/shop/ShopMgt";
	   }
	   
	   session.setAttribute("ssKey", mdto);
	   model.addAttribute("contentsJsp", contentsJsp);
	   
	   return page;
   }
   
   
   
   
   
   
   
   //문의하기
   @RequestMapping("/adminContact")
	  public String AdminContact(HttpServletRequest request,
			              HttpServletResponse response,
			              Model model,
			              ContactDTO tdto,
			              PageDTO pdto) {
		
		//변수 선언
	    String page = null;
	    HttpSession session = request.getSession();
	    MemberDTO ssKey = (MemberDTO) session.getAttribute("ssKey");
	    
		if(ssKey!=null && ssKey.getM_role().equals("admin")) {
			Map<String, Object> reSet = contactService.getContactList(tdto, pdto);
			model.addAttribute("cnt", reSet.get("cnt"));
			model.addAttribute("contactList", reSet.get("contactList"));
			model.addAttribute("pBlock", RowInterPage.PAGE_OF_BLOCK);
			model.addAttribute("contentsJsp", "/admin/shop/ContactList");
			model.addAttribute("pdto",pdto);
			page = "Main";
		}else page = "redirect:/";
		
		session.setAttribute("ssKey", ssKey);
		
		return page;
	}
   
   @RequestMapping("/adminContactContent")
   public String AdminContactContent(HttpServletRequest request,
		   HttpServletResponse response,
		   Model model,
		   ContactDTO tdto,
		   PageDTO pageDto) {
	   
	   String page = null;

	   //세션 받아오기
	   HttpSession session = request.getSession();
	   MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
	   if(mdto != null && mdto.getM_role().equals("admin")) {
		   ContactDTO contact = contactService.getAdminContent(tdto);
		   model.addAttribute("contact", contact);
		   model.addAttribute("tdto", tdto);
		   model.addAttribute("contentsJsp", "admin/shop/ContactContent");
		   page = "Main";
		   
	   }
	   //세션에 저장
	   session.setAttribute("ssKey", mdto);
	   
	   
	   return page;
   }
   
   @RequestMapping("/adminContactReply") //리뷰 글쓰기 경로
   public String ContactWrite ( HttpServletRequest request,
		   						HttpServletResponse response,
		   						Model model,
		   						ContactDTO tdto) {
	   String url = null;
	   String msg = null;
	   String page = null;
	   System.out.println("넘버는 : "+tdto);
	   //HttpSession 세션 객체 생성 및 세션 정보 받아오기
	   HttpSession session = request.getSession();

	   //ssKey 세션에 있는 정보를 MemberDTO 타입의 sdto에 저장
	   MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");

	   //세션이 없으면 로그인 먼저 하라고 로그인 페이지로 보내기
	   if(sdto!=null && sdto.getM_role().equals("admin")) {
		   model.addAttribute("contentsJsp","/admin/shop/ContactReplyWrite");
		   page = "Main";
		   model.addAttribute("t_no",tdto.getT_no());
		   model.addAttribute("tdto",tdto);
	   } else {
		   msg = "권한이 없습니다.";
		   url = "login";
		   page = "MsgPage";
	   }
	   
	   //데이터 저장
	   model.addAttribute("msg",msg);
	   model.addAttribute("url",url);
      
	   //세션 저장해주기
	   session.setAttribute("ssKey", sdto);
	   
	   return page;
   }
   
   @RequestMapping("/contactReplyProc")
   public String ContactWriteProc ( HttpServletRequest request,
		   							HttpServletResponse response,
		   							Model model,
		   							ContactDTO tdto) {

	   //변수 선언
	   String msg = null;
	   String url = "/adminContact";
	   //세션 받아오기
	   HttpSession session = request.getSession();
	   MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");
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
   
}