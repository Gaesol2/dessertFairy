package com.shop.dessertFairy.contact.service;

import java.util.Map;

import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.contact.dto.ContactDTO;
import com.shop.dessertFairy.review.dto.ReviewDTO;

public interface ContactService {

	Map<String, Object> getContactList(ContactDTO tdto, PageDTO pageDto);

	int contactWrite(ContactDTO tdto);

	ContactDTO getContactcontent(ContactDTO tdto);


}
