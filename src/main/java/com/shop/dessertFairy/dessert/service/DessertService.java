package com.shop.dessertFairy.dessert.service;

import java.util.Map;

import com.shop.dessertFairy.dessert.dto.DessertDTO;

public interface DessertService {

	Map<String, Object> getDessertList(String flag);

	DessertDTO getDessert(DessertDTO ddto);

}
