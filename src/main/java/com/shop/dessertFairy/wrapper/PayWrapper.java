package com.shop.dessertFairy.wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dessertFairy.order.service.OrderService;
import com.shop.dessertFairy.pay.service.PayService;

@Service("PayWrapper")
public class PayWrapper {

	@Autowired
	OrderService orderService;
	
	@Autowired
	PayService payService;
	
	public String 
}
