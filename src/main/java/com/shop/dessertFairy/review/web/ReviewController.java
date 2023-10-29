package com.shop.dessertFairy.review.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecom4.custom.dto.MemberDTO;
import com.ecom4.product.web.HttpSession;
import com.ecom4.product.web.Value;
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
		

	@RequestMapping("/photoBoard")
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
		
		model.addAttribute("contentsJsp",contentsJsp);
		
		return "Main";
	}

	@RequestMapping("/reviewContent")
	public String ReviewContent (HttpServletRequest request, HttpServletResponse response,
			Model model, ReviewDTO rdto) {
		
		String contentsJsp = "/custom/review/ReviewContent";
		
		model.addAttribute("contentsJsp",contentsJsp);
		
		return "Main";
	}
	
}
