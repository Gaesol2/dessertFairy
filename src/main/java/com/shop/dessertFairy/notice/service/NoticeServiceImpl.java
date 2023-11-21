package com.shop.dessertFairy.notice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dessertFairy.common.Page;
import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.notice.dao.NoticeDAO;
import com.shop.dessertFairy.notice.dto.NoticeDTO;


@Service
public class NoticeServiceImpl implements NoticeService {
   
   @Autowired
   NoticeDAO noticeDao;

   @Override
   public Map<String, Object> getNoticies(NoticeDTO ndto, PageDTO pdto) {
      Map<String, Object> reSet = new HashMap<>();
	  
      List<NoticeDTO> noticeList = null;
      if(ndto.getN_no()>0) {
    	  //조회수 증가dao 호출하고, mapper 조회수 증가 하게 하기
        noticeDao.updateReadCnt(ndto);
      }
       int cnt = noticeDao.getTotalCnt();
	   pdto = Page.page(cnt, pdto);
	   ndto.setStart(pdto.getStart());
	   ndto.setEnd(pdto.getEnd());
	  
      noticeList = noticeDao.getNoticies(ndto);
      reSet.put("cnt", cnt);
      reSet.put("pdto", pdto);
      reSet.put("noticeList", noticeList);
      return reSet;
   }

   @Override
   public void generateNotice(NoticeDTO ndto) {
      noticeDao.generateNotice(ndto);
   }

   @Override
   public NoticeDTO getNotice(NoticeDTO ndto) {
      List<NoticeDTO> noticeList = noticeDao.getNoticies(ndto);
      return noticeList.get(0);
   }

   @Override
   public int updateProc(NoticeDTO ndto) {
    
    return noticeDao.updateProc(ndto);
 }

   @Override
   public int deleteProc(NoticeDTO ndto) {
    return noticeDao.deleteProc(ndto);
 }
}