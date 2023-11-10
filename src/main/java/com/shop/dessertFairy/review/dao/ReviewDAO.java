package com.shop.dessertFairy.review.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.review.dto.ReviewDTO;

@Mapper
public interface ReviewDAO {

	int getReviewCnt();
	
	List<ReviewDTO> getReviewList(ReviewDTO rdto);

	int reviewWrite(ReviewDTO rdto);

	ReviewDTO getReviewcontent(ReviewDTO rdto);
	
	int updateReadCnt(ReviewDTO rdto);

	List<ReviewDTO> getReviewListOrderby(Map<String, Object> map);

	List<ReviewDTO> getMyList(ReviewDTO rdto);

	int updateProc(ReviewDTO rdto);
	
	int deleteProc(ReviewDTO rdto);
	
	List<ReviewDTO> getReviewupform(ReviewDTO rdto);
	
	ReviewDTO getMycontent(ReviewDTO rdto);
	
	
	//어드민 시작

	List<ReviewDTO> getReplyList(ReviewDTO rdto);

	List<ReviewDTO> getReplycontent(ReviewDTO rdto);

	ReviewDTO getReplyContent(ReviewDTO rdto);

	int getReplyWrite(ReviewDTO rdto);

	int replyupProc(ReviewDTO rdto);

	int replydelProc(ReviewDTO rdto);

	int reviewTot(String m_id);							//admin 해당 회원의 전체 리뷰 수

	List<MemberDTO> getreviews(String m_id);	// admin해당 회원의 리뷰 목록





}