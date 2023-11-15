package com.shop.dessertFairy.order.service;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Hashtable;
import java.util.Map;

import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.order.dto.OrderDTO;

public interface OrderService {
	public int insertOrder(Hashtable<Integer, OrderDTO> hCartList);

	public Map<String, Object> getOrderList(OrderDTO odto, PageDTO pdto);

	public Map<String, Object> getAdminOrderList(OrderDTO odto, PageDTO pdto);

	public void orderStateUpdate(ArrayList<String> tdArr);

	
}
