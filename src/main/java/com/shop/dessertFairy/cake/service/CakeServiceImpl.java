package com.shop.dessertFairy.cake.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.dessertFairy.cake.dao.CakeDAO;
import com.shop.dessertFairy.cake.dto.CakeDTO;

@Service
public class CakeServiceImpl implements CakeService {
	
	@Autowired
	CakeDAO cakeDao;

	@Override
	public int cakeOrderProc(CakeDTO cdto) {
		return cakeDao.cakeOrderProc(cdto);
	}
	
	
	

}
