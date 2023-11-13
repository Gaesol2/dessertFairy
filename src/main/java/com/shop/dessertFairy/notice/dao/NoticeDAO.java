package com.shop.dessertFairy.notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.notice.dto.NoticeDTO;

@Mapper
public interface NoticeDAO {

	public int getTotalCnt();

	public List<NoticeDTO> getNoticies(NoticeDTO ndto);

	public void generateNotice(NoticeDTO ndto);

	public int updateReadCnt(NoticeDTO ndto);

	public int deleteProc(NoticeDTO ndto);

	public int updateProc(NoticeDTO ndto);

}
