package com.shop.dessertFairy.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDTO {
	//page
    private int pgCnt;
	private int pgBlock;
	private int curPage=1;
	private int curBlock=1;
	private int startPg=1;
	private int endPg=1;
	
}
