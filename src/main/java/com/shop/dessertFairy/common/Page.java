package com.shop.dessertFairy.common;

import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.contact.dto.ContactDTO;

public class Page {

	public static PageDTO page(int cnt, PageDTO pdto) {
		//페이지 계산
		   if(pdto.getCurBlock()<=0) pdto.setCurBlock(1);			// 출력되는 페이지번호 개수
		   if(pdto.getCurPage()<=0) pdto.setCurPage(1);
		   
		   int start = (pdto.getCurPage()-1)*RowInterPage.ROW_OF_PAGE +1;	// 현재 페이지에서 시작 게시물 번호
		   int end = (pdto.getCurPage()*RowInterPage.ROW_OF_PAGE)>cnt?		// 현재 페이지에서 끝나는 게시물 번호
				   cnt:pdto.getCurPage()*RowInterPage.ROW_OF_PAGE;
		   pdto.setStart(start);
		   pdto.setEnd(end);
		   
		   int pgCnt = (cnt%RowInterPage.ROW_OF_PAGE==0)?						// 총 페이지 개수
				   cnt/RowInterPage.ROW_OF_PAGE:	
					   cnt/RowInterPage.ROW_OF_PAGE+1;							// 남는 페이지 출력
		   
		   //페이지 블럭 계산
		   int pgBlock = (pgCnt%RowInterPage.PAGE_OF_BLOCK==0)?
				   pgCnt/RowInterPage.PAGE_OF_BLOCK:pgCnt/RowInterPage.PAGE_OF_BLOCK+1;
		   int startPg = (pdto.getCurBlock()-1)*RowInterPage.PAGE_OF_BLOCK+1;
		   int endPg = (pdto.getCurBlock()*RowInterPage.PAGE_OF_BLOCK>pgCnt)?
				   pgCnt:pdto.getCurBlock()*RowInterPage.PAGE_OF_BLOCK;
		   
		   pdto.setPgCnt(pgCnt);
		   pdto.setPgBlock(pgBlock);
		   pdto.setStartPg(startPg);
		   pdto.setEndPg(endPg);
		   
		return pdto;
	}

}
