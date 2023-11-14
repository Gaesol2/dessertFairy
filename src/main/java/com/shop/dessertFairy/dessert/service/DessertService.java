package com.shop.dessertFairy.dessert.service;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.dessert.dto.DessertDTO;
import com.shop.dessertFairy.order.dto.OrderDTO;

public interface DessertService {

   Map<String, Object> getDessertList(String flag);

   DessertDTO getDessert(DessertDTO ddto);

   int insertProduct(DessertDTO ddto, MultipartFile file);

   int updateProduct(DessertDTO ddto, MultipartFile file);	//admin 상품 업데이트

   Map<String, Object> getProductList(DessertDTO ddto, PageDTO pdto);		//admin 상품 리스트
   
   DessertDTO adminGetDessert(int d_no);					//admin 상품 디테일

   DessertDTO getProduct(int d_no);							//admin 상품수정 전 정보 받아오기

   int orderCntOfProduct(int dno);							//admin 주문내역 확인. 데이터 삭제를 위해서

   int deleteProduct(DessertDTO ddto);						//admin 상품 삭제

   int updateStocks(Hashtable<Integer, OrderDTO> hCartList);

   Map<String, Object> getSearchList(DessertDTO ddto, PageDTO pdto);

}