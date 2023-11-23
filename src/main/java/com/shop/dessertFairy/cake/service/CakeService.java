package com.shop.dessertFairy.cake.service;

import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.cake.dto.CakeDTO;

public interface CakeService {

	int cakeOrderProc(CakeDTO cdto, MultipartFile file);
	
}
