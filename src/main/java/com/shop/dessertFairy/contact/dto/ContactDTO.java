package com.shop.dessertFairy.contact.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ContactDTO {
	private int start;
	private int end;
	
	
	private int t_rr;
	private int t_no;
	private String t_subject;
	private String t_content;
	private String t_regdate;
	private String t_passwd;
	private int t_secret;
	private String m_id;

}
