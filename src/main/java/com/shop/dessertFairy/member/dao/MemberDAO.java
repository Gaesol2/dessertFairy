package com.shop.dessertFairy.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.member.dto.MemberDTO;


@Mapper
public interface MemberDAO {

	int memberJoin(MemberDTO mdto);

//	MemberDTO getMember();


}
