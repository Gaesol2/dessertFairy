package com.shop.dessertFairy.wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.member.service.MemberService;

@Service("memberWrapper")
public class MemberWrapper {
	
	@Autowired
	MemberService memberService;
	
//	@Autowired
//	OrderService orderService;

	@Transactional
	public int memDelete(MemberDTO custom) {
		int redata = 0;
//	boolean r = orderService.deleteOrder(custom);
//	if(r) {
//	   redata = memberService.memDelete(custom);
//	}else {
//		redata=0;
//	}
	redata = memberService.memDelete(custom);
	return redata;
	}

}
