package com.shop.dessertFairy.wrapper;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dessertFairy.dessert.service.DessertService;
import com.shop.dessertFairy.order.dto.OrderDTO;
import com.shop.dessertFairy.order.service.OrderService;

@Service("orderWrapper")
public class OrderWrapper {

	@Autowired
	DessertService dessertService;
	
	@Autowired
	OrderService orderService;
	
	public Hashtable<Integer, OrderDTO> orderProc(OrderDTO odto, Hashtable<Integer, OrderDTO> hCartList) {
		
		// 재고 수 감소
		dessertService.updateStocks(hCartList);
		
		//주문 insert
		int r = orderService.insertOrder(hCartList);
		
		
		hCartList.clear();
		return hCartList;
	}
	
}
