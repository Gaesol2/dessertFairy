package com.shop.dessertFairy.pay.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.pay.dto.PayDTO;

@Mapper
public interface PayDAO {

	int insertPay(PayDTO payDto);

}
