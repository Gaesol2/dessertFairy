package com.shop.dessertFairy.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.member.dto.MemberDTO;


@Mapper
public interface MemberDAO {

	int memberJoin(MemberDTO mdto);		//회원가입

	int idCheck(String m_id);			// 회원가입시 아이디 중복

	MemberDTO getMember(MemberDTO mdto);	// 로그인

	int memUpProc(MemberDTO mdto); //회원정보수정

	int memDelete(MemberDTO mdto); //회원정보삭제

}
