package com.shop.dessertFairy.member.service;

import com.shop.dessertFairy.member.dto.MemberDTO;

public interface MemberService {

	int memberJoin(MemberDTO mdto);

	int idCheck(String m_id);

	MemberDTO getMember(MemberDTO mdto);

	/* MemberDTO getMember(); */


}
