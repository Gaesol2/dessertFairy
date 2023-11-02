package com.shop.dessertFairy.dessert.service;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.dessert.dto.DessertDTO;

public interface DessertService {

   Map<String, Object> getDessertList(String flag);

   DessertDTO getDessert(DessertDTO ddto);

   int insertProduct(DessertDTO ddto, MultipartFile file);

   int updateProduct(DessertDTO ddto, MultipartFile file);

   Map<String, Object> getProductList(PageDTO pdto);
   
   DessertDTO adminGetDessert(int d_no);		//admin 상품 디테일

}