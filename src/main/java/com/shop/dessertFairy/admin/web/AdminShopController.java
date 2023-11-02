package com.shop.dessertFairy.admin.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.common.RowInterPage;
import com.shop.dessertFairy.common.dto.PageDTO;
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
	
   @RequestMapping("/shopMgt")
   public String ShopMgt(HttpServletRequest request,
                       HttpServletResponse response,
                       Model model,
                       ReviewDTO rdto,
                       PageDTO pageDto) {
      HttpSession session = request.getSession();
      MemberDTO ssKey = null;
      String page = null;
      String contentsJsp = "admin/ShopMgt";
      
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
    		Map<String, Object> reSet = reviewService.getReplyList(rdto, pageDto);
    		
    		//세션 저장
    		session.setAttribute("ssKey", ssKey);
    		
    		//데이터 저장
    		model.addAttribute("cnt", reSet.get("cnt"));
    		model.addAttribute("replyList", reSet.get("replyList"));
    		model.addAttribute("pBlock", RowInterPage.PAGE_OF_BLOCK);
    		model.addAttribute("contentsJsp",contentsJsp);
    		model.addAttribute("pageDto",pageDto);
    		
    		
    		return page;
    	}
   }