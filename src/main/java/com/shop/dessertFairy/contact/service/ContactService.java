package com.shop.dessertFairy.contact.service;

import java.util.Map;

import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.contact.dto.ContactDTO;
import com.shop.dessertFairy.review.dto.ReviewDTO;

public interface ContactService {

	Map<String, Object> getContactList(ContactDTO tdto, PageDTO pdto);

	int contactWrite(ContactDTO tdto);

	ContactDTO getContactcontent(ContactDTO tdto);

	Map<String, Object> getMyContactList(ContactDTO tdto, PageDTO pdto);

	ContactDTO getMyContactContent(ContactDTO tdto);

	ContactDTO getMyContactUpForm(ContactDTO tdto);
	
	int contactupProc(ContactDTO tdto);
	
	int MyContactDelProc(ContactDTO tdto);
	
	
	
	//admin
	
//	Map<String, Object> getAdminList(ContactDTO tdto, PageDTO pageDto);

	ContactDTO getAdminContent(ContactDTO tdto);

	int contactWrite(String m_id);





}
