package com.shop.dessertFairy.pay.web;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.order.dto.OrderDTO;
import com.shop.dessertFairy.order.service.OrderService;
import com.shop.dessertFairy.pay.dto.PayDTO;
import com.shop.dessertFairy.pay.service.PayService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class PayController {

	@Autowired
	PayService payService;
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/authPay")
	public String pay(HttpServletRequest request, HttpServletResponse response,
			Model model, PayDTO payDto, OrderDTO odto) {

		//세션 받아와서 저장
	      HttpSession session = request.getSession();
	      MemberDTO sdto = (MemberDTO) session.getAttribute("ssKey");
	      
	      String msg = null;
	      String url = null;
	      String page = null;
	      String contentsJsp = null;
	      
	      if(sdto==null) {
	         msg = "로그인이 필요합니다.";
	         url = "login";
	         page = "MsgPage";
	         
	      } else {
	         
	    	int result = 0;
	    	
	    	String ordr_idxx = payDto.getOrdr_idxx();
	  		String res_cd = payDto.getRes_cd();
	  		String res_msg = payDto.getRes_msg();
	  		String enc_data = payDto.getEnc_data();
	  		String enc_info = payDto.getEnc_info();
	  		String tran_cd = payDto.getTran_cd();
	  		String buyr_mail = payDto.getBuyr_mail();
	  		String userId = payDto.getUserId();

	  		String payUrl = "https://api.testpayup.co.kr/ap/api/payment/"+ ordr_idxx +"/pay";
	  		Map<String, String> map = new HashMap<>();
	  		
	  		map.put("res_cd",res_cd);
	  		map.put("res_msg",res_msg);
	  		map.put("enc_data",enc_data);
	  		map.put("enc_info",enc_info);
	  		map.put("tran_cd",tran_cd);
	  		map.put("buyr_mail",buyr_mail);
	  		map.put("userId",userId);
	  		
	  		Map<String,Object> orderResult = payService.JsonApi(payUrl, map);
	  		
	  		model.addAttribute("orderResult", orderResult);
	        
	        page = "Main";
	        contentsJsp = "custom/order/OrderDone";

	        payDto.setP_transactionid(String.valueOf(orderResult.get("transactionId")));
	        payDto.setP_ordernumber(String.valueOf(orderResult.get("orderNumber")));
	        payDto.setP_authdatetime(String.valueOf(orderResult.get("authDateTime")));
	        payDto.setP_amount(String.valueOf(orderResult.get("amount")));
	        payDto.setP_authnumber(String.valueOf(orderResult.get("authNumber")));
	        payDto.setP_cardname(String.valueOf(orderResult.get("cardName")));
	        payDto.setP_cardno(String.valueOf(orderResult.get("cardNo")));
	        payDto.setP_quota(String.valueOf(orderResult.get("quota")));
	        
	        result = payService.insertPay(payDto);
	        
	        if(result > 0) orderService.payAfterState(odto);
	      }
	  
	  
      
      //model.addAttribute("odto", odto);
	  model.addAttribute("msg", msg);
      model.addAttribute("url", url);
      model.addAttribute("contentsJsp",contentsJsp);
      session.setAttribute("ssKey", sdto);
      
      return page;
	}
	
}
