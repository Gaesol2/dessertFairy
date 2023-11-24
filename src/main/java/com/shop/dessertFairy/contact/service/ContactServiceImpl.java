package com.shop.dessertFairy.contact.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dessertFairy.common.Page;
import com.shop.dessertFairy.common.RowInterPage;
import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.contact.dao.ContactDAO;
import com.shop.dessertFairy.contact.dto.ContactDTO;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactDAO contactDao;

	@Override
	public Map<String, Object> getContactList(ContactDTO tdto, PageDTO pdto) {
		//결과를 반환할 HashMap 선언
		   Map<String, Object> reSet = new HashMap<String, Object>();
		   
		   
		   
		   
		   List<ContactDTO> contactList = null;
		   int cnt = contactDao.getContactCnt();
		   pdto = Page.page(cnt, pdto);	// 페이지 계산 메소드 호출
		   tdto.setStart(pdto.getStart());
		   tdto.setEnd(pdto.getEnd());
		   
		   contactList = contactDao.getContactList(tdto);		
		   
		   System.out.println("결과 : "+contactList);
		   reSet.put("pdto", pdto);
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


	@Override
	public Map<String, Object> getMyContactList(ContactDTO tdto, PageDTO pdto) {
		//결과를 반환할 HashMap 선언
		Map<String, Object> reSet = new HashMap<String, Object>();
		
		List<ContactDTO> myContact = null;
		int cnt= contactDao.getContactCnt();
		   pdto = Page.page(cnt, pdto);
		   tdto.setStart(pdto.getStart());
		   tdto.setEnd(pdto.getEnd());
		  
		
		myContact = contactDao.getMyContactList(tdto);
		
		
		
		reSet.put("pdto", pdto);
		reSet.put("cnt", cnt);
		reSet.put("myContact", myContact);
		return reSet;
	}


	@Override
	public ContactDTO getMyContactContent(ContactDTO tdto) {
		return contactDao.getMyContactContent(tdto);
	}
	
	@Override
	public ContactDTO getMyContactUpForm(ContactDTO tdto) {
		return contactDao.getMyContactContent(tdto);
	}
	
	@Override
	public int contactupProc(ContactDTO tdto) {
		System.out.println("이거 버려?");
		return contactDao.contactupProc(tdto);
	}
	
	@Override
	public int MyContactDelProc(ContactDTO tdto) {
		return contactDao.MyContactDelProc(tdto);
	}
	
	
	
	
	//admin


	/*
	 * @Override public Map<String, Object> getAdminList(ContactDTO tdto, PageDTO
	 * pageDto) { //결과를 반환할 HashMap 선언 Map<String, Object> reSet = new
	 * HashMap<String, Object>();
	 * 
	 * 
	 * //페이지 계산 if(pageDto.getCurBlock()<=0) pageDto.setCurBlock(1);
	 * if(pageDto.getCurPage()<=0) pageDto.setCurPage(1);
	 * 
	 * 
	 * 
	 * List<ContactDTO> contactList = null; int cnt = 0; cnt =
	 * contactDao.getContactCnt(); //현재 페이지 계산 int start =
	 * (pageDto.getCurPage()-1)*RowInterPage.ROW_OF_PAGE +1; int end =
	 * (pageDto.getCurPage()*RowInterPage.ROW_OF_PAGE)>cnt?
	 * cnt:pageDto.getCurPage()*RowInterPage.ROW_OF_PAGE; tdto.setStart(start);
	 * tdto.setEnd(end);
	 * 
	 * int pgCnt = (cnt%RowInterPage.ROW_OF_PAGE==0)? cnt/RowInterPage.ROW_OF_PAGE:
	 * cnt/RowInterPage.ROW_OF_PAGE+1;
	 * 
	 * //페이지 블럭 int pgBlock = (pgCnt%RowInterPage.PAGE_OF_BLOCK==0)?
	 * pgCnt/RowInterPage.PAGE_OF_BLOCK:pgCnt/RowInterPage.PAGE_OF_BLOCK+1; int
	 * startPg = (pageDto.getCurBlock()-1)*RowInterPage.PAGE_OF_BLOCK+1; int endPg =
	 * (pageDto.getCurBlock()*RowInterPage.PAGE_OF_BLOCK>pgCnt)?
	 * pgCnt:pageDto.getCurBlock()*RowInterPage.PAGE_OF_BLOCK;
	 * 
	 * pageDto.setPgCnt(pgCnt); pageDto.setPgBlock(pgBlock);
	 * pageDto.setStartPg(startPg); pageDto.setEndPg(endPg);
	 * 
	 * reSet.put("pageDto", pageDto); reSet.put("cnt", cnt);
	 * reSet.put("contactList", contactList); return reSet; }
	 */
	
	@Override
	public ContactDTO getAdminContent(ContactDTO tdto) {
		return contactDao.getAdminContent(tdto);
	}


	@Override
	public int contactWrite(String m_id) {		//admin 글쓰기
		return contactDao.replyWrite(m_id);
	}


	


	


	


	
}

