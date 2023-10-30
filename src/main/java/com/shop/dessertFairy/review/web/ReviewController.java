package com.shop.dessertFairy.review.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.review.dto.ReviewDTO;
import com.shop.dessertFairy.review.service.ReviewService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	//실제로 파일이 저장되는 파일 서버 경로를 가져온 것. properties에 있는 주소 불러와 스트링 변수 resourceLocation에 저장
	@Value("${resources.location}")
	String resourcesLocation;

	@RequestMapping("/reviewList")
	public String PhotoList (HttpServletRequest request, HttpServletResponse response,
			Model model, ReviewDTO rdto) {
		
		
		
		String contentsJsp = "/custom/review/ReviewList";
		
		model.addAttribute("contentsJsp",contentsJsp);
		
		return "Main";
	}

	@RequestMapping("/reviewWrite")
	public String ReviewWrite (HttpServletRequest request, HttpServletResponse response,
			Model model, ReviewDTO rdto) {
		
		//HttpSession 세션 받아오기
		
		//세션이 없으면 로그인 먼저 하라고 로그인 페이지로 보내기
		
		String contentsJsp = "/custom/review/ReviewWrite";
		String msg = null;
		
		model.addAttribute("contentsJsp",contentsJsp);
		model.addAttribute("msg",msg);
		
		//세션 저장해주기
		
		return "Main";
	}

	@RequestMapping("/reviewWriteProc")
	public String ReviewWriteProc (HttpServletRequest request, HttpServletResponse response,
			Model model, ReviewDTO rdto, @RequestParam("image2") MultipartFile file) {
		
		System.out.println("글쓰기프록");
		String msg = null;
		String url = "/reviewList";
		
		//세션 받아오기
		
		//rdto.setM_id(세션) 세션에서 member_id를 빼서 rdto에 넣어주기
		
		rdto.setR_path(resourcesLocation);
		
		System.out.println(rdto.getR_path());
		System.out.println("file ====== : " + file);
		
		int result = reviewService.reviewWrite(rdto, file);
		
		System.out.println("result======"+result);
		
		if(result>0) {
			msg = "포토리뷰가 등록되었습니다.";
		} else {
			msg = "포토리뷰 등록에 실패했습니다.";
		}
		
		model.addAttribute("url",url);
		model.addAttribute("msg",msg);
		
		//세션 저장해주기
		
		return "MsgPage";
	}

	@RequestMapping("/reviewContent")
	public String ReviewContent (HttpServletRequest request, HttpServletResponse response,
			Model model, ReviewDTO rdto) {
		
		
		
		String contentsJsp = "/custom/review/ReviewContent";
		
		
		model.addAttribute("contentsJsp",contentsJsp);
		
		return "Main";
	}
	
	
	public String myArticle(HttpServletRequest request, HttpServletResponse response,
			Model model, ReviewDTO rdto) {
		
		String contentsJsp = "/custom/review/MyArticle";
		
		model.addAttribute("contentsJsp",contentsJsp);
		
		return "Main";
	}
}
