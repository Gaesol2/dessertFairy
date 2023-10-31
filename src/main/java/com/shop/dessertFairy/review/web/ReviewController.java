package com.shop.dessertFairy.review.web;

import java.util.List;
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
import com.shop.dessertFairy.review.dto.ReviewDTO;
import com.shop.dessertFairy.review.service.ReviewService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewController {
   
   @Autowired
   ReviewService reviewService;
   
   //실제로 파일이 저장되는 파일 서버 경로를 가져온 것. properties에 있는 주소 불러와 스트링 변수 resourceLocation에 저장
   @Value("${resources.location}")
   String resourcesLocation;

   @RequestMapping("/reviewList")
   public String reviewList(HttpServletRequest request, HttpServletResponse response,
         Model model, ReviewDTO rdto,
         PageDTO pageDto) {
      
	    String page = null;
	    MemberDTO ssKey = null;
	    String contentsJsp = "/custom/review/ReviewList";
		HttpSession session = request.getSession();
		if(session.getAttribute("ssKey")!=null) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			page = "custom/review/ReviewList";
		}
		else {
			page = "redirect:/login";
		}
		Map<String, Object> reSet = reviewService.getReviewList(rdto, pageDto);
		session.setAttribute("ssKey", ssKey);
		model.addAttribute("cnt", reSet.get("cnt"));
		model.addAttribute("reviewList", reSet.get("reviewList"));
		model.addAttribute("pBlock", RowInterPage.PAGE_OF_BLOCK);
		model.addAttribute("contentsJsp",contentsJsp);
		model.addAttribute("page",page);
		return "Main";
	}
	   
	   
      
      

   @RequestMapping("/reviewWrite")
   public String ReviewWrite (HttpServletRequest request, HttpServletResponse response,
         Model model, ReviewDTO rdto) {

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

   @RequestMapping("/reviewWriteProc")
   public String ReviewWriteProc (HttpServletRequest request, HttpServletResponse response,
         Model model, ReviewDTO rdto, @RequestParam("image2") MultipartFile file) {

	   //변수 선언
	   String msg = null;
	   String url = "/reviewList";
	   
	   //세션 받아오기
	   HttpSession session = request.getSession();
	   MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");

	   //rdto.setM_id(세션) 세션에서 member_id를 빼서 rdto에 넣어주기
	   rdto.setM_id(sdto.getM_id());

	   //이미지 경로 저장
	   rdto.setR_path(resourcesLocation);

	   //결과 처리
	   int result = reviewService.reviewWrite(rdto, file);

	   //결과에 따른 메세지 출력
	   if(result>0) {
		   msg = "포토리뷰가 등록되었습니다.";
	   } else {
		   msg = "포토리뷰 등록에 실패했습니다.";
	   }
      
	   //경로 및 메세지 저장
	   model.addAttribute("url",url);
	   model.addAttribute("msg",msg);
      
	   //세션 저장
	   session.setAttribute("ssKey", sdto);
	   
	   return "MsgPage";
   }

   @RequestMapping("/reviewContent")
   public String ReviewContent (HttpServletRequest request, HttpServletResponse response,
         Model model, ReviewDTO rdto, PageDTO pageDto) {
	   
	   HttpSession session = request.getSession();
	   String contentsJsp = "/custom/review/ReviewContent";
		String page = null;
		MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
		if(mdto!=null && mdto.getM_role().equals("admin")) {
			ReviewDTO review = reviewService.getReviewcontent(rdto);
				model.addAttribute("review", review);
				page = "admin/Main";
				contentsJsp = "./Notice";
			}else {
				//고객용에서도 조회가 되어야 할 듯(조회수 증가)
				Map<String, Object> reSet
		            = reviewService.getReviewList(rdto, pageDto);
				@SuppressWarnings("unchecked")
				List<ReviewDTO> reviewList 
				    = (List<ReviewDTO>) reSet.get("reviewList");
				model.addAttribute("review", reviewList.get(0));
				
				page = "Main";
				contentsJsp = "/custom/review/ReviewContent";
			}
		
		session.setAttribute("ssKey", mdto);
		model.addAttribute("contentsJsp", contentsJsp);
		
		
		return "Main";
	}
   
   
   public String myArticle(HttpServletRequest request, HttpServletResponse response,
         Model model, ReviewDTO rdto) {
      
      String contentsJsp = "/custom/review/MyArticle";
      
      model.addAttribute("contentsJsp",contentsJsp);
      
      return "Main";
   }
}