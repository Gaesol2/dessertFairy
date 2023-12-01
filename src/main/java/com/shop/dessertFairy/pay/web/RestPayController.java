package com.shop.dessertFairy.pay.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestPayController {

	
	
	@RequestMapping("/payOrder")
	public Map<String,Object> payOrder(){
		
		Map<String, Object> map = new HashMap<>();
		
		
		map.put("id", "id");
		
		return map;
	}
}
