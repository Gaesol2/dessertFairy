package com.shop.dessertFairy.notice.service;

import java.util.Map;

import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.notice.dto.NoticeDTO;



public interface NoticeService {


		    Map<String, Object> getNoticies(NoticeDTO ndto, PageDTO pdto);

		    NoticeDTO getNotice(NoticeDTO ndto);
	
			int updateProc(NoticeDTO ndto);
	
			int deleteProc(NoticeDTO ndto);
	
			void generateNotice(NoticeDTO ndto);

		}

	
