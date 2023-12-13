package com.shop.dessertFairy.pay.service;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import com.shop.dessertFairy.order.dto.OrderDTO;
import com.shop.dessertFairy.pay.dto.PayDTO;

public interface PayService {
	
	public Map<String,Object> JsonApi(String url, Map<String,String> map);
	
	public String getSHA256Hash(String input) throws NoSuchAlgorithmException;

	public int insertPay(PayDTO payDto);

	public String getTransactionId(OrderDTO odto);

	public String getType(OrderDTO odto);
	
}
