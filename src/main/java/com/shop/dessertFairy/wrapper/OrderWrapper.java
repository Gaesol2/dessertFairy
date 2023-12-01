package com.shop.dessertFairy.wrapper;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dessertFairy.dessert.service.DessertService;
import com.shop.dessertFairy.order.dto.OrderDTO;
import com.shop.dessertFairy.order.service.OrderService;
import com.shop.dessertFairy.pay.dto.PayDTO;
import com.shop.dessertFairy.pay.service.PayService;

@Service("orderWrapper")
public class OrderWrapper {

	@Autowired
	DessertService dessertService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	PayService payService;
	
	public Hashtable<Integer, OrderDTO> orderProc(OrderDTO odto, Hashtable<Integer, OrderDTO> hCartList) {
		
		// 재고 수 감소
		dessertService.updateStocks(hCartList);
		
		//주문 insert
		int r = orderService.insertOrder(hCartList);
		
		hCartList.clear();
		return hCartList;
	}

	public void orderCancel(OrderDTO odto) {
		
		// d_stock, d_sale 복원 
		dessertService.cancelStocks(odto);
		
		// 주문 삭제
		orderService.cancelOrder(odto);
		
	}
	
	public OrderDTO getOrderDetail(OrderDTO odto) {
		
		//주문 내용
		OrderDTO orderDetail = orderService.getOrderDetail(odto);
		
		//주문에 들은 전체 상품 개수
		int orderCnt = orderService.getOrderDetailCnt(odto)-1;
		
		String dname = dessertService.getDname(orderDetail.getD_no());
		
		if(orderCnt>=1) {
			orderDetail.setD_name(dname + " 외 " + orderCnt);
		} else {
			orderDetail.setD_name(dname);
		}
		
		return orderDetail;
	}
	
}
