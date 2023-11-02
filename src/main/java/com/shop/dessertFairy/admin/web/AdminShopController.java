package com.shop.dessertFairy.admin.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.common.RowInterPage;
import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.member.service.MemberService;
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
	   MemberService memberService;
	   
	   //실제로 파일이 저장되는 파일 서버 경로를 가져온 것. properties에 있는 주소 불러와 스트링 변수 resourceLocation에 저장
	   @Value("${resources.location}")
	   String resourcesLocation;

	   @RequestMapping("/shopMgt")
	   public String ShopMgt(HttpServletRequest request, HttpServletResponse response,
	         Model model, ReviewDTO rdto,
	         PageDTO pageDto) { 
		   
	        //변수 선언
		    String page = null;
		    MemberDTO ssKey = null;
		    String contentsJsp = "admin/ShopMgt";
		    
		    //HttpSession 세션 객체 생성 및 세션 정보 받아오기
			HttpSession session = request.getSession();
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			
			//세션이 있으면 ReviewList 페이지로 보내고 없으면 로그인 창으로 보내기
			if(session.getAttribute("ssKey")!=null) {
				if(ssKey.getM_role().equals("admin")) {
				page = "admin/ShopMgt";
			}
			}else {
				page = "redirect:/login";
			}
			
			//jsp로부터 orderby 파라미터를 받고, null이 들어오면 최신순으로 설정
			String orderby = request.getParameter("orderby");
			if(orderby==null) orderby = "new";
			
			//리스트 목록과 페이지 수 계산한것을 불러온 것
			Map<String, Object> reSet = reviewService.getReplyList(rdto, pageDto, orderby);
			
			//세션 저장
			session.setAttribute("ssKey", ssKey);
			
			//데이터 저장
			model.addAttribute("cnt", reSet.get("cnt"));
			model.addAttribute("replyList", reSet.get("replyList"));
			model.addAttribute("pBlock", RowInterPage.PAGE_OF_BLOCK);
			model.addAttribute("contentsJsp",contentsJsp);
			model.addAttribute("pageDto",pageDto);
			model.addAttribute("orderby",orderby);
			model.addAttribute("page",page);
			
			
			return "Main";
		}
	   
	   @RequestMapping("/replyContent")
	   public String replyContent (HttpServletRequest request, HttpServletResponse response,
	         Model model, ReviewDTO rdto, PageDTO pageDto) {
		   
		   //세션 받아오기
		   HttpSession session = request.getSession();
		   
		   //변수 선언해주기
		   String contentsJsp = "/custom/review/ReviewContent";
			String page = null;
			
			//ssKey 세션에 있는 정보를 MemberDTO 타입의 mdto에 저장
			MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
			if(mdto!=null) {
				if(mdto.getM_role().equals("admin")) {
					page = "admin/ReviewContent";
					
			//파라메터에서 r_no를 가져온것
			int postNo = Integer.parseInt(request.getParameter("r_no"));
			
			//content 내용 가져오기
			rdto.setStart(postNo);
			rdto.setEnd(postNo+1);
			ReviewDTO review = reviewService.getReviewcontent(rdto);
			model.addAttribute("review", review);
			
			
			//점수를 별로 바꾸는 것(jsp에 value값)
			String ratings = "";
			for(int i=0; i <review.getR_star(); i++) {
				ratings += "★";
			}
			for(int i=0; i <5-review.getR_star(); i++) {
				ratings += "☆";
			}
			
			//모델에 저장
			model.addAttribute("ratings", ratings);
			
			//페이지 불러오기
			page = "custom/review/ReviewContent";
			
				}
			}else {
				page = "/";
			}
			
			//세션에 저장
			session.setAttribute("ssKey", mdto);
			model.addAttribute("contentsJsp", page);
			
			
			return "Main";
		}
	   
	   @RequestMapping("/replyWriteProc")
	   public String ReplyWriteProc (HttpServletRequest request, HttpServletResponse response,
	         Model model, ReviewDTO rdto) {

		   //변수 선언
		   String msg = null;
		   String url = "/shopMgt";
		   
		   //세션 받아오기
		   HttpSession session = request.getSession();
		   MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");
		   if(sdto!=null && sdto.getM_role().equals("admin")) {
			   

		   //rdto.setM_id(세션) 세션에서 member_id를 빼서 rdto에 넣어주기
		   rdto.setM_id(sdto.getM_id());

		   //결과 처리
		   int result = reviewService.replyWrite(rdto);

		   //결과에 따른 메세지 출력
		   if(result>0) {
			   msg = "후기 답글이 등록되었습니다.";
		   } else {
			   msg = "후기 답글 등록에 실패했습니다.";
		   }
	      
		   }else {
			   
		   }
		   //경로 및 메세지 저장
		   model.addAttribute("url",url);
		   model.addAttribute("msg",msg);
	      
		   //세션 저장
		   session.setAttribute("ssKey", sdto);
		   
		   return "MsgPage";
	   }
	  
}