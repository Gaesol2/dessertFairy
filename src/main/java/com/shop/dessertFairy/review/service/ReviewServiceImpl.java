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
   public Map<String, Object> getReviewList(ReviewDTO rdto, PageDTO pageDto, String orderby) {
	   
	   //결과를 반환할 HashMap 선언
	   Map<String, Object> reSet = new HashMap<String, Object>();
	   
	   
	   //페이지 계산
	   if(pageDto.getCurBlock()<=0) pageDto.setCurBlock(1);
	   if(pageDto.getCurPage()<=0) pageDto.setCurPage(1);
	   
	   
	   
	   List<ReviewDTO> reviewList = null;
	   int cnt = 0;
	   if(rdto.getR_no()>0) {
		   reviewDao.updateReadCnt(rdto);
	   }
	   cnt = reviewDao.getReviewCnt();
	   //현재 페이지 계산
	   int start = (pageDto.getCurPage()-1)*RowInterPage.ROW_OF_PAGE +1;
	   int end = (pageDto.getCurPage()*RowInterPage.ROW_OF_PAGE)>cnt?
			   cnt:pageDto.getCurPage()*RowInterPage.ROW_OF_PAGE;
	   rdto.setStart(start);
	   rdto.setEnd(end);
	   
	   int pgCnt = (cnt%RowInterPage.ROW_OF_PAGE==0)?
			   cnt/RowInterPage.ROW_OF_PAGE:
				   cnt/RowInterPage.ROW_OF_PAGE+1;
	   
	   //페이지 블럭
	   int pgBlock = (pgCnt%RowInterPage.PAGE_OF_BLOCK==0)?
			   pgCnt/RowInterPage.PAGE_OF_BLOCK:pgCnt/RowInterPage.PAGE_OF_BLOCK+1;
	   int startPg = (pageDto.getCurBlock()-1)*RowInterPage.PAGE_OF_BLOCK+1;
	   int endPg = (pageDto.getCurBlock()*RowInterPage.PAGE_OF_BLOCK>pgCnt)?
			   pgCnt:pageDto.getCurBlock()*RowInterPage.PAGE_OF_BLOCK;
	   
	   pageDto.setPgCnt(pgCnt);
	   pageDto.setPgBlock(pgBlock);
	   pageDto.setStartPg(startPg);
	   pageDto.setEndPg(endPg);
	   
	   if(orderby.equals("new")) {
		   reviewList = reviewDao.getReviewList(rdto);		
	   } else {
		   Map<String, Object> map = new HashMap<>();
		   map.put("orderby", orderby);
		   reviewList = reviewDao.getReviewListOrderby(map);
	   }
	   
	   reSet.put("pageDto", pageDto);
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
	public Map<String, Object> getMyList(ReviewDTO rdto, PageDTO pageDto, String orderby) {
		//결과를 반환할 HashMap 선언
				Map<String, Object> reSet = new HashMap<String, Object>();
				
				
				//페이지 계산
				if(pageDto.getCurBlock()<=0) pageDto.setCurBlock(1);
				if(pageDto.getCurPage()<=0) pageDto.setCurPage(1);
				
				
				
				List<ReviewDTO> myList = null;
				int cnt = 0;
				if(rdto.getR_no()>0) {
					reviewDao.updateReadCnt(rdto);
				}
					cnt = reviewDao.getReviewCnt();
				//현재 페이지 계산
				int start = (pageDto.getCurPage()-1)*RowInterPage.ROW_OF_PAGE +1;
				int end = (pageDto.getCurPage()*RowInterPage.ROW_OF_PAGE)>cnt?
						cnt:pageDto.getCurPage()*RowInterPage.ROW_OF_PAGE;
				rdto.setStart(start);
				rdto.setEnd(end);
				
				int pgCnt = (cnt%RowInterPage.ROW_OF_PAGE==0)?
						     cnt/RowInterPage.ROW_OF_PAGE:
						     cnt/RowInterPage.ROW_OF_PAGE+1;
				
				//페이지 블럭
				int pgBlock = (pgCnt%RowInterPage.PAGE_OF_BLOCK==0)?
						pgCnt/RowInterPage.PAGE_OF_BLOCK:pgCnt/RowInterPage.PAGE_OF_BLOCK+1;
				int startPg = (pageDto.getCurBlock()-1)*RowInterPage.PAGE_OF_BLOCK+1;
				int endPg = (pageDto.getCurBlock()*RowInterPage.PAGE_OF_BLOCK>pgCnt)?
						pgCnt:pageDto.getCurBlock()*RowInterPage.PAGE_OF_BLOCK;
				
				pageDto.setPgCnt(pgCnt);
				pageDto.setPgBlock(pgBlock);
				pageDto.setStartPg(startPg);
				pageDto.setEndPg(endPg);
				
				if(orderby.equals("new")) {
					myList = reviewDao.getMyList(rdto);	
				} else {
					Map<String, Object> map = new HashMap<>();
					map.put("orderby", orderby);
					myList = reviewDao.getReviewListOrderby(map);
				}
				
				reSet.put("pageDto", pageDto);
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
	   
	   reSet.put("pageDto", pdto);
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
	public Map<String, Object> getMemberReview(ReviewDTO rdto, PageDTO pdto) {
		int cnt = reviewDao.getReviewCnt();
		Map<String, Object> resultSet = new HashMap<String, Object>(); 
		if(pdto.getCurBlock()<=0) pdto.setCurBlock(1);
		if(pdto.getCurPage()<=0) pdto.setCurPage(1);
		
		int start = (pdto.getCurPage()-1)*RowInterPage.ROW_OF_PAGE +1;
		int end = (pdto.getCurPage()*RowInterPage.ROW_OF_PAGE)>cnt?
				   cnt:pdto.getCurPage()*RowInterPage.ROW_OF_PAGE;
		rdto.setStart(start);
		rdto.setEnd(end);
		   
		   int pgCnt = (cnt%RowInterPage.ROW_OF_PAGE==0)?
				   cnt/RowInterPage.ROW_OF_PAGE:
					   cnt/RowInterPage.ROW_OF_PAGE+1;
		   
		   //페이지 블럭
		   int pgBlock = (pgCnt%RowInterPage.PAGE_OF_BLOCK==0)?
				   pgCnt/RowInterPage.PAGE_OF_BLOCK:pgCnt/RowInterPage.PAGE_OF_BLOCK+1;
		   int startPg = (pdto.getCurBlock()-1)*RowInterPage.PAGE_OF_BLOCK+1;
		   int endPg = (pdto.getCurBlock()*RowInterPage.PAGE_OF_BLOCK>pgCnt)?
				   pgCnt:pdto.getCurBlock()*RowInterPage.PAGE_OF_BLOCK;
		   
		   pdto.setPgCnt(pgCnt);
		   pdto.setPgBlock(pgBlock);
		   pdto.setStartPg(startPg);
		   pdto.setEndPg(endPg);
//		int reviewTot = reviewDao.reviewTot(m_id); 
			List<MemberDTO> myList = reviewDao.getreviews(rdto); 
//			resultSet.put("reviewTot", reviewTot);
			resultSet.put("myList", myList); 
			resultSet.put("pdto", pdto); 
			resultSet.put("cnt", cnt);
	 
		return resultSet;
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
   
