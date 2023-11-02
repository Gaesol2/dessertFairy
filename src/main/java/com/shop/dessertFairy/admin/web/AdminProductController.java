package com.shop.dessertFairy.admin.web;

import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.dessert.dto.DessertDTO;
import com.shop.dessertFairy.dessert.service.DessertService;
import com.shop.dessertFairy.member.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminProductController {

	@Autowired
	DessertService dessertService;
	
	@Value("${resources.location}")
	String resourcesLocation;			////실제로 파일이 저장되는 파일서버 경로 설정한 값을 가져온것
	
	@RequestMapping("productMgt")
	public String ProductMgt(HttpServletRequest request,
							 HttpServletResponse response,
							 Model model,
							 MemberDTO adto,
							 PageDTO pdto) {
		String page = null;
		MemberDTO ssKey = null;
		HttpSession session = request.getSession();
		
		if(session.getAttribute("ssKey") != null) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			if(ssKey.getM_role().equals("admin")) {
				model.addAttribute("contentsJsp", "admin/ProductList");
				page = "Main";
			}else page = "redirect:/";
		}else page = "redirect:/";
		
		Map<String, Object> resultSet = dessertService.getProductList(pdto);
		model.addAttribute("pcnt", resultSet.get("pcnt"));
		model.addAttribute("pList", resultSet.get("pList"));
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
			@RequestParam("image") MultipartFile file) {
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
	@RequestMapping("/productDetail")
	public String productDetail(HttpServletRequest request,
			HttpServletResponse respose,
			Model model,
			DessertDTO ddto,
			MemberDTO mdto) {
		
		String page = null;
		MemberDTO ssKey =null;
		HttpSession session = request.getSession();
		int dno = 0;
		if(session.getAttribute("ssKey")!=null ) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			if(ssKey.getM_role().equals("admin")) {
				model.addAttribute("contentsJsp", "admin/ProductDetail");
				page="Main";
			}
			else page="redirect:/";
		}
		else {
			page="redirect:/";
		}
		DessertDTO dessert = 
		dessertService.getDessert(ddto);
		dno = dessert.getD_no();
		
		model.addAttribute("dno", dno);
		session.setAttribute("ssKey", mdto);
		
		return page;
	}

}
