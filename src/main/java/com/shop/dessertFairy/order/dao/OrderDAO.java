package com.shop.dessertFairy.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.dessert.dto.DessertDTO;
import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.order.dto.OrderDTO;

@Mapper
public interface OrderDAO {

	int insertOrder(List<OrderDTO> list);


	List<OrderDTO> getOrderList(OrderDTO odto);			// 주문 목록

	List<OrderDTO> getAdminOrderList(OrderDTO odto);	// admin 주문 목록
	
	List<OrderDTO> getAdminCakeOrderList(OrderDTO odto);	// admin cake주문 목록

	void updateOrderState(List<OrderDTO> list);			// admin 주문 목록페이지에서 상태 수정

	List<OrderDTO> OrderDetail(OrderDTO odto);				// admin 주문 상세

	void updateOrder(OrderDTO odto);					// admin 주문수정

	OrderDTO memOrderDetail(OrderDTO odto);				//admin 고객관리-주문상세

	int MUpdateOrder(OrderDTO odto);					//admin 고객관리-주문수정

	List<OrderDTO> getTotalPrice(OrderDTO odto);

	void updateTotalPrice(List<OrderDTO> getTotalPrice);

	int getRecentOno();

	OrderDTO getOrderDetail(OrderDTO odto);

	int getOrderDetailCnt(OrderDTO odto);
	
	void orderCancel(OrderDTO odto);				//admin 주문 취소

	List<OrderDTO> cancelDessert(OrderDTO odto);				//admin 주문 취소후 재고 판매량 재조정

	void dessertMgt(OrderDTO dList);

	void payAfterState(OrderDTO odto);
	
	List<OrderDTO> getCakeOrderList(OrderDTO odto);

	void reivew(OrderDTO odto);

	List<Integer> orderCheck(MemberDTO custom);
}
