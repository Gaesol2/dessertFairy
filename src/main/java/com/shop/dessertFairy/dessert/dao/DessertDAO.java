package com.shop.dessertFairy.dessert.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.dessert.dto.DessertDTO;

@Mapper
public interface DessertDAO {

	List<DessertDTO> getDessertList();

	int getDessertCnt();

}
