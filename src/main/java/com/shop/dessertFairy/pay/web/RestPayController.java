package com.shop.dessertFairy.pay.web;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dessertFairy.pay.service.PayService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class RestPayController {
	
	@Autowired
	PayService payService;

	@RequestMapping("/payOrder")
	public Map<String,Object> payOrder(Model model){
		
		//주문요청 API 호출
		String merchantId = "himedia";
		String orderNumber = "Test1234";
		String amount = "1000";
		String itemName = "테스트 상품";
		String userName = "테스터";
		String userAgent = "WP";
		String returnUrl = "returnUrl";
		String signature = "";
		String timestamp= "20231130010101";
		
		try {
			signature = payService.getSHA256Hash(merchantId + "|" + orderNumber + "|" + amount + "|" + "ac805b30517f4fd08e3e80490e559f8e" + "|" + timestamp);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		//api 통신 서비스 만들기
		
		String url = "https://api.testpayup.co.kr/ap/api/payment/" + merchantId + "/order";
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
		
		Map<String,Object> orderResult = payService.JsonApi(url, map);
		
		model.addAttribute("orderResult", orderResult);
		
		return orderResult;
	}
}
