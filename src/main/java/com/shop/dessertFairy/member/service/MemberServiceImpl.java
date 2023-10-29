package com.shop.dessertFairy.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.shop.dessertFairy.member.dao.MemberDAO;
import com.shop.dessertFairy.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDao;
	@Override
	public int memberJoin(MemberDTO mdto) {
		return memberDao.memberJoin(mdto);
	}
	/*
	 * @Autowired MemberDAO memberDao;
	 * 
	 * @Override public MemberDTO getMember() { // TODO Auto-generated method stub
	 * return memberDao.getMember(); }
	 */

}
