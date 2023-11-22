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
import com.shop.dessertFairy.order.dao.OrderDAO;
import com.shop.dessertFairy.order.dto.OrderDTO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO orderDao;
	
	@Override
	public int insertOrder(Hashtable<Integer, OrderDTO> hCartList) {
		//int 타입의 Set(중복, 순서 불가능 집합)을 생성해 Hashtable hCartList의 key(o_no)들을 불러와 저장한다.
		Set<Integer> keys = hCartList.keySet();
		//콜렉션 순환 Iterator를 선언해서 Set keys를 순환시킨다.
		Iterator<Integer> iterKeys = keys.iterator();

		//결과를 저장하기 위해 Set keys에 저장된 key(o_no)의 개수만큼 크기의 list를 만든다.
		List<OrderDTO> list = new ArrayList<>(keys.size());
		
		System.out.println("카트============="+hCartList);

		//iterKeys에 다음 요소가 있으면 list에 요소를 저장한다.
		while(iterKeys.hasNext()) {
			//순환 중인 key에 해당하는 hCartList의 value를 list에 저장한다.
			list.add(hCartList.get(iterKeys.next()));
		}
		System.out.println("list============="+list);
		
		return orderDao.insertOrder(list);
	}

	@Override
	public Map<String, Object> getOrderList(OrderDTO odto, PageDTO pdto) {			// 주문 목록

		Map<String, Object> resultSet = new HashMap<String, Object>();
		
		int cnt = orderDao.getMemOrderCnt(odto);
		   pdto = Page.page(cnt, pdto);
		   odto.setStart(pdto.getStart());
		   odto.setEnd(pdto.getEnd());
		   
		   List<OrderDTO> orderList = orderDao.getOrderList(odto);
		   
		   resultSet.put("pdto", pdto);
		   resultSet.put("cnt", cnt);
		   resultSet.put("orderList", orderList);
		   
		return resultSet;
	}

	@Override
	public Map<String, Object> getAdminOrderList(OrderDTO odto, PageDTO pdto) {				// admin 주문목록
		Map<String, Object> resultSet = new HashMap<String, Object>();
		int cnt = orderDao.getOrderCnt(null);						// admin 전체 주문 건수
		pdto = Page.page(cnt, pdto);
		odto.setStart(pdto.getStart());
		odto.setEnd(pdto.getEnd());
		
	   
	   List<OrderDTO> adminOrderList = orderDao.getAdminOrderList(odto);
	   resultSet.put("pdto", pdto);
	   resultSet.put("oCnt", cnt);
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
	public OrderDTO OrderDetail(OrderDTO odto) {			// admin  주문 상세
		return orderDao.OrderDetail(odto);
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


}
