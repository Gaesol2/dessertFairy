package com.shop.dessertFairy.order.service;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dessertFairy.common.Page;
import com.shop.dessertFairy.common.RowInterPage;
import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.dessert.dao.DessertDAO;
import com.shop.dessertFairy.order.dao.OrderDAO;
import com.shop.dessertFairy.order.dto.OrderDTO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO orderDao;
	
	@Autowired
	DessertDAO dessertDao;
	
	@Override
	public int insertOrder(Hashtable<Integer, OrderDTO> hCartList) {
		//int 타입의 Set(중복, 순서 불가능 집합)을 생성해 Hashtable hCartList의 key(o_no)들을 불러와 저장한다.
		Set<Integer> keys = hCartList.keySet();
		//콜렉션 순환 Iterator를 선언해서 Set keys를 순환시킨다.
		Iterator<Integer> iterKeys = keys.iterator();

		//결과를 저장하기 위해 Set keys에 저장된 key(o_no)의 개수만큼 크기의 list를 만든다.
		List<OrderDTO> list = new ArrayList<>(keys.size());
		
		//iterKeys에 다음 요소가 있으면 list에 요소를 저장한다.
		while(iterKeys.hasNext()) {
			//순환 중인 key에 해당하는 hCartList의 value를 list에 저장한다.
			list.add(hCartList.get(iterKeys.next()));
		}
		
		int r = orderDao.insertOrder(list);
		
		int ono = orderDao.getRecentOno();
		OrderDTO odto = new OrderDTO();
		odto.setO_no(ono);
		List<OrderDTO> getTotalPrice = orderDao.getTotalPrice(odto);
		orderDao.updateTotalPrice(getTotalPrice);
		
		return r;
	}

	@Override
	public Map<String, Object> getOrderList(OrderDTO odto) {			// 주문 목록

		Map<String, Object> resultSet = new HashMap<String, Object>();
		
		   
		   List<OrderDTO> getTotalPrice = orderDao.getTotalPrice(odto);
			orderDao.updateTotalPrice(getTotalPrice);
		   
		   List<OrderDTO> orderList = orderDao.getOrderList(odto);
		   
		   resultSet.put("orderList", orderList);
		   
		return resultSet;
	}

	@Override
	public Map<String, Object> getAdminOrderList(OrderDTO odto) {				// admin 주문목록
		Map<String, Object> resultSet = new HashMap<String, Object>();
	   
		List<OrderDTO> getTotalPrice = orderDao.getTotalPrice(odto);
		orderDao.updateTotalPrice(getTotalPrice);
		
		
	   List<OrderDTO> adminOrderList = orderDao.getAdminOrderList(odto);
	   resultSet.put("adminOrderList", adminOrderList);
	   
	   return resultSet;
	}

	@Override
	public void orderStateUpdate(ArrayList<String> tdArr) {				// admin 주문 목록페이지에서 상태 수정

		List<OrderDTO> list = new ArrayList<OrderDTO>();
		
		for(int i=0; i < tdArr.size(); i += 4) {
			OrderDTO odto = new OrderDTO();
	   		int n=0, no=0;
	   		String mid=null;
	   		String state = null;
	   		
			n =tdArr.get(i).indexOf(":");
			no = Integer.parseInt(tdArr.get(i).substring(n+1));
			odto.setO_no(no);
			  
			n =tdArr.get(i+1).indexOf(":");
			no = Integer.parseInt(tdArr.get(i+1).substring(n+1));
			odto.setD_no(no);
			 
			n =tdArr.get(i+2).indexOf(":");
			mid = tdArr.get(i+2).substring(n+1);
			odto.setM_id(mid);
			  
			n =tdArr.get(i+3).indexOf(":");
			state = tdArr.get(i+3).substring(n+1);
			odto.setO_state(state);
			list.add(odto);
		}
		
		orderDao.updateOrderState(list);
	}

	@Override
	public List<OrderDTO> OrderDetail(OrderDTO odto) {			// admin  주문 상세
		List<OrderDTO> DetailList = new ArrayList<>();
		DetailList = orderDao.OrderDetail(odto);
		
		return DetailList;
	}

	@Override
	public void updateOrder(OrderDTO odto) {			// admin 주문 수정
		orderDao.updateOrder(odto);
	}

	@Override
	public OrderDTO memOrderDetail(OrderDTO odto) {		//admin 고객관리-주문상세
		return orderDao.memOrderDetail(odto);
	}

	@Override
	public int MUpdateOrder(OrderDTO odto) {			// admin 고객관리-주문수정
		return orderDao.MUpdateOrder(odto);
	}

	@Override
	public void cancelOrder(OrderDTO odto) {
		orderDao.cancelOrder(odto);
		
	}

	@Override
	public int getRecentOno() {
		return orderDao.getRecentOno();
	}

	@Override
	public OrderDTO getOrderDetail(OrderDTO odto) {
		return orderDao.getOrderDetail(odto);
	}

	@Override
	public int getOrderDetailCnt(OrderDTO odto) {
		return orderDao.getOrderDetailCnt(odto);
	}

	@Override
	public Map<String, Object> getAdminCakeOrderList(OrderDTO odto) {				// admin 주문목록
		Map<String, Object> resultSet = new HashMap<String, Object>();
	   
		List<OrderDTO> getTotalPrice = orderDao.getTotalPrice(odto);
		orderDao.updateTotalPrice(getTotalPrice);
		
		
	   List<OrderDTO> adminCakeOrderList = orderDao.getAdminCakeOrderList(odto);
	   resultSet.put("adminCakeOrderList", adminCakeOrderList);
	   
	   return resultSet;
	}
	
	@Override
	public void orderCancel(OrderDTO odto) {
      
      orderDao.orderCancel(odto);
   }

	@Override
	public void dessertMgt(OrderDTO odto) {
		orderDao.dessertMgt(odto);
		
	}

	@Override
	public void payAfterState(OrderDTO odto) {
		orderDao.payAfterState(odto);
	}
	
	public Map<String, Object> getCakeOrderList(OrderDTO odto) {
		Map<String, Object> resultSet = new HashMap<String, Object>();
		   
		List<OrderDTO> getTotalPrice = orderDao.getTotalPrice(odto);
		orderDao.updateTotalPrice(getTotalPrice);
		
		
	   List<OrderDTO> CakeOrderList = orderDao.getCakeOrderList(odto);
	   resultSet.put("CakeOrderList", CakeOrderList);
	   
	   return resultSet;
	}

}
