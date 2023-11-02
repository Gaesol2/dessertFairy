package com.shop.dessertFairy.notice.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.common.RowInterPage;
import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.notice.dto.NoticeDTO;
import com.shop.dessertFairy.notice.service.NoticeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class NoticeController {

	@Autowired
	NoticeService noticeService;
	
	@RequestMapping("/notice")
	   public String noticeList(HttpServletRequest request, HttpServletResponse response,
	                      NoticeDTO ndto,
	                      Model model,
	                      PageDTO pageDto) {
	      Map<String, Object> reSet
	                   = noticeService.getNoticies(ndto, pageDto);
	      HttpSession session = request.getSession();
	      String contentsJsp = null;
	      String page = null;
	      MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
	      if(mdto!=null && mdto.getM_role().equals("admin")) {
	            page = "admin/Main";
	            contentsJsp = "./NoticeList";
	     
	      }else {//방문자,고객
	         page = "Main";
	         contentsJsp = "./custom/NoticeList";
	      }
	      session.setAttribute("ssKey", mdto);
	      model.addAttribute("pageDto", reSet.get("pageDto"));
	      model.addAttribute("pBlock", RowInterPage.PAGE_OF_BLOCK);
	      model.addAttribute("totCnt", reSet.get("totCnt"));
	      model.addAttribute("nList", reSet.get("noticeList"));
	      model.addAttribute("contentsJsp", contentsJsp);
	      
	      return page;
	   }
	
}
