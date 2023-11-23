package com.shop.dessertFairy.cake.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.cake.dto.CakeDTO;

@Mapper
public interface CakeDAO {

	int cakeOrderProc(CakeDTO cdto);

}
