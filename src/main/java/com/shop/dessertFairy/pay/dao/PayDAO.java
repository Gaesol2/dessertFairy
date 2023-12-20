package com.shop.dessertFairy.pay.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.order.dto.OrderDTO;
import com.shop.dessertFairy.pay.dto.PayDTO;

@Mapper
public interface PayDAO {

	int insertPay(PayDTO payDto);

	String getTransactionId(PayDTO payDto);

	String getType(PayDTO payDto);

	void deletePay(OrderDTO odto);

}
