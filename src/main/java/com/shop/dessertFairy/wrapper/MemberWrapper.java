package com.shop.dessertFairy.wrapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.member.service.MemberService;
import com.shop.dessertFairy.order.service.OrderService;

@Service("memberWrapper")
public class MemberWrapper {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	OrderService orderService;

	@Transactional
	public boolean memDelete(MemberDTO custom) {
		List<Integer> orderState = new ArrayList<>();
		orderState = orderService.orderCheck(custom);
		System.out.println("결과 : "+orderState);
		if(orderState.size() > 0) {
			return false;
		}else {
			int result = memberService.memDelete(custom);
			if(result > 0) return true;
			else return false;
		}
		
	}

}
