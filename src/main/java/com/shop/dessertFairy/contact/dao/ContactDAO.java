package com.shop.dessertFairy.contact.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.contact.dto.ContactDTO;
import com.shop.dessertFairy.review.dto.ReviewDTO;

@Mapper
public interface ContactDAO {

	int getContactCnt();

	int getMyContactCnt(ContactDTO tdto);

	List<ContactDTO> getContactList(ContactDTO tdto);

	int contactWrite(ContactDTO tdto);

	ContactDTO getContactcontent(ContactDTO tdto);

	List<ContactDTO> getMyContactList(ContactDTO tdto);

	ContactDTO getMyContactContent(ContactDTO tdto);
	
	int contactupProc(ContactDTO tdto);
	
	int MyContactDelProc(ContactDTO tdto);
	
	
	
	
	
	
	//admin
	

	ContactDTO getAdminContent(ContactDTO tdto);

	int replyWrite(String m_id);

	void contactAdmin(ContactDTO tdto);

	int contactUpProc(ContactDTO tdto);

	int contactDelProc(ContactDTO tdto);






}
