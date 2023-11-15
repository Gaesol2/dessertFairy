package com.shop.dessertFairy.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.order.dto.OrderDTO;

@Mapper
public interface OrderDAO {

	int insertOrder(List<OrderDTO> list);

	int getOrderCnt(OrderDTO odto);

	List<OrderDTO> getOrderList(OrderDTO odto);

	List<OrderDTO> getAdminOrderList(OrderDTO odto);

	void updateOrderState(List<OrderDTO> list);

}
