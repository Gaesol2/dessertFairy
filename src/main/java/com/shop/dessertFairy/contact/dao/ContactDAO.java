package com.shop.dessertFairy.contact.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.contact.dto.ContactDTO;
import com.shop.dessertFairy.review.dto.ReviewDTO;

@Mapper
public interface ContactDAO {

	int getContactCnt();

	List<ReviewDTO> getContactList(ContactDTO tdto);

}
