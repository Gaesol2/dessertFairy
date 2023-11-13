package com.shop.dessertFairy.dessert.service;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.common.RowInterPage;
import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.dessert.dao.DessertDAO;
import com.shop.dessertFairy.dessert.dto.DessertDTO;
import com.shop.dessertFairy.order.dto.OrderDTO;
import com.shop.dessertFairy.review.dto.ReviewDTO;

@Service
public class DessertServiceImpl implements DessertService {

   @Autowired
   DessertDAO dessertDao;
   
   @Override
   public Map<String, Object> getDessertList(String flag) {
      //결과를 반환할 HashMap 선언
      Map<String, Object> resultSet = new HashMap<>();
      
      //myBatis로 flag의 값을 전달해 줄 HashMap 선언
      Map<String, String> f = new HashMap<>();
      f.put("flag", flag);
      
      //flag에 따라 ddto의 값을 반환해주는 로직
      List<DessertDTO> dessert = dessertDao.getDessertList(f);
      
      //전체 상품 개수 반환해주는 로직
      int dessertCnt = dessertDao.getDessertCnt();
      
      resultSet.put("dessert", dessert);
      resultSet.put("endBox", dessertCnt);
      
      return resultSet;
   }

   @Override
   public DessertDTO getDessert(DessertDTO ddto) {
      return dessertDao.getDessert(ddto);
   }

   @Override
   public int insertProduct(DessertDTO ddto, MultipartFile file) {      //admin 상품 등록
      String sourceFileName = file.getOriginalFilename();
      File destinationFile;
      if(sourceFileName==null || sourceFileName.length()==0) {
        ddto.setD_image("ready.jpg");
      }else {
        ddto.setD_image(sourceFileName);
        destinationFile = new File(ddto.getD_path()+sourceFileName);
        destinationFile.getParentFile().mkdirs(); //파일명으로 생성
        try {
           //받은 파일 전송
           file.transferTo(destinationFile);
        }catch (Exception e) {
           e.printStackTrace();
        }
      }
      return dessertDao.insertProduct(ddto);
   }
   
	@Override
	public Map<String, Object> getProductList(DessertDTO ddto, PageDTO pdto) {		//admin 상품 리스트
		
		int pcnt = dessertDao.getProductCnt();                     //상품 총 개수 
		Map<String, Object> resultSet = new HashMap<String, Object>();
		   
		//페이지 계산
		   if(pdto.getCurBlock()<=0) pdto.setCurBlock(1);
		   if(pdto.getCurPage()<=0) pdto.setCurPage(1);
		   
		   
		   int cnt = 0;
		   cnt = dessertDao.getProCnt();
		   //현재 페이지 계산
		   int start = (pdto.getCurPage()-1)*RowInterPage.ROW_OF_PAGE +1;
		   int end = (pdto.getCurPage()*RowInterPage.ROW_OF_PAGE)>cnt?
				   cnt:pdto.getCurPage()*RowInterPage.ROW_OF_PAGE;
		   ddto.setStart(start);
		   ddto.setEnd(end);
		   
		   int pgCnt = (cnt%RowInterPage.ROW_OF_PAGE==0)?
				   cnt/RowInterPage.ROW_OF_PAGE:
					   cnt/RowInterPage.ROW_OF_PAGE+1;
		   
		   //페이지 블럭
		   int pgBlock = (pgCnt%RowInterPage.PAGE_OF_BLOCK==0)?
				   pgCnt/RowInterPage.PAGE_OF_BLOCK:pgCnt/RowInterPage.PAGE_OF_BLOCK+1;
		   int startPg = (pdto.getCurBlock()-1)*RowInterPage.PAGE_OF_BLOCK+1;
		   int endPg = (pdto.getCurBlock()*RowInterPage.PAGE_OF_BLOCK>pgCnt)?
				   pgCnt:pdto.getCurBlock()*RowInterPage.PAGE_OF_BLOCK;
		   
		   pdto.setPgCnt(pgCnt);
		   pdto.setPgBlock(pgBlock);
		   pdto.setStartPg(startPg);
		   pdto.setEndPg(endPg);
		
		
		List<DessertDTO> pList = dessertDao.getProductList(ddto);
		resultSet.put("pdto", pdto);
		resultSet.put("cnt", cnt);
		resultSet.put("pcnt", pcnt);
		resultSet.put("pList", pList);
		
		return resultSet;
	}

   @Override
   public int updateProduct(DessertDTO ddto, MultipartFile file) {      //admin 상품 수정
      String sourceFileName = file.getOriginalFilename();
      File destinationFile;
      if(sourceFileName==null || sourceFileName.length()==0) {
         if(ddto.getD_image()==null || ddto.getD_image().equals("ready.jpg"))
            ddto.setD_image("ready.jpg");
      }else {
        ddto.setD_image(sourceFileName);
        destinationFile = new File(ddto.getD_path()+sourceFileName);
        destinationFile.getParentFile().mkdirs(); //파일명으로 생성
        try {
           file.transferTo(destinationFile);   //받은 파일 전송(업로드)
        }catch (Exception e) {
           e.printStackTrace();
        }
      }
      return dessertDao.updateProduct(ddto);
   }

   @Override
   public DessertDTO adminGetDessert(int d_no) {      //admin 상품 디테일
      return dessertDao.adminGetDessert(d_no);
   }

   @Override
   public DessertDTO getProduct(int d_no) {      // admin 상품 수정 전 정보 받아오기
      return dessertDao.getProduct(d_no);
   }

   @Override
   public int orderCntOfProduct(int dno) {         // admin 주문내역 확인. 데이터 삭제를 위해서
      return dessertDao.orderCntOfProduct(dno);
   }

   @Override
   public int deleteProduct(DessertDTO ddto) {      //admin 상품 삭제
      return dessertDao.deleteProduct(ddto);
   }

   @Override
   public int updateStocks(Hashtable<Integer, OrderDTO> hCartList) {
      Set<Integer> keys = hCartList.keySet();
      Iterator<Integer> iterKeys = keys.iterator();
      
      List<OrderDTO> list = new ArrayList<>(keys.size());
      
      while(iterKeys.hasNext()) {
    	  list.add(hCartList.get(iterKeys.next()));
      }
      
      return dessertDao.updateStocks(list);
      
   }

}