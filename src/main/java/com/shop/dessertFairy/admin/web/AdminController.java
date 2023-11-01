package com.shop.dessertFairy.admin.web;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.dessert.dto.DessertDTO;
import com.shop.dessertFairy.dessert.service.DessertService;
import com.shop.dessertFairy.member.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	@Autowired
	DessertService dessertService;
	
	@Value("${resources.location}")
	String resourcesLocation;			////실제로 파일이 저장되는 파일서버 경로 설정한 값을 가져온것
	
	@RequestMapping("shopMgt")
	public String ShopMgt(HttpServletRequest request,
            			  HttpServletResponse response,
            			  Model model,
            			  MemberDTO mdto) {
		HttpSession session = request.getSession();
		MemberDTO ssKey = null;
		String page = null;
		
		if(session.getAttribute("ssKey") != null) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			if(ssKey.getM_role().equals("admin")) {
				model.addAttribute("contentsJsp", "admin/ShopMgt");
				page = "Main";
			}
			else page = "redirect:/";
		}
		return page;
	}

	@RequestMapping("productMgt")
	public String ProductMgt(HttpServletRequest request,
							 HttpServletResponse response,
							 Model model,
							 MemberDTO adto) {
		HttpSession session = request.getSession();
		MemberDTO ssKey = null;
		String page = null;
		String flag = request.getParameter("flag");
		
		if(session.getAttribute("ssKey") != null) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			if(ssKey.getM_role().equals("admin")) {
				model.addAttribute("contentsJsp", "admin/ProductList");
				page = "Main";
			}
			else page = "redirect:/";
		}else page = "redirect:/";
		
		Map<String, Object> resultSet = dessertService.getDessertList(flag);
		model.addAttribute("dessertCnt", resultSet.get("dessertCnt"));
		model.addAttribute("dessert", resultSet.get("dessert"));
		session.setAttribute("ssKey", ssKey);
		return page;
	}

	@RequestMapping("/productInForm")
	public String productInForm(HttpServletRequest request,
			HttpServletResponse respose,
			Model model,
			DessertDTO ddto) {
		String page=null;
		MemberDTO ssKey =null;
		HttpSession session = request.getSession();
		if(session.getAttribute("ssKey")!=null ) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			if(ssKey.getM_role().equals("admin")) {
				model.addAttribute("contentsJsp", "admin/ProductInForm");
				page="Main";
			}
			else page="redirect:/";
		}
		else {
			page="redirect:/";
		}
		//모든 상품 리스트를 갖고 오기 --getProductList
		session.setAttribute("ssKey", ssKey);
		return page;
	}
	
	@RequestMapping("/productMgtProc")
	public String productMgtProc(HttpServletRequest request,
			HttpServletResponse respose,
			Model model,
			DessertDTO ddto,
			@RequestParam("image2") MultipartFile file) {
		MemberDTO ssKey =null;
		String url = null;
		String msg = null;
		int r;
		HttpSession session = request.getSession();
		if(session.getAttribute("ssKey")!=null ) {
		 ssKey = (MemberDTO) session.getAttribute("ssKey");
		 if(ssKey.getM_role().equals("admin")) {
			//실제로 작업(flag따라서 insert와 update)
		  String flag = request.getParameter("flag");
		  if(flag.equals("insert")) {
			  //업로드 경로 저장
			  ddto.setD_path(resourcesLocation);
			  r = dessertService.insertProduct(ddto, file);
			  if(r>0) {
				  msg = "상품등록성공";
			  }else {
				  msg = "상품등록실패";
			  }
			  url = "productMgt";
		   }else if(flag.equals("update")) {
			   ddto.setD_path(resourcesLocation);
			   r = dessertService.updateProduct(ddto, file);
			   if(r>0) {
					  msg = "상품수정성공";
				  }else {
					  msg = "상품수정실패";
				  }
				  url = "productMgt";
		   }
		 }else {
			 url="redirect:/";
			 msg="잘못된 경로 접근입니다.";
		 }
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		session.setAttribute("ssKey", ssKey);
		return "MsgPage";
	}
	
	@RequestMapping("orderMgt")
	public String OrderMgt(HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			MemberDTO adto) {
		HttpSession session = request.getSession();
		MemberDTO ssKey = null;
		String page = null;
		
		if(session.getAttribute("ssKey") != null) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			if(ssKey.getM_role().equals("admin")) {
				model.addAttribute("contentsJsp", "admin/OrderMgt");
				page = "Main";
			}
			else page = "redirect:/";
		}
		return page;
	}
	
	@RequestMapping("memberMgt")
	public String MemberMgt(HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			MemberDTO adto) {
		HttpSession session = request.getSession();
		MemberDTO ssKey = null;
		String page = null;
		
		if(session.getAttribute("ssKey") != null) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			if(ssKey.getM_role().equals("admin")) {
				model.addAttribute("contentsJsp", "admin/MemberMgt");
				page = "Main";
			}
			else page = "redirect:/";
		}
		return page;
	}
}
