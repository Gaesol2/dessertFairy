package com.shop.dessertFairy.review.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {

	@RequestMapping("/photoBoard")
	public String PhotoList () {
		
		return "custom/review/ReviewList";
	}

	@RequestMapping("/reviewWrite")
	public String ReviewWrite () {
		
		return "custom/review/ReviewWrite";
	}

	@RequestMapping("/reviewContent")
	public String ReviewContent () {
		
		return "custom/review/ReviewContent";
	}
	
}
