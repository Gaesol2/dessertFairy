package com.shop.dessertFairy.member.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberDTO {
	private String m_id;
	private String m_name;
	private String m_passwd;
	private String m_email;
	private int m_phone;
	private String m_regdate;
	private int m_zipcode;
	private String m_address;
	private String m_address2;
	private String m_role;
	private String m_quest;
	private String m_answer;
	
}
