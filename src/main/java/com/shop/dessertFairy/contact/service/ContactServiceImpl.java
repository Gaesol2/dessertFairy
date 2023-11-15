package com.shop.dessertFairy.contact.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dessertFairy.common.RowInterPage;
import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.contact.dao.ContactDAO;
import com.shop.dessertFairy.contact.dto.ContactDTO;
import com.shop.dessertFairy.review.dto.ReviewDTO;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactDAO contactDao;
	
	
	@Override
	public Map<String, Object> getContactList(ContactDTO tdto, PageDTO pageDto) {
		//결과를 반환할 HashMap 선언
		   Map<String, Object> reSet = new HashMap<String, Object>();
		   
		   
		   //페이지 계산
		   if(pageDto.getCurBlock()<=0) pageDto.setCurBlock(1);
		   if(pageDto.getCurPage()<=0) pageDto.setCurPage(1);
		   
		   
		   
		   List<ReviewDTO> contactList = null;
		   int cnt = 0;
		   cnt = contactDao.getContactCnt();
		   //현재 페이지 계산
		   int start = (pageDto.getCurPage()-1)*RowInterPage.ROW_OF_PAGE +1;
		   int end = (pageDto.getCurPage()*RowInterPage.ROW_OF_PAGE)>cnt?
				   cnt:pageDto.getCurPage()*RowInterPage.ROW_OF_PAGE;
		   tdto.setStart(start);
		   tdto.setEnd(end);
		   
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
		   
		   contactList = contactDao.getContactList(tdto);		
		   
		   
		   reSet.put("pageDto", pageDto);
		   reSet.put("cnt", cnt);
		   reSet.put("contactList", contactList);
		   return reSet;
	   }


	@Override
	public int contactWrite(ContactDTO tdto) {
	      return contactDao.contactWrite(tdto);
	}


	@Override
	public ContactDTO getContactcontent(ContactDTO tdto) {
		return contactDao.getContactcontent(tdto);
	}

}
