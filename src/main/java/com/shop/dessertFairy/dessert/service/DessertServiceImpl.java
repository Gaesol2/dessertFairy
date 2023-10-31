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
	public Map<String, Object> getDessertList(String flag) {
		//결과를 반환할 HashMap 선언
		Map<String, Object> resultSet = new HashMap<>();
		
		//myBatis로 flag의 값을 전달해 줄 HashMap 선언
		Map<String, String> f = new HashMap<>();
		f.put("flag", flag);
		
		//flag에 따라 ddto의 값을 반환해주는 로직
		List<DessertDTO> dessert = dessertDao.getDessertList(f);
		
		//전체 상품 개수 반환해주는 로직
		int dessertCnt = dessertDao.getDessertCnt();
		
		resultSet.put("dessert", dessert);
		resultSet.put("endBox", dessertCnt);
		
		return resultSet;
	}

	@Override
	public DessertDTO getDessert(DessertDTO ddto) {
		return dessertDao.getDessert(ddto);
	}

}
