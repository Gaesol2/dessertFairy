package com.shop.dessertFairy.dessert.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.dessert.dto.DessertDTO;
import com.shop.dessertFairy.order.dto.OrderDTO;

@Mapper
public interface DessertDAO {

	List<DessertDTO> getDessertList(Map<String, String> f);

	int getDessertCnt();

	DessertDTO getDessert(DessertDTO ddto);

	int insertProduct(DessertDTO ddto);

	List<DessertDTO> getProductList(DessertDTO ddto);						//admin 상품리스트

	int getProductCnt();									//admin 상품 가지수

	DessertDTO adminGetDessert(int d_no);					//admin 상품 디테일

	DessertDTO getProduct(int d_no);						//admin 상품 수정 전 정보

	int updateProduct(DessertDTO ddto);	//admin 상품 수정

	int orderCntOfProduct(int dno);		//admin 주문내역 확인 .데이터 삭제를 위해서

	int deleteProduct(DessertDTO ddto);	//admin 상품 삭제

	int getProCnt();							

	int updateStocks(List<OrderDTO> list);

	int getSearchCnt();

	List<DessertDTO> getSearchList(DessertDTO ddto);

	List<Integer> maxSale();

	void cancelStocks(OrderDTO odto);

	
}
