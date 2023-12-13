package com.shop.dessertFairy.pay.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.order.dto.OrderDTO;
import com.shop.dessertFairy.pay.dto.PayDTO;

@Mapper
public interface PayDAO {

	int insertPay(PayDTO payDto);

	String getTransactionId(OrderDTO odto);

	String getType(OrderDTO odto);

	void deletePay(OrderDTO odto);

}
