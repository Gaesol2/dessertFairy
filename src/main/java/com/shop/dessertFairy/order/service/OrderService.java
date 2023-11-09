package com.shop.dessertFairy.order.service;

import java.util.HashMap;
import java.util.Hashtable;

import com.shop.dessertFairy.order.dto.OrderDTO;

public interface OrderService {
	public int insertOrder(Hashtable<Integer, OrderDTO> hCartList);
	
}
