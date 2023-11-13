package com.shop.dessertFairy.order.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderDTO {
	private int o_no      ;
	private int o_price   ;
	private int o_quantity;
	private String o_regdate ;
	private String o_state   ;
	private int o_amount    ;
	private String m_id      ;
	private int d_no      ;
	
	private int d_stock;
	private String d_name;
	private String d_image;
	private int overStock;
	
	private int o_rr;
	private int start;
	private int end;
}
