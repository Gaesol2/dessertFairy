package com.shop.dessertFairy.dessert.service;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.dessert.dao.DessertDAO;
import com.shop.dessertFairy.dessert.dto.DessertDTO;

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
	public int insertProduct(DessertDTO ddto, MultipartFile file) {
		String sourceFileName = file.getOriginalFilename();
		File destinationFile;
		if(sourceFileName==null || sourceFileName.length()==0) {
		  ddto.setD_image("ready.gif");
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
	public Map<String, Object> getProductList(PageDTO pdto) {
	
		int cnt = dessertDao.getProductCnt();
		Map<String, Object> resultSet = new HashMap<String, Object>();
		List<DessertDTO> pList = dessertDao.getProducttList();
		resultSet.put("pcnt", cnt);
		resultSet.put("pList", pList);
		
		return resultSet;
	}

	@Override
	public int updateProduct(DessertDTO ddto, MultipartFile file) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DessertDTO adminGetDessert(int d_no) {		//admin 상품 디테일
		return dessertDao.adminGetDessert(d_no);
	}

	@Override
	public DessertDTO getProduct(int d_no) {
		return dessertDao.getProduct(d_no);
	}


}