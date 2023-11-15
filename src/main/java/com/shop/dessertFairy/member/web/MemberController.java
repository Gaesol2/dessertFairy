package com.shop.dessertFairy.member.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.member.service.MemberService;
import com.shop.dessertFairy.wrapper.MemberWrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	private static final Logger logger 
	= LoggerFactory.getLogger(MemberController.class);
	@Autowired
	MemberService memberService;
	
	@Autowired
	MemberWrapper memberWrapper;
	
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
		String msg = null;
		String url = null;
		
		int r = memberService.memberJoin(mdto);				// memberService 인터페이스의 memberJoin(mdto) 메소드 호출
		if(r>0) {
			msg = "회원가입 성공";
			url = "/";
		}
		else {
			msg = "회원가입 실패";
			url = "redirect:register";
		}
		 model.addAttribute("msg", msg);
		 model.addAttribute("url", url);
		
		return "MsgPage";
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
			MemberDTO ssKey = new MemberDTO();				
			ssKey.setM_id(sdto.getM_id());					// 로그인 한 유저의 정보를 불러옴
			ssKey.setM_passwd(sdto.getM_passwd());
			ssKey.setM_name(sdto.getM_name());
			ssKey.setM_role(sdto.getM_role());
		    msg =  sdto.getM_name()+"님 반갑습니다.!!";
			session.setAttribute("ssKey", ssKey);			//로그인한 유저의 세션을 저장
		} else msg="아이디 또는 패스워드 맞지 않습니다.";				// 로그인 실패 시 메시지 출력
			
		model.addAttribute("msg",msg);						// 메시지 저장
		model.addAttribute("url", url);						// URL 저장
		
		return "MsgPage";
	}
	
	@RequestMapping("/logoutProc")
	public String logoutProc(HttpServletRequest request,
			HttpServletResponse response,
			MemberDTO mdto,
			Model model) {
		//세션 정보 (ssKey) - 회원정보
		HttpSession session = request.getSession();
         session.invalidate();								// 세션 삭제
        return "redirect:/";
	}
	
	@RequestMapping("/myPage")
	public String myPage(HttpServletRequest request,
			HttpServletResponse response,
			Model model) {
		// info
	      // 세션 키에 데이터를 갖고 있고 그 데이터를 불러와서 해당되는 고객의 정보를 가져오고
	      HttpSession session = request.getSession();
	      MemberDTO custom = (MemberDTO) session.getAttribute("ssKey");
	      // 데이터베이스에서 해당되는 mdto에 있는 정보를 가지고 해당 고객 정보 가져오기
	      // 저장해서 화면에서 가져올 수 있도록 한다.
	     
	      String page = null;
	      String msg = null;
	      String url = null;
	      if(custom!=null) {
	         MemberDTO mdto = memberService.getMember(custom);
	         model.addAttribute("mdto", mdto);
	         model.addAttribute("contentsJsp", "custom/mypage/MyPage");
	         // 회원정보를 갖고 있는 페이지 
	         page = "Main";
	      }else {
	         msg = "로그인 먼저 필요합니다.";
	         url = "/login";
	         model.addAttribute("msg", msg);
	         model.addAttribute("url", url);
	         page = "MsgPage";
	      }
	      session.setAttribute("ssKey", custom);
	      // 모든 상품 리스트를 갖고 오기 --getProductList 
	      return page;
	   }
	
		@RequestMapping("/pwCheck")
		   public String pwCheck(HttpServletRequest request, Model model) {
		      HttpSession session = request.getSession();
		      MemberDTO mdto = (MemberDTO) session.getAttribute("ssKey");
		      
		      return "custom/member/Pwcheck";
		   }
		
		 @RequestMapping("/memUpForm")
		   public String memUpForm(HttpServletRequest request, HttpServletResponse response, Model model) {
		      // session정보 갖고오기
		      HttpSession session = request.getSession();
		      MemberDTO custom = (MemberDTO) session.getAttribute("ssKey");
		      // 세션정보를 기준으로 회원 정보 가져오기
		      String page = null;
		      String msg = null;
		      String url = null;
		      if(custom!=null) {
		         MemberDTO mdto = memberService.getMember(custom);
		         model.addAttribute("mdto", mdto);
		         model.addAttribute("contentsJsp", "custom/member/MemberUpForm");
		         page = "Main";
		      }else {
		         msg = "로그인 먼저 필요합니다.";
		         url = "/login";
		         model.addAttribute("msg", msg);
		         model.addAttribute("url", url);
		         page = "MsgPage";
		      }
		      session.setAttribute("ssKey", custom);
		      return page;
		   }
		
		 @RequestMapping("/memUpProc")
		   public String memUpProc(HttpServletRequest request, 
				                   HttpServletResponse response, 
				                   Model model, 
				                   MemberDTO mdto) {
		      // session정보 갖고오기
		      HttpSession session = request.getSession();
		      MemberDTO custom = (MemberDTO) session.getAttribute("ssKey");
		      // 세션정보를 기준으로 회원 정보 가져오기
		      String page = null;
		      String msg = null;
		      String url = null;
		      if(custom!=null) {
		         int r = memberService.memUpProc(mdto);
		         if(r>0) {
		            msg = "회원정보가 수정되었습니다.\\n 재로그인이 필요합니다.";
		            session.invalidate();
		         }
		         else msg = "수정되지 않았습니다. \\n 관리자에게 문의바랍니다.";
		         url = "/";
		      }else {
		         msg = "로그인 먼저 필요합니다.";
		         url = "/login";
		      }
		      page = "MsgPage";
		      model.addAttribute("msg", msg);
		      model.addAttribute("url", url);
		   
		      return page;
		   }
		 
		 @RequestMapping("/memDelete")
		   public String memDelete(HttpServletRequest request, 
				                   HttpServletResponse response, 
				                   Model model, MemberDTO mdto) {
		      // session정보 갖고오기
		      HttpSession session = request.getSession();
		      MemberDTO custom = (MemberDTO) session.getAttribute("ssKey");
		      // 세션정보를 기준으로 회원 정보 가져오기
		      String page = null;
		      String msg = null;
		      String url = null;
		      if(custom!=null) {
		         int r = memberWrapper.memDelete(custom);
		         if(r>0) {
		            msg = "회원탈퇴 처리 되었습니다";
		            session.invalidate(); //세션삭제
		         }
		         else {
		        	 msg = "탈퇴할 수 없습니다 \\n 관리자에게 문의바랍니다.";
		         }
		         url = "/";
		      }else {
		         msg = "로그인 먼저 필요합니다.";
		         url = "/login";
		      }
		      page = "MsgPage";
		      model.addAttribute("msg", msg);
		      model.addAttribute("url", url);
		   
		      return page;
		   }
		 
		 //검색
		 
		 @RequestMapping("/memberIdSearch") //아이디 찾기 폼
		   public String MemberIdSearch(HttpServletRequest request, 
				                   HttpServletResponse response, 
				                   Model model, 
				                   MemberDTO mdto) {
		   
			 model.addAttribute("contentsJsp", "custom/member/MemberIdSearch");
		      return "Main";
		   }
		 
		 @RequestMapping("/memberPwSearch")  //비밀번호 찾기 폼
		 public String MemberPwSearch(HttpServletRequest request, 
				 HttpServletResponse response, 
				 Model model, 
				 MemberDTO mdto) {
			 
			 model.addAttribute("contentsJsp", "custom/member/MemberPwSearch");
			 return "Main";
		 }
		 
		 @RequestMapping("/pwSearchForm") //비밀번호 변경하기 폼
		 public String PwSearchForm(HttpServletRequest request, 
				 HttpServletResponse response, 
				 Model model, 
				 MemberDTO mdto) {
			 
			 model.addAttribute("contentsJsp", "custom/member/MemberPwChange");
			 return "Main";
		 }
		 

		 @RequestMapping("/memberIdSearchProc") //아이디 찾기 proc
		 public String MemberIdSearchProc(HttpServletRequest request, 
				 HttpServletResponse response, 
				 Model model, 
				 MemberDTO mdto) {
			 
			 int result = 0;
			 String id = null;
			 String msg = null;
			 String url = "/";
			 
			 if(mdto != null) {
				 if(mdto.getM_id() != null) {
					 result = memberService.updatePasswd(mdto);
					
				 }else {
					 id = memberService.searchId(mdto);
					 if(id != null) { msg = "회원 아이디 :"+id;
					   url = "/";
					 } else msg = "회원정보가 없습니다.";
					 url = "/memberIdSearch";
				 }
			 }
			 
			 model.addAttribute("msg", msg);
			 model.addAttribute("url", url);
			 
			 return "MsgPage";
		 }
		 
		 
		 @RequestMapping("/memberPwSearchProc")	// 비밀번호 찾기 proc					
		 public String MemberPwSearchProc(HttpServletRequest request,
				 HttpServletResponse response,
				 MemberDTO mdto,
				 Model model) {
			 
			 int result = 0;
			 String msg = null;
			 String url = "/";
			 
				
			 int pw = memberService.searchPw(mdto);				// memberService 인터페이스의 memberJoin(mdto) 메소드 호출
			 if(pw >0) { 
				 msg = "비밀번호를 변경해주시길 바랍니다.";
				 url = "/pwSearchForm";
			 } else msg = "회원정보가 없습니다.";
			 url = "/memberPwSearch";
			 
			 
			 model.addAttribute("msg", msg);
			 model.addAttribute("url", url);
			 
			 return "MsgPage";
			 
		 }
			
		 
		 @RequestMapping("/memberSearchProc") //비밀번호 변경 proc
		 public String MemberPwSearchProc(HttpServletRequest request, 
				 HttpServletResponse response, 
				 Model model, 
				 MemberDTO mdto) {
			 
			 int result = 0;
			 String id = null;
			 String msg = null;
			 String url = "/";
			 
			 if(mdto != null) {
				 if(mdto.getM_id() != null) {
					 result = memberService.updatePasswd(mdto);
					 
					 if(result > 0) {
						 msg = "비밀번호가 변경되었습니다.";
					 }else msg = "비밀번호 변경 실패. 관리자에게 문의하세요";
					 		url = "memberPwSearch";
				 }else {
					 id = memberService.searchId(mdto);
					 if(id != null) msg = "회원 아이디 :"+id;
					 else msg = "회원정보가 없습니다.";
					 url = "/memberPwSearch";
				 }
			 }
			 
			 model.addAttribute("msg", msg);
			 model.addAttribute("url", url);
			 
			 return "MsgPage";
		 }
		 
		}
	
	
