package com.shop.dessertFairy.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.order.dto.OrderDTO;

@Mapper
public interface OrderDAO {

	int insertOrder(List<OrderDTO> list);


	List<OrderDTO> getOrderList(OrderDTO odto);			// 주문 목록

	int getMemOrderCnt(OrderDTO odto);					//회원 총 주문 건수

	int getOrderCnt(OrderDTO odto);						// admin 주문 총 건수

	List<OrderDTO> getAdminOrderList(OrderDTO odto);	// admin 주문 목록

	void updateOrderState(List<OrderDTO> list);			// admin 주문 목록페이지에서 상태 수정

	OrderDTO OrderDetail(OrderDTO odto);				// admin 주문 상세

	void updateOrder(OrderDTO odto);					// admin 주문수정

	OrderDTO memOrderDetail(OrderDTO odto);


}
