package com.shop.dessertFairy.notice.dto;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class NoticeDTO {
	
	private int start;
	private int end;
	private int rr;
	private int noti_no;
	private String subject;
	private String content;
	private int readcount;
	private String writer;
	private String vdate;
	private String regdate;
	private char state;
	
}
