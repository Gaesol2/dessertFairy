package com.shop.dessertFairy.review.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.common.Page;
import com.shop.dessertFairy.common.RowInterPage;
import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.member.dto.MemberDTO;
import com.shop.dessertFairy.review.dao.ReviewDAO;
import com.shop.dessertFairy.review.dto.ReviewDTO;

@Service
public class ReviewServiceImpl implements ReviewService {

   @Autowired
   ReviewDAO reviewDao;
   
   @Override
   public Map<String, Object> getReviewList(ReviewDTO rdto, PageDTO pdto, String orderby) {
	   
	   //결과를 반환할 HashMap 선언
	   Map<String, Object> reSet = new HashMap<String, Object>();
	   
	   
	   List<ReviewDTO> reviewList = null;
	   if(rdto.getR_no()>0) {
		   reviewDao.updateReadCnt(rdto);
	   }
	  
	   int cnt = reviewDao.getReviewCnt();
	   pdto = Page.page(cnt, pdto);
	   rdto.setStart(pdto.getStart());
	   rdto.setEnd(pdto.getEnd());
	   
	   
	   if(orderby.equals("new")) {
		   reviewList = reviewDao.getReviewList(rdto);		
	   } else {
		   Map<String, Object> map = new HashMap<>();
		   map.put("orderby", orderby);
		   reviewList = reviewDao.getReviewListOrderby(map);
	   }
	   
	   reSet.put("pdto", pdto);
	   reSet.put("cnt", cnt);
	   reSet.put("reviewList", reviewList);
	   return reSet;
   }
   
   
   @Override
   public int reviewWrite(ReviewDTO rdto, MultipartFile file) {
	   
      String sourceFileName = file.getOriginalFilename();
      File destinationFile;
      
      System.out.println("sourceFileName " + sourceFileName);
      
      rdto.setR_image(sourceFileName);
      destinationFile = new File(rdto.getR_path()+sourceFileName);
      destinationFile.getParentFile().mkdirs(); //파일명으로 생성
      
      try {
         file.transferTo(destinationFile);
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      
      return reviewDao.reviewWrite(rdto);
   }


	@Override
	public ReviewDTO getReviewcontent(ReviewDTO rdto) {
		return reviewDao.getReviewcontent(rdto);
	}

	@Override
	public Map<String, Object> getMyList(ReviewDTO rdto, PageDTO pdto, String orderby) {
		//결과를 반환할 HashMap 선언
				Map<String, Object> reSet = new HashMap<String, Object>();
				
				
				List<ReviewDTO> myList = null;
				if(rdto.getR_no()>0) {
					reviewDao.updateReadCnt(rdto);
				}
					int cnt = reviewDao.getReviewCnt();
					   pdto = Page.page(cnt, pdto);
					   rdto.setStart(pdto.getStart());
					   rdto.setEnd(pdto.getEnd());
				
				if(orderby.equals("new")) {
					myList = reviewDao.getMyList(rdto);	
				} else {
					Map<String, Object> map = new HashMap<>();
					map.put("orderby", orderby);
					myList = reviewDao.getReviewListOrderby(map);
				}
				
				reSet.put("pdto", pdto);
				reSet.put("cnt", cnt);
				reSet.put("myList", myList);
				return reSet;
			}

	@Override
	public ReviewDTO getMycontent(ReviewDTO rdto) {
		return reviewDao.getMycontent(rdto);
	}
	
	@Override
	public ReviewDTO getMyupform(ReviewDTO rdto) {
		return reviewDao.getMycontent(rdto);
	}
	
	@Override
	public int updateProc(ReviewDTO rdto, MultipartFile file) {
		String sourceFileName = file.getOriginalFilename();
		File destinationFile;
		
		if(sourceFileName==null || sourceFileName.length()==0) {
			rdto.setR_image(rdto.getR_image());
		}else {
			rdto.setR_image(sourceFileName);
		    destinationFile = new File(rdto.getR_path()+sourceFileName);
		    destinationFile.getParentFile().mkdirs(); //파일명으로 생성
		    try {
		    	  System.out.println(destinationFile);
		         file.transferTo(destinationFile);
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		}
		
	      return reviewDao.updateProc(rdto);
	   }
	
	@Override
	public int deleteProc(ReviewDTO rdto) {
		return reviewDao.deleteProc(rdto);
	}
	
	
	//어드민 시작


	@Override
	public Map<String, Object> getReplyList(ReviewDTO rdto, PageDTO pdto) {
		
		//결과를 반환할 HashMap 선언
	   Map<String, Object> reSet = new HashMap<String, Object>();
	   
	   List<ReviewDTO> replyList = null;
	   if(rdto.getR_no()>0) {
		   reviewDao.updateReadCnt(rdto);
	   }
	   int cnt = reviewDao.getReviewCnt();
	   pdto = Page.page(cnt, pdto);
	   rdto.setStart(pdto.getStart());
	   rdto.setEnd(pdto.getEnd());
	   
	   replyList = reviewDao.getReplyList(rdto);	
	   
	   reSet.put("pdto", pdto);
	   reSet.put("cnt", cnt);
	   reSet.put("replyList", replyList);
	   return reSet;
   }


	@Override
	public ReviewDTO getReplyContent(ReviewDTO rdto) {
	    return reviewDao.getReplyContent(rdto);
	}


	@Override
	public int getReplyWrite(ReviewDTO rdto) {
		return reviewDao.getReplyWrite(rdto);
	}


	@Override
	public int replyupProc(ReviewDTO rdto) {
		return reviewDao.replyupProc(rdto);
	}


	@Override
	public int replydelProc(ReviewDTO rdto) {
		return reviewDao.replydelProc(rdto);
	}


	@Override
	public Map<String, Object> getMemList(ReviewDTO rdto, PageDTO pdto) {
		//결과를 반환할 HashMap 선언
		Map<String, Object> reSet = new HashMap<String, Object>();
		
		List<ReviewDTO> memList = null;
		if(rdto.getR_no()>0) {
			reviewDao.updateReadCnt(rdto);
		}
			int cnt = reviewDao.getReviewCnt();
			   pdto = Page.page(cnt, pdto);
			   rdto.setStart(pdto.getStart());
			   rdto.setEnd(pdto.getEnd());
		
		memList = reviewDao.getMemList(rdto);
		
		reSet.put("pdto", pdto);
		reSet.put("cnt", cnt);
		reSet.put("memList", memList);
		return reSet;
	}


	
	/*
	 * @Override public Map<String, Object> getMemberReview(String m_id, PageDTO
	 * pdto) { Map<String, Object> resultSet = new HashMap<String, Object>(); //
	 * map으로 결과를 담음 //페이지 계산 if(pdto.getCurBlock()<=0) pdto.setCurBlock(1);
	 * if(pdto.getCurPage()<=0) pdto.setCurPage(1);
	 * 
	 * int reviewTot = reviewDao.reviewTot(m_id); //전체 회원수 List<MemberDTO> myList =
	 * reviewDao.getreviews(m_id); // 전체 회원 리스트 resultSet.put("reviewTot",
	 * reviewTot); // map 키와 값 저장 resultSet.put("myList", myList); // map 키와 값 저장
	 * 
	 * return resultSet; }
	 */
	 




	
	
	
	
	
	
	
}
   
