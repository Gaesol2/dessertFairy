package com.shop.dessertFairy.pay.web;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
			Model model, OrderDTO odto){
		
		System.out.println(model.toString());
		System.out.println(odto.getO_amount());
		
		//주문요청 API 호출
		String merchantId = "himedia";
		String orderNumber = String.valueOf(odto.getO_no());
		String amount = String.valueOf(odto.getO_totalprice());
		String itemName = odto.getD_name();
		String userName = odto.getM_id();
		String userAgent = "WP";
		String returnUrl = "returnUrl";
		String signature = "";
		String timestamp= "20231201000000";
		String cashbillYn = "N";
		String url = "";
		
		System.out.println("ono========="+orderNumber);
		System.out.println("top========="+amount);
		System.out.println("usn========="+userName);
		
		try {
			signature = payService.getSHA256Hash(merchantId + "|" + orderNumber + "|" + amount + "|" + "ac805b30517f4fd08e3e80490e559f8e" + "|" + timestamp);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		if("auth".equals(request.getParameter("pay"))) {
			url = "https://api.testpayup.co.kr/ap/api/payment/" + merchantId + "/order";
		} else {
			url = "https://api.testpayup.co.kr/ep/api/kakao/"+merchantId+"/order";
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
		
		model.addAttribute("orderResult", orderResult);
		
		return orderResult;
	}
}
