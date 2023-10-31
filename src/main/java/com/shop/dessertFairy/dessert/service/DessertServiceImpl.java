package com.shop.dessertFairy.dessert.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dessertFairy.dessert.dao.DessertDAO;
import com.shop.dessertFairy.dessert.dto.DessertDTO;

@Service
public class DessertServiceImpl implements DessertService {

	@Autowired
	DessertDAO dessertDao;
	
	@Override
	public Map<String, Object> getDessertList() {
		Map<String, Object> resultSet = new HashMap<>();
		
		List<DessertDTO> dessert = dessertDao.getDessertList();
		int dessertCnt = dessertDao.getDessertCnt();
		int endBox = dessertCnt;
		
		resultSet.put("dessert", dessert);
		resultSet.put("endBox", endBox);
		
		return resultSet;
	}

}
