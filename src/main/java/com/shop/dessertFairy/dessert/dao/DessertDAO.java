package com.shop.dessertFairy.dessert.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.dessert.dto.DessertDTO;

@Mapper
public interface DessertDAO {

	List<DessertDTO> getDessertList(Map<String, String> f);

	int getDessertCnt();

	DessertDTO getDessert(DessertDTO ddto);

	int insertProduct(DessertDTO ddto);

	List<DessertDTO> getProducttList();	//admin 상품리스트

	int getProductCnt();				//admin 상품 가지수

}
