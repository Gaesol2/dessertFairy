package com.shop.dessertFairy.pay.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PayDTO {

	String ordr_idxx;
	String res_cd;
	String res_msg;
	String enc_data;
	String enc_info;
	String tran_cd; 
	String buyr_mail; 
	String userId;
	
	String p_transactionid;
	String p_ordernumber;
	String p_authdatetime;
	String p_amount;
	String p_authnumber;
	String p_cardname;
	String p_cardno;
	String p_quota;
	String o_no;
	String p_type;
	
}
