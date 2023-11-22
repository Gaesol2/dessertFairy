package com.shop.dessertFairy.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dessertFairy.common.Page;
import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.member.dao.MemberDAO;
import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.review.dao.ReviewDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	ReviewDAO reviewDao;
	
	@Override
	public int memberJoin(MemberDTO mdto) {			//회원가입
		return memberDao.memberJoin(mdto);
	}
	
	@Override
	public int idCheck(String m_id) {			// 회원가입 시 아이디 중복 체크
		return memberDao.idCheck(m_id);
	}
	
	@Override
	public MemberDTO getMember(MemberDTO mdto) {	// 로그인
		return memberDao.getMember(mdto);
	}

	@Override
	public int memUpProc(MemberDTO mdto) {
		
		return memberDao.memUpProc(mdto);
	}

	@Override
	public int memDelete(MemberDTO mdto) {
		
		return memberDao.memDelete(mdto);
	}

	@Override
	public Map<String, Object> getMembers(MemberDTO mdto, PageDTO pdto) {	//admin 전체 회원수와 회원리스트
		
		Map<String, Object> resultSet = new HashMap<String, Object>();	// map으로 결과를 담음
		int cnt = memberDao.memberTot();
		pdto = Page.page(cnt, pdto);			//페이지 계산
	    mdto.setStart(pdto.getStart());
	    mdto.setEnd(pdto.getEnd());
		//전체 회원수
		List<MemberDTO> members = memberDao.getMembers(mdto);			// 전체 회원 리스트
		resultSet.put("pdto", pdto);							// map 키와 값 저장
		resultSet.put("memberTot", cnt);							// map 키와 값 저장
		resultSet.put("members", members);		
		// map 키와 값 저장
		return resultSet;
	}

	@Override
	public MemberDTO getMemberDetail(String m_id) {					//admin 멤버 디테일 정보
		return memberDao.getMemberDetail(m_id);
	}

	@Override
	public int updatePasswd(MemberDTO mdto) {		// 회원 비밀번호 재설정
		return memberDao.updatePasswd(mdto);
	}

	@Override
	public String searchId(MemberDTO mdto) {		// 회원 아이디 찾기
		return memberDao.searchId(mdto);
	}

	@Override
	public String answerSearch(MemberDTO mdto) {		//비밀번호 찾기
		return memberDao.answerSearch(mdto);
	}

	@Override
	public String questSearch(String m_id) {   // 비밀번호 찾기 - 아이디 검증
		return memberDao.questSearch(m_id);
	}

}
