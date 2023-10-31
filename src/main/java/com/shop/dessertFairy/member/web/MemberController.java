package com.shop.dessertFairy.member.web;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.member.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("register")
	  public String  join(HttpServletRequest request,
			              HttpServletResponse response,
			              Model model,
			              MemberDTO mdto) {
		 
			model.addAttribute("contentsJsp", "custom/member/Register");		// 회원가입 클릭 시 Register.jsp로 보냄
		  return "Main";
	  }

	@RequestMapping("registerProc")								// Register.jsp의 registerProc 폼에서 데이터 받음
	public String  registerProc(HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			MemberDTO mdto) {
		int r = memberService.memberJoin(mdto);					// memberService 인터페이스의 memberJoin(mdto) 메소드 호출
		
		
		return "redirect:/";
	}
	
	@RequestMapping("/idCheck")							// 회원가입시 ID 중복 체크
	@ResponseBody
	public int idCheck(HttpServletRequest request,
					   HttpServletResponse response,
					   Model model,
					   MemberDTO mdto) {
		  int cnt = 0;
		    if(mdto.getM_id()!=null) {							// 아이디가 null이 아니면 
		    	cnt = memberService.idCheck(mdto.getM_id());	//idCheck() 리턴 의 값을 cnt에 넣음
		    }
		  return cnt;
	  }
	
	@RequestMapping("login")							// login 버튼 누르면 Login 페이지로 이동
	public String login(HttpServletRequest request,
						HttpServletResponse response,
						MemberDTO mdto,
						Model model) {
		model.addAttribute("contentsJsp", "custom/member/Login");
		return "Main";
		
	}

	@RequestMapping("loginProc")						// 로그인
	public String loginProc(HttpServletRequest request,
							HttpServletResponse response,
							MemberDTO mdto,
							Model model) {
		
		HttpSession session = request.getSession();			// 현재 세션값 불러와서 session 객체에 넣고
		MemberDTO sdto = memberService.getMember(mdto);		// MemberDTO sdto 객체 생성 후 getMember()의 결과 값을 넣음
		String url="/";
	    String msg;
		if(sdto!=null) {								
		//회원 맞음
			url="/";
			MemberDTO ssKey = new MemberDTO();				
			ssKey.setM_id(sdto.getM_id());					// 로그인 한 유저의 정보를 불러옴
			ssKey.setM_passwd(sdto.getM_passwd());
			ssKey.setM_name(sdto.getM_name());
			ssKey.setM_role(sdto.getM_role());
		    msg =  sdto.getM_name()+"님 반값습니다.!!";
			session.setAttribute("ssKey", ssKey);			//로그인한 유저의 세션을 저장
		} else msg="아이디 또는 패스워드 맞지 않습니다.";				// 로그인 실패 시 메시지 출력
			
		model.addAttribute("msg",msg);						// 메시지 저장
		model.addAttribute("url", url);						// URL 저장
		
		return "MsgPage";
	}
	 
}
