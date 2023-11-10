package com.shop.dessertFairy.order.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		//iterKeys에 다음 요소가 있으면 list에 요소를 저장한다.
		while(iterKeys.hasNext()) {
			//순환 중인 key에 해당하는 hCartList의 value를 list에 저장한다.
			list.add(hCartList.get(iterKeys.next()));
		}
		
		return orderDao.insertOrder(list);
	}

}
