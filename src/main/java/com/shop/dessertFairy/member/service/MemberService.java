package com.shop.dessertFairy.member.service;

import com.shop.dessertFairy.member.dto.MemberDTO;

public interface MemberService {

	int memberJoin(MemberDTO mdto);		// 회원가입

	int idCheck(String m_id);			// 회원가입 시 아이디 중복체크

	MemberDTO getMember(MemberDTO mdto);		// 로그인

	int memUpProc(MemberDTO mdto);

	int memDelete(MemberDTO custom);

	/* MemberDTO getMember(); */


}
