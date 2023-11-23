package com.shop.dessertFairy.cake.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.cake.dto.CakeDTO;
import com.shop.dessertFairy.cake.service.CakeService;
import com.shop.dessertFairy.member.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CakeController {
	
	@Autowired
	CakeService cakeService;
	
    @Value("${resources.location}")
    String resourcesLocation;
	
	@RequestMapping("/cake")
	public String cake(HttpServletRequest request,
			                HttpServletResponse response,
			                Model model) {
		
		model.addAttribute("contentsJsp", "custom/cake/CakeOrder");
		
		return "Main";
	}

	@RequestMapping("cakeRequest")
	public String CakeRequest(HttpServletRequest request, HttpServletResponse response) {
		return "custom/cake/CakeRequest";
	}
	
	@RequestMapping("cakeOrderProc")
	public String CakeOrderProc(HttpServletRequest request, HttpServletResponse response,
			Model model, CakeDTO cdto, @RequestParam("image") MultipartFile file) {
		//멀티파트 추가하기
		
		HttpSession session = request.getSession();
		MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");
		
		String msg = null;
		String page = null;
		String url = null;
		String contentsJsp = null;
		
		if(sdto==null) {
			msg = "로그인이 필요합니다.";
			page = "MsgPage";
			url = "login";
		} else {
			page = "Main";
			contentsJsp = "custom/cake/CakeComplete";
		}
		
		cdto.setC_path(resourcesLocation);
		
		cdto.setM_id(sdto.getM_id());
		
		int result = cakeService.cakeOrderProc(cdto, file);
		
		
		System.out.println("케이크=========>"+cdto);
		model.addAttribute("msg",msg);
		model.addAttribute("url",url);
		model.addAttribute("contentsJsp",contentsJsp);
		model.addAttribute("cdto",cdto);
		session.setAttribute("ssKey", sdto);
		
		return page;
	}
}
