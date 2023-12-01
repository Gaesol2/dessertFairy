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
	
}
