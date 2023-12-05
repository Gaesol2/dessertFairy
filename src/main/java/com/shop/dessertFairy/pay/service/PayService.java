package com.shop.dessertFairy.pay.service;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import com.shop.dessertFairy.pay.dto.PayDTO;

public interface PayService {
	
	public Map<String,Object> JsonApi(String url, Map<String,String> map);
	
	public String getSHA256Hash(String input) throws NoSuchAlgorithmException;

	public void insertPay(PayDTO payDto);
	
}
