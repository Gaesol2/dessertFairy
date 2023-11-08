package com.shop.dessertFairy.wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dessertFairy.dessert.service.DessertService;
import com.shop.dessertFairy.order.service.OrderService;

@Service("orderWrapper")
public class OrderWrapper {

	@Autowired
	DessertService dessertService;
	
	@Autowired
	OrderService orderService;
	
	public String orderProc() {
		
		return null;
	}
	
}
