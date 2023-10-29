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
		
		String contentsJsp = "/custom/review/ReviewWrite";
		String msg = null;
		
			msg = "포토리뷰가 등록되었습니다.";
		
		model.addAttribute("contentsJsp",contentsJsp);
		model.addAttribute("msg",msg);
		
		return "Main";
	}

	@RequestMapping("/reviewWriteProc")
	
	public String ReviewWriteProc (HttpServletRequest request, HttpServletResponse response,
			Model model, ReviewDTO rdto) {
		
		String msg = null;
		String url = null;
		
		int result = reviewService.reviewWrite(rdto);
		
		if(result>0) {
			msg = "포토리뷰가 등록되었습니다.";
			url = "/reviewList";			
		} else {
			msg = "포토리뷰 등록에 실패했습니다.";
			url = "/reviewList";
		}
		
		model.addAttribute("url",url);
		model.addAttribute("msg",msg);
		
		return "MsgPage";
	}

	@RequestMapping("/reviewContent")
	public String ReviewContent (HttpServletRequest request, HttpServletResponse response,
			Model model, ReviewDTO rdto) {
		
		String contentsJsp = "/custom/review/ReviewContent";
		
		model.addAttribute("contentsJsp",contentsJsp);
		
		return "Main";
	}
	
}
