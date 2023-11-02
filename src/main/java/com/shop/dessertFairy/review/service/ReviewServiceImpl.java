package com.shop.dessertFairy.review.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.common.RowInterPage;
import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.review.dao.ReviewDAO;
import com.shop.dessertFairy.review.dto.ReviewDTO;

@Service
public class ReviewServiceImpl implements ReviewService {

   @Autowired
   ReviewDAO reviewDao;
   
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
      System.out.println("rdto ====== " + rdto);
      return reviewDao.reviewWrite(rdto);
   }

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
	public ReviewDTO getReviewcontent(ReviewDTO rdto) {
		List<ReviewDTO> reviewList = reviewDao.getReviewList(rdto);
		return reviewList.get(0);
	}

	@Override
	public Map<String, Object> getReviewMyList(ReviewDTO rdto, PageDTO pageDto, String orderby) {
		//결과를 반환할 HashMap 선언
				Map<String, Object> reSet = new HashMap<String, Object>();
				
				
				//페이지 계산
				if(pageDto.getCurBlock()<=0) pageDto.setCurBlock(1);
				if(pageDto.getCurPage()<=0) pageDto.setCurPage(1);
				
				
				
				List<ReviewDTO> reviewmyList = null;
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
					reviewmyList = reviewDao.getReviewMyList(rdto);	
				} else {
					Map<String, Object> map = new HashMap<>();
					map.put("orderby", orderby);
					reviewmyList = reviewDao.getReviewListOrderby(map);
				}
				
				reSet.put("pageDto", pageDto);
				reSet.put("cnt", cnt);
				reSet.put("reviewmyList", reviewmyList);
				return reSet;
			}

	@Override
	public Map<String, Object> getReplyList(ReviewDTO rdto, PageDTO pageDto) {
		//결과를 반환할 HashMap 선언
				Map<String, Object> reSet = new HashMap<String, Object>();
				
				
				//페이지 계산
				if(pageDto.getCurBlock()<=0) pageDto.setCurBlock(1);
				if(pageDto.getCurPage()<=0) pageDto.setCurPage(1);
				
				
				
				List<ReviewDTO> replyList = null;
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
				
				replyList = reviewDao.getReplyList(rdto);
				
				pageDto.setPgCnt(pgCnt);
				pageDto.setPgBlock(pgBlock);
				pageDto.setStartPg(startPg);
				pageDto.setEndPg(endPg);
				
				reSet.put("pageDto", pageDto);
				reSet.put("cnt", cnt);
				reSet.put("replyList", replyList);
				return reSet;
			}

	@Override
	public int replyWrite(ReviewDTO rdto) {
		// TODO Auto-generated method stub
		return 0;
	}


}
   
