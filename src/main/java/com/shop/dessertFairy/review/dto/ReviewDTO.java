package com.shop.dessertFairy.review.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReviewDTO {
   private int r_no;
   private String r_subject;
   private String r_content;
   private String r_regdate;
   private int r_readcount;
   private String r_passwd;
   private String r_star;
   private String r_image;
   private String m_id;
   private String r_path;
}