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
	
	@Override
	public int idCheck(String m_id) {
		return memberDao.idCheck(m_id);
	}
	
	@Override
	public MemberDTO getMember(MemberDTO mdto) {
		return memberDao.getMember(mdto);
	}

}
