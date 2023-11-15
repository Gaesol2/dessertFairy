package com.shop.dessertFairy.order.service;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Hashtable;
import java.util.Map;

import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.order.dto.OrderDTO;

public interface OrderService {
	public int insertOrder(Hashtable<Integer, OrderDTO> hCartList);

	public Map<String, Object> getOrderList(OrderDTO odto, PageDTO pdto);				// 주문 목록

	public Map<String, Object> getAdminOrderList(OrderDTO odto, PageDTO pdto);			// admin 주문 목록

	public void orderStateUpdate(ArrayList<String> tdArr);								//admin 주문 목록페이지에서 상태 수정

	public OrderDTO OrderDetail(OrderDTO odto);											//admin 주문 상세

	public void updateOrder(OrderDTO odto);												//admin 주문 수정

	
}
