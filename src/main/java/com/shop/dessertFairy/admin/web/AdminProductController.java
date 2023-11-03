package com.shop.dessertFairy.admin.web;

import java.util.Map;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping("productMgt")	// 상품 개수와 목록. 상품리스트
	public String ProductMgt(HttpServletRequest request,
							 HttpServletResponse response,
							 Model model,
							 MemberDTO adto,
							 PageDTO pdto) {
		String page = null;
		MemberDTO ssKey = null;
		HttpSession session = request.getSession();						// 현재 사용자의 세션을 받아옴
		
		if(session.getAttribute("ssKey") != null) {						// ssKey가 null이 아니면
			ssKey = (MemberDTO) session.getAttribute("ssKey");			// 현재 세션의 ssKey를 받아옴
			if(ssKey.getM_role().equals("admin")) {						// ssKey의 권한이 admin이면
				model.addAttribute("contentsJsp", "admin/product/ProductList");		// 컨텐츠페이지에 상품 리스트 페이지를 넣음
				page = "Main";														
			}else page = "redirect:/";									// 사용자의 세션이 admin이 아니면 홈으로 보냄
		}else page = "redirect:/";										// 세션의 ssKey값이 null=비회원  이면 홈으로 보냄
		
		Map<String, Object> resultSet = dessertService.getProductList(pdto);	// 상품리스트 메소드 호출해서 받아온 결과를 담아줌
		model.addAttribute("pcnt", resultSet.get("pcnt"));						// 상품결과를 받아와서 저장
		model.addAttribute("pList", resultSet.get("pList"));					// 상품 목록을 받아와서 저장
		session.setAttribute("ssKey", ssKey);									// 세션 저장
		
		return page;
	}

	@RequestMapping("/productInForm")		// 상품리스트페이지->상품 등록 페이지로 이동
	public String productInForm(HttpServletRequest request,
			HttpServletResponse respose,
			Model model,
			DessertDTO ddto) {
		String page=null;
		MemberDTO ssKey =null;
		HttpSession session = request.getSession();									// 세션 받아와서
		if(session.getAttribute("ssKey")!=null ) {									// 회원 구분
			ssKey = (MemberDTO) session.getAttribute("ssKey");						// 회원일 경우 세션에 저장되어 있는 회원권한 받아옴
			if(ssKey.getM_role().equals("admin")) {									// 관리자일 경우
				model.addAttribute("contentsJsp", "admin/product/ProductInForm");	// 상품 등록 페이지로 이동
				page="Main";
			}
			else page="redirect:/";													// 관리자가 아닐 경우 홈으로
		}
		else {
			page="redirect:/";														// 비회원일 경우 홈으로
		}
		//모든 상품 리스트를 갖고 오기 --getProductList
		session.setAttribute("ssKey", ssKey);										// 세션 저장
		return page;
	}
	
	@RequestMapping("/productUpForm")					// detail.jsp->productUp(js)->상품 수정 페이지 이동		
	public String productUpForm(HttpServletRequest request,
								HttpServletResponse respose,
								Model model,
								DessertDTO ddto) {
		String page=null;
		MemberDTO ssKey = null;
	    DessertDTO beforeDto = null;
		HttpSession session = request.getSession();
		if(session.getAttribute("ssKey")!=null ) {
			ssKey = (MemberDTO) session.getAttribute("ssKey");
			if(ssKey.getM_role().equals("admin")) {
				beforeDto = dessertService.getProduct(ddto.getD_no());
				page="admin/product/ProductUpForm";
			}else page="redirect:/";
		}else {
			page="redirect:/";
		}
		//모든 상품 리스트를 갖고 오기 --getProductList
		model.addAttribute("ddto", beforeDto);
		session.setAttribute("ssKey", ssKey);
		
		return page;
	}
	
	@RequestMapping("orderCntOfProduct")		// 주문 내역 확인. 데이터 삭제를 위해 필요
	@ResponseBody
	public int orderCntOfProduct(HttpServletRequest request) {
		int dno =Integer.parseInt(request.getParameter("d_no"));	// orderCntOfProduct 메소드 호출 시 매개변수 타입으로 주기 위해
		return dessertService.orderCntOfProduct(dno);
	}
	
	@RequestMapping("/productMgtProc")		// 상품 등록, 수정, 삭제 프로세스
	public String productMgtProc(HttpServletRequest request,
								 HttpServletResponse respose,
								 Model model,
								 DessertDTO ddto,
								 @RequestParam("inImage") MultipartFile file) {
		MemberDTO ssKey =null;
		String url = null;
		String msg = null;
		int r=0;													// 상품등록 결과 값을 담아줄 변수 선언
		HttpSession session = request.getSession();					// 세션 받아옴
		if(session.getAttribute("ssKey")!=null ) {					// 회원 비회원 구분
		 ssKey = (MemberDTO) session.getAttribute("ssKey");			// 회원일 경우 세션 저장
		 if(ssKey.getM_role().equals("admin")) {					// 관리자일 경우
			//실제로 작업(flag따라서 insert와 update)
		  String flag = request.getParameter("flag");				// jsp페이지의 <form action="/productMgtProc?flag=" 받아옴
		  if(flag.equals("insert")) {								//  <form action="/productMgtProc?flag=insert" 일 경우 상품등록
			  //업로드 경로 저장
			  ddto.setD_path(resourcesLocation);					// 이미지 경로
			  r = dessertService.insertProduct(ddto, file);			// 상품등록 메소드 호출해서 결과를 변수 r에 담음
			  if(r>0) {												
				  msg = "상품등록성공";
			  }else {
				  msg = "상품등록실패";
			  }
			  url = "productMgt";									// 상품 등록하면 상품리스트 페이지로 이동
		   }else if(flag.equals("update")) {
			   ddto.setD_path(resourcesLocation);
			   r = dessertService.updateProduct(ddto, file);		// 매퍼에서 수행된 행의 개수가 반환되면 그 값을 r에 저장
			   if(r>0) {
					  msg = "상품수정성공";
				  }else {
					  msg = "상품수정실패";
				  }
				  url = "productMgt";
		   }else if(flag.equals("delete")) {
			   System.out.println("flag 값은 = :"+flag);
			   ddto.setD_path(resourcesLocation);
			   r = dessertService.deleteProduct(ddto);		// 매퍼에서 수행된 행의 개수가 반환되면 그 값을 r에 저장
			   if(r>0) {
					  msg = "상품삭제성공";
				  }else {
					  msg = "상품삭제실패";
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
	
	@RequestMapping("/productDel")		// 상품 등록, 수정, 삭제 프로세스
	public String productMgtProc(HttpServletRequest request,
			HttpServletResponse respose,
			Model model,
			DessertDTO ddto) {
		MemberDTO ssKey =null;
		String url = null;
		String msg = null;
		int r=0;													// 상품등록 결과 값을 담아줄 변수 선언
		HttpSession session = request.getSession();					// 세션 받아옴
		if(session.getAttribute("ssKey")!=null ) {					// 회원 비회원 구분
			ssKey = (MemberDTO) session.getAttribute("ssKey");			// 회원일 경우 세션 저장
			if(ssKey.getM_role().equals("admin")) {					// 관리자일 경우
					ddto.setD_path(resourcesLocation);
					r = dessertService.deleteProduct(ddto);		// 매퍼에서 수행된 행의 개수가 반환되면 그 값을 r에 저장
					if(r>0) {
						msg = "상품삭제성공";
					}else {
						msg = "상품삭제실패";
					}
					url = "productMgt";
				}
			}else {
				url="redirect:/";
				msg="잘못된 경로 접근입니다.";
			}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		session.setAttribute("ssKey", ssKey);
		return "MsgPage";
	}

	@RequestMapping("/productDetail")		// 상품 디테일
	public String productDetail(HttpServletRequest request,
			HttpServletResponse respose,
			Model model,
			DessertDTO ddto,
			MemberDTO mdto) {
		
		String page = null;
		HttpSession session = request.getSession();							// 세션 받아서 저장
		MemberDTO ssKey = (MemberDTO) session.getAttribute("ssKey");		// 받아온 세션에서 ssKey값을 받아와 저장
		int dno = 0;
		if(session.getAttribute("ssKey")!=null ) {							// 회원 비회원 구분
			ssKey = (MemberDTO) session.getAttribute("ssKey");				// 회원이면 ssKey값 저장
			if(ssKey.getM_role().equals("admin")) {							// 저장한 ssKey값으로 관리자와 일반 회원 구분. 관리자라면
				model.addAttribute("contentsJsp", "admin/product/ProductDetail");	// admin 상품 디테일 페이지로 이동
				page="Main";
			}
			else page="redirect:/";
		}
		else {
			page="redirect:/";
		}
		DessertDTO dessert = dessertService.adminGetDessert(ddto.getD_no());	// 상품리스트 jsp페이지에서 받은 파라미터값인 상품번호를 기준으로 상품 정보 받아옴
		dno = dessert.getD_no();												// 받아온 상품의 상품 번호 저장
		model.addAttribute("dessert", dessert);									// 상품 정보 저장
		model.addAttribute("dno", dno);											//상품 번호 저장
		session.setAttribute("ssKey", ssKey);									//세션 저장
		
		return page;
	}

}
