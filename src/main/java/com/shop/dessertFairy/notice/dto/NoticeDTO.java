package com.shop.dessertFairy.notice.dto;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class NoticeDTO {
	
	private int start;
	private int end;
	private int n_rr;
	private int n_no;
	private String n_subject;
	private String n_content;
	private int n_readcount;
	private String n_writer;
	private String n_vdate;
	private String n_regdate;
	private String n_state;
	
}
