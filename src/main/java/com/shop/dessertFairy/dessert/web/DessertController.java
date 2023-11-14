package com.shop.dessertFairy.dessert.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.common.RowInterPage;
import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.dessert.dto.DessertDTO;
import com.shop.dessertFairy.dessert.service.DessertService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DessertController {
	
	@Autowired
	DessertService dessertService;
	
	@RequestMapping("/dessert")
	public String dessertOrder(HttpServletRequest request,
			HttpServletResponse response,
			Model model) {

		//jsp에서 flag 받아와서 스트링에 저장
		String flag = request.getParameter("flag");
		
		//HashMap 객체 resultSet 선언
		Map<String, Object> resultSet = new HashMap<>();
		
		//비즈니스 로직을 통해 dessertCnt와 dessertList 받아오기
		resultSet = dessertService.getDessertList(flag);
		
		//jsp로 보낼 정보 저장
		model.addAttribute("dessertCnt",resultSet.get("dessertCnt"));
		model.addAttribute("dessert",resultSet.get("dessert"));
		model.addAttribute("flag",flag);
		model.addAttribute("contentsJsp", "custom/dessert/DessertOrder");
		
		return "Main";
	}

	@RequestMapping("/dessertContent")
	public String dessertContent(HttpServletRequest request,
			HttpServletResponse response,
			Model model, DessertDTO ddto) {
		
		DessertDTO dessert = dessertService.getDessert(ddto);
		
		model.addAttribute("dessert",dessert);
		model.addAttribute("contentsJsp", "custom/dessert/DessertContent");
		
		return "Main";
	}
	
	@RequestMapping("/search")
	public String Search(HttpServletRequest request,
			HttpServletResponse response,
			Model model, DessertDTO ddto, PageDTO pdto) {
		
		  // 검색 단어 저장 및 flag(high/low) 저장
	      if (ddto.getKeyword() == null) {
	    	  ddto.setKeyword(request.getParameter("keyword"));
	      }
	      String page = null;
	      System.out.println("===>"+ddto);
	      System.out.println("===>"+ddto.getKeyword());
	      
	      //검색어와 페이지 저장
	      Map<String, Object> reSet = dessertService.getSearchList(ddto, pdto);
	      
	      
	      model.addAttribute("keyword", ddto.getKeyword());
	      model.addAttribute("pcnt", reSet.get("pcnt"));
	      model.addAttribute("sList", reSet.get("sList"));
	      model.addAttribute("getSearchList", reSet.get("sList"));
	      model.addAttribute("pdto", reSet.get("pdto"));
	      model.addAttribute("pBlock", RowInterPage.PAGE_OF_BLOCK);
	      page = "Main";
	      model.addAttribute("contentsJsp", "custom/search/SearchPage");
	      return page;
	   }

	
}
