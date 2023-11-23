package com.shop.dessertFairy.cake.service;


import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.cake.dao.CakeDAO;
import com.shop.dessertFairy.cake.dto.CakeDTO;

@Service
public class CakeServiceImpl implements CakeService {
	
	@Autowired
	CakeDAO cakeDao;

	@Override
	public int cakeOrderProc(CakeDTO cdto, MultipartFile file) {
		
		String sourceFileName = file.getOriginalFilename();
	    File destinationFile;
	    
	    cdto.setC_image(sourceFileName);
	    destinationFile = new File(cdto.getC_path()+sourceFileName);
	    destinationFile.getParentFile().mkdirs();
	    
	    try {
	         file.transferTo(destinationFile);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	    
		return cakeDao.cakeOrderProc(cdto);
	}
	
	
	

}
