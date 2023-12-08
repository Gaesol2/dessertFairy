package com.shop.dessertFairy.pay.web;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dessertFairy.cake.dto.CakeDTO;
import com.shop.dessertFairy.order.dto.OrderDTO;
import com.shop.dessertFairy.order.service.OrderService;
import com.shop.dessertFairy.pay.service.PayService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class RestPayController {
	
	@Autowired
	PayService payService;

	@Autowired
	OrderService orderService;
	
	@RequestMapping("/payOrder")
	public Map<String,Object> payOrder(HttpServletRequest request, HttpServletResponse response,
			Model model, OrderDTO odto, CakeDTO cdto){
		
		//주문요청 API 호출
		String orderNumber=null;
		String amount=null;
		String itemName=null;
		String userName=null;
		
		if(cdto.getC_no()!=0) {
			orderNumber = String.valueOf(cdto.getC_no());
			amount = String.valueOf(cdto.getC_price());
		} 
		if(odto.getO_totalprice()!=0) { 
			orderNumber = String.valueOf(odto.getO_no());
			amount = String.valueOf(odto.getO_totalprice());
		}
		
		itemName = odto.getD_name();
		userName = odto.getM_id();
		String merchantId = "himedia";
		String userAgent = "WP";
		String returnUrl = "returnUrl";
		String signature = "";
		String timestamp= "20231201000000";
		String cashbillYn = "N";
		String url = "";
		String pay = request.getParameter("pay");
		
		
		try {
			signature = payService.getSHA256Hash(merchantId + "|" + orderNumber + "|" + amount + "|" + "ac805b30517f4fd08e3e80490e559f8e" + "|" + timestamp);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		if("auth".equals(pay)) {
			url = "https://api.testpayup.co.kr/ap/api/payment/" + merchantId + "/order";
			System.out.println("일반결제");
		} else {
			url = "https://api.testpayup.co.kr/ep/api/kakao/"+merchantId+"/order";
			System.out.println("카카오 결제");
		}
		
		//api 통신 서비스 만들기
		Map<String,String> map = new HashMap<>();
		map.put("merchantId", merchantId);
		map.put("orderNumber", orderNumber);
		map.put("amount", amount);
		map.put("itemName", itemName);
		map.put("userName", userName);
		map.put("userAgent", userAgent);
		map.put("returnUrl", returnUrl);
		map.put("signature", signature);
		map.put("timestamp", timestamp);
		map.put("cashbillYn", cashbillYn);
		
		Map<String,Object> orderResult = payService.JsonApi(url, map);
		orderResult.put("pay", pay);
		
		model.addAttribute("odto", odto);
		return orderResult;
	}
}
