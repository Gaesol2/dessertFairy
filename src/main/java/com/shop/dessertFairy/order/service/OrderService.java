package com.shop.dessertFairy.order.service;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.dessert.dto.DessertDTO;
import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.order.dto.OrderDTO;

public interface OrderService {
	public int insertOrder(Hashtable<Integer, OrderDTO> hCartList);

	public Map<String, Object> getOrderList(OrderDTO odto);				// 주문 목록

	public Map<String, Object> getAdminOrderList(OrderDTO odto);			// admin 주문 목록
	
	public Map<String, Object> getAdminCakeOrderList(OrderDTO odto);			// admin cake주문 목록

	public void orderStateUpdate(ArrayList<String> tdArr);								//admin 주문 목록페이지에서 상태 수정

	public List<OrderDTO> OrderDetail(OrderDTO odto);											//admin 주문 상세

	public void updateOrder(OrderDTO odto);												//admin 주문 수정

	public OrderDTO memOrderDetail(OrderDTO odto);					//admin 고객관리-고객주문 상세

	public int MUpdateOrder(OrderDTO odto);							//admin 고객관리-고객주문 수정

	public void cancelOrder(OrderDTO odto);

	public int getRecentOno();

	public OrderDTO getOrderDetail(OrderDTO odto);

	public int getOrderDetailCnt(OrderDTO odto);

	public List<OrderDTO> cancelDessert(OrderDTO odto);		//admin 주문취소할 디저트 정보 받아옴
	
	public void dessertMgt(OrderDTO dList);					//admin 주문취소할 디저트 재고, 판매량 수정

	public void orderCancel(OrderDTO odto);					//admin 주문 취소

	public void payAfterState(OrderDTO odto);
	
	public Map<String, Object> getCakeOrderList(OrderDTO odto);

	public void review(OrderDTO odto);

	public void deleteOrder(OrderDTO odto);

	public List<Integer> orderCheck(MemberDTO custom);


	
}
