package com.shop.dessertFairy.member.service;

import java.util.List;
import java.util.Map;

import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.review.dto.ReviewDTO;

public interface MemberService {

	int memberJoin(MemberDTO mdto);		// 회원가입

	int idCheck(String m_id);			// 회원가입 시 아이디 중복체크

	MemberDTO getMember(MemberDTO mdto);		// 로그인

	int memUpProc(MemberDTO mdto);

	int memDelete(MemberDTO custom);

	Map<String, Object> getMembers(MemberDTO mdto, PageDTO pageDto);	//admin 전체 회원수와 회원리스트

	MemberDTO getMemberDetail(String m_id);							//admin 멤버 디테일 정보

	int updatePasswd(MemberDTO mdto);			// 회원 비밀번호 찾기 재설정

	String searchId(MemberDTO mdto);			// 회원 아이디 찾기

	String searchPw(MemberDTO mdto);




}
