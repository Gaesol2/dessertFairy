package com.shop.dessertFairy.review.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.review.dto.ReviewDTO;

public interface ReviewService {

   Map<String, Object> getReviewList(ReviewDTO rdto, PageDTO pageDto, String orderby);

   int reviewWrite(ReviewDTO rdto, MultipartFile file);

   ReviewDTO getReviewcontent(ReviewDTO rdto);

   Map<String, Object> getMyList(ReviewDTO rdto, PageDTO pageDto, String orderby);

   ReviewDTO getMycontent(ReviewDTO rdto);
   
   ReviewDTO getMyupform(ReviewDTO rdto);
   
   int updateProc(ReviewDTO rdto, MultipartFile file);
   
   int deleteProc(ReviewDTO rdto);
   
   //어드민 시작

   Map<String, Object> getReplyList(ReviewDTO rdto, PageDTO pageDto);

   ReviewDTO getReplyContent(ReviewDTO rdto);

   int getReplyWrite(ReviewDTO rdto);

   int replyupProc(ReviewDTO rdto);

   int replydelProc(ReviewDTO rdto);

   Map<String, Object> getMemberReview(String m_id);
   
   
   
  





}	