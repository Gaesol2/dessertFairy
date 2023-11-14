package com.shop.dessertFairy.dessert.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DessertDTO {
	private int start;
	private int end;
	
	private int d_rr;
	private int d_no      ;
	private String d_category;
	private String d_name    ;
	private String d_detail  ;
	private int d_price   ;
	private int d_stock ;
	private String d_image   ;
	private String d_path    ;
	private String d_life    ;
	private String d_storage ;
	private String d_allergy ;
	
	private String keyword; // 검색 키워드
}
