package com.shop.dessertFairy.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.member.dto.MemberDTO;


@Mapper
public interface MemberDAO {

	int memberJoin(MemberDTO mdto);		//회원가입

	int idCheck(String m_id);			// 회원가입시 아이디 중복

	MemberDTO getMember(MemberDTO mdto);	// 로그인

	int memUpProc(MemberDTO mdto); //회원정보수정

	int memDelete(MemberDTO mdto); //회원정보삭제

	int memberTot();				// admin 전체 회원수

	List<MemberDTO> getMembers(MemberDTO mdto);	//admin 회원리스트

	MemberDTO getMemberDetail(String m_id);	//admin 멤버 디테일 정보

	int updatePasswd(MemberDTO mdto);		// 회원 비밀번호 재설정

	String searchId(MemberDTO mdto);		// 회원 아이디 찾기

	String searchPw(MemberDTO mdto);

}
