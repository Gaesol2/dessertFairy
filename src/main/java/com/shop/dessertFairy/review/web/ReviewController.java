package com.shop.dessertFairy.review.web;

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
public class ReviewController {
   
   @Autowired
   ReviewService reviewService;
   
   @Autowired
   MemberService memberService;
   
   //실제로 파일이 저장되는 파일 서버 경로를 가져온 것. properties에 있는 주소 불러와 스트링 변수 resourceLocation에 저장
   @Value("${resources.location}")
   String resourcesLocation;

   
   
 // --리뷰 목록 + 글쓰기 start
   
   
   @RequestMapping("/reviewList")//리뷰 리스트
   public String reviewList(HttpServletRequest request, HttpServletResponse response,
         Model model, ReviewDTO rdto,
         PageDTO pageDto) { 
	   
        //변수 선언
	    String page = null;
	    MemberDTO ssKey = null;
	    String contentsJsp = "/custom/review/ReviewList";
	    
	    //HttpSession 세션 객체 생성 및 세션 정보 받아오기
		HttpSession session = request.getSession();
		
		//세션이 있으면 ReviewList 페이지로 보내고 없으면 로그인 창으로 보내기
		if(session.getAttribute("ssKey")!=null) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			contentsJsp = "/custom/review/ReviewList";
			   page = "Main";
		}else {
			page = "redirect:/login";
		}
		
		//jsp로부터 orderby 파라미터를 받고, null이 들어오면 최신순으로 설정
		String orderby = request.getParameter("orderby");
		if(orderby==null) orderby = "new";
		
		//리스트 목록과 페이지 수 계산한것을 불러온 것
		Map<String, Object> reSet = reviewService.getReviewList(rdto, pageDto, orderby);
		
		//세션 저장
		session.setAttribute("ssKey", ssKey);
		
		//데이터 저장
		model.addAttribute("cnt", reSet.get("cnt"));
		model.addAttribute("reviewList", reSet.get("reviewList"));
		model.addAttribute("pBlock", RowInterPage.PAGE_OF_BLOCK);
		model.addAttribute("contentsJsp",contentsJsp);
		model.addAttribute("pageDto",pageDto);
		model.addAttribute("orderby",orderby);
		
		
		return page;
	}
	   
	   
      
      

   @RequestMapping("/reviewWrite") //리뷰 글쓰기 경로
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
   

   @RequestMapping("/reviewWriteProc") //리뷰글쓰기 폼
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
   

   @RequestMapping("/reviewContent") //리뷰 내용보기
   public String ReviewContent (HttpServletRequest request, HttpServletResponse response,
         Model model, ReviewDTO rdto, PageDTO pageDto) {
	   
	   //세션 받아오기
	   HttpSession session = request.getSession();
	   
	   //변수 선언해주기
	   String contentsJsp = "/custom/review/ReviewContent";
		String page = null;
		
		//ssKey 세션에 있는 정보를 MemberDTO 타입의 mdto에 저장
		MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
		
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
		
		//세션에 저장
		session.setAttribute("ssKey", mdto);
		model.addAttribute("contentsJsp", page);
		
		
		return "Main";
	}
   
   
  // --리뷰 목록 + 글쓰기 end 
   
   
   
   
  // --내 글보기 start 
   
   @RequestMapping("/mylist") //내 글보기 목록
   public String mylist(HttpServletRequest request, HttpServletResponse response,
		   Model model, ReviewDTO rdto,
		   PageDTO pageDto) { 
	   
	   //변수 선언
	   String page = null;
	   MemberDTO ssKey = null;
	   String contentsJsp = "/custom/review/MyList";
	   
	   //HttpSession 세션 객체 생성 및 세션 정보 받아오기
	   HttpSession session = request.getSession();
	   
	   
	   
	   //세션이 있으면 ReviewMyList 페이지로 보내고 없으면 로그인 창으로 보내기
	   if(session.getAttribute("ssKey")!=null) {
		   
		   MemberDTO mdto = memberService.getMember(ssKey);
		   ssKey = (MemberDTO) session.getAttribute("ssKey");
		   rdto.setM_id(ssKey.getM_id());
		   page = "custom/review/MyList";
	   }
	   else {
		   page = "redirect:/login";
	   }
	   
	   //jsp로부터 orderby 파라미터를 받고, null이 들어오면 최신순으로 설정
	   String orderby = request.getParameter("orderby");
	   if(orderby==null) orderby = "new";
	   
	   //리스트 목록과 페이지 수 계산한것을 불러온 것
	   Map<String, Object> reSet = reviewService.getMyList(rdto, pageDto, orderby);
	   //세션 저장
	   session.setAttribute("mdto", ssKey);
	   //데이터 저장
	   model.addAttribute("cnt", reSet.get("cnt"));
	   model.addAttribute("myList", reSet.get("myList"));
	   model.addAttribute("pBlock", RowInterPage.PAGE_OF_BLOCK);
	   model.addAttribute("contentsJsp",contentsJsp);
	   model.addAttribute("pageDto",pageDto);
	   model.addAttribute("orderby",orderby);
	   model.addAttribute("page",page);
	   
	   
	   return "Main";
   }
   
   
   
   @RequestMapping("/myContent")
   public String MyContent (HttpServletRequest request, HttpServletResponse response,
		   Model model, ReviewDTO rdto, PageDTO pageDto) {
	   
	   //세션 받아오기
	   HttpSession session = request.getSession();
	   
	   //변수 선언해주기
	   String contentsJsp = "/custom/review/MyContent";
	   String page = null;
	   
	   //ssKey 세션에 있는 정보를 MemberDTO 타입의 mdto에 저장
	   MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
	   
	   //파라메터에서 r_no를 가져온것
	   int postNo = Integer.parseInt(request.getParameter("r_no"));
	   
	   //content 내용 가져오기
	   rdto.setStart(postNo);
	   rdto.setEnd(postNo+1);
	   ReviewDTO review = reviewService.getMycontent(rdto);
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
	   page = "custom/review/MyContent";
	   
	   //세션에 저장
	   session.setAttribute("ssKey", mdto);
	   model.addAttribute("contentsJsp", page);
	   
	   
	   return "Main";
   }
   
   @RequestMapping("/myUpForm")
   public String ReviewUpForm(HttpServletRequest request, HttpServletResponse response,
		   ReviewDTO rdto,
		   Model model,
		   PageDTO pageDto) {
	   HttpSession session = request.getSession();
	   
	   String contentsJsp = null;
	   String page = null;
	   
	   MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
	   if(session.getAttribute("ssKey")!=null) {
		 
		   ReviewDTO review = reviewService.getMycontent(rdto);
		   model.addAttribute("review", review);
		   
		   
		   //점수를 별로 바꾸는 것(jsp에 value값)
		   String ratings = "";
		   for(int i=0; i <review.getR_star(); i++) {
			   ratings += "★";
		   }
		   
		   //모델에 저장
		   model.addAttribute("ratingLength", ratings.length());
		   page = "Main";
		   contentsJsp = "./custom/review/MyUpContent";
	   }else {
		   page = "Main";
		   contentsJsp = "./custom/member/Login";
	   }
	   
	   
	   
	   session.setAttribute("ssKey", mdto);
	   model.addAttribute("review", rdto);
	   model.addAttribute("contentsJsp", contentsJsp);
	   
	   return page;
   }
   
   
   @RequestMapping("/upProc")
	public String UpProc(HttpServletRequest request, HttpServletResponse response,
			ReviewDTO rdto,
			Model model,
			PageDTO pageDto,
			@RequestParam("image2") MultipartFile file) {
	   
		HttpSession session = request.getSession();
		String contentsJsp = null;
		String page = null;
		MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
		
		//이미지 경로 저장
		 rdto.setR_path(resourcesLocation);

		 //결과 처리
		if(session.getAttribute("ssKey")!=null) {
			String msg = null;
			String url = null;
				
					page = "MsgPage";
					System.out.println(rdto);
					int r = reviewService.updateProc(rdto, file);
					if(r>0) msg = "수정이 완료 되었습니다.";
					else msg = "수정을 실패했습니다.";
					url = "/mylist";
				if(url!=null) model.addAttribute("url", url);
				if(msg!=null) model.addAttribute("msg", msg);
				
			}else {
				page = "Main";
				contentsJsp = "custom/review/MyList";
			}
		
		session.setAttribute("ssKey", mdto);
		model.addAttribute("contentsJsp", contentsJsp);
		
		return page;
	}
   
   @RequestMapping("/delProc")
   public String ReviewProc(HttpServletRequest request, HttpServletResponse response,
		   ReviewDTO rdto,
		   Model model,
		   PageDTO pageDto) {
	   String flag = request.getParameter("flag");
	   HttpSession session = request.getSession();
	   String contentsJsp = null;
	   String page = null;
	   MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
	   if(session.getAttribute("ssKey")!=null) {
		   String msg = null;
		   String url = null;
		  
			   page = "MsgPage";
			   int r = reviewService.deleteProc(rdto);
			   if(r>0) msg = "삭제가 완료 되었습니다.";
			   else msg = "삭제를 실패했습니다.";
			   url = "/mylist";
		
		   if(url!=null) model.addAttribute("url", url);
		   if(msg!=null) model.addAttribute("msg", msg);
		   
	   }else {
		   page = "Main";
		   contentsJsp = "./custom/review/MyList";
	   }
	   
	   session.setAttribute("ssKey", mdto);
	   model.addAttribute("contentsJsp", contentsJsp);
	   
	   return page;
   }
   
   
   
   public String myArticle(HttpServletRequest request, HttpServletResponse response,
         Model model, ReviewDTO rdto) {
      
	   //변수 선언해서 MyArticle 불러오기
      String contentsJsp = "/custom/review/MyArticle";
      
      //위에꺼 받아오기
      model.addAttribute("contentsJsp",contentsJsp);
      
      return "Main";
   }
}