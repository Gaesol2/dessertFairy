package com.shop.dessertFairy.notice.web;

import java.util.List;
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
	            page = "Main";
	            contentsJsp = "./admin/notice/NoticeList";
	     
	      }else {//방문자,고객
	         page = "Main";
	         contentsJsp = "./custom/notice/NoticeList";
	      }
	      session.setAttribute("ssKey", mdto);
	      model.addAttribute("pageDto", reSet.get("pageDto"));
	      model.addAttribute("pBlock", RowInterPage.PAGE_OF_BLOCK);
	      model.addAttribute("totCnt", reSet.get("totCnt"));
	      model.addAttribute("nList", reSet.get("noticeList"));
	      model.addAttribute("contentsJsp", contentsJsp);
	      
	      return page;
	   }
	@RequestMapping("/noticeGanerate")
	public String notiGenerate(HttpServletRequest request, HttpServletResponse response, NoticeDTO ndto, Model model, PageDTO pageDto) {
		HttpSession session = request.getSession();
		String contentsJsp = null;
		String page = null;
		MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
		if(mdto!=null && mdto.getM_role().equals("admin")) {
				page = "Main";
				contentsJsp = "./admin/notice/NoticeGanerate";
			} else { // 고객, 방문자
				page = "redirect:/notice";
			}
		session.setAttribute("ssKey", mdto);
		model.addAttribute("contentsJsp", contentsJsp);
		return page;
	}
	@RequestMapping("/noticeProc")
	public String noticeProc(HttpServletRequest request, HttpServletResponse response, NoticeDTO ndto, Model model, PageDTO pageDto) {
		// 모든 데이터를 request에 실어서 보내줌
		String flag = request.getParameter("flag");
		HttpSession session = request.getSession();
		String contentsJsp = null;
		String page = null;
		MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
		if(mdto!=null && mdto.getM_role().equals("admin")) {
			String msg = null;
			String url = null;
				switch (flag) {
				case "insert": {
					noticeService.generateNotice(ndto);
					page = "redirect:/notice";
					break;
					}
				case "update": {
					// 수정용
					page = "MsgPage";
					int r = noticeService.updateProc(ndto);
					if(r>0) msg = "수정이 완료되었습니다.";
					else msg = "수정을 실패했습니다.";
					url = "/notice";
					break;
				}
				case "delete": {
					// 삭제용
					page = "MsgPage";
					int r = noticeService.deleteProc(ndto);
					if(r>0) msg = "삭제가 완료되었습니다.";
					else msg = "삭제를 실패했습니다.";
					url = "/notice";
					break;
					}
				}
				if(url!=null) model.addAttribute("url", url);
				if(msg!=null) model.addAttribute("msg", msg);
			} else {
				page = "Main";
				contentsJsp = "./custom/notice/NoticeList";
			}
		session.setAttribute("ssKey", mdto);
		model.addAttribute("contentsJsp", contentsJsp);
		return page;
	}
	@RequestMapping("/noticeDetail")
	public String noticeDetail(HttpServletRequest request, HttpServletResponse response, NoticeDTO ndto, Model model, PageDTO pageDto) {
		HttpSession session = request.getSession();
		String contentsJsp = null;
		String page = null;
		MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
		if(mdto!=null && mdto.getM_role().equals("admin")) {
				NoticeDTO notice = noticeService.getNotice(ndto);
				model.addAttribute("notice", notice);
				page = "Main";
				contentsJsp = "./notice/Notice";
			} else {
				// 고객용에서도 조회가 되어야 할 듯함(조회수 증가)
				Map<String, Object> reSet = noticeService.getNoticies(ndto, pageDto);
				@SuppressWarnings("unchecked")
				List<NoticeDTO> noticeList = (List<NoticeDTO>) reSet.get("noticeList");
				model.addAttribute("notice", noticeList.get(0));
				page = "Main";
				contentsJsp = "./custom/notice/Notice";
			}
		session.setAttribute("ssKey", mdto);
		model.addAttribute("contentsJsp", contentsJsp);
		return page;
	}
	
	@RequestMapping("/noticeUpForm")
	public String noticeUpForm(HttpServletRequest request, HttpServletResponse response, NoticeDTO ndto, Model model, PageDTO pageDto) {
		HttpSession session = request.getSession();
		String contentsJsp = null;
		String page = null;
		MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
		if(mdto!=null && mdto.getM_role().equals("admin")) {
				page = "Main";
				contentsJsp = "./admin/notice/NoticeUpForm";
			} else {
				page = "Main";
				contentsJsp = "./custom/notice/NoticeList";
			}
		session.setAttribute("ssKey", mdto);
		model.addAttribute("notice", ndto);
		model.addAttribute("contentsJsp", contentsJsp);
		return page;
	}
	
}
