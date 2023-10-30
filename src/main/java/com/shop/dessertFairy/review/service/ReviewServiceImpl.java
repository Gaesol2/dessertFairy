package com.shop.dessertFairy.review.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.review.dao.ReviewDAO;
import com.shop.dessertFairy.review.dto.ReviewDTO;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDAO reviewDao;
	
	@Override
	public int reviewWrite(ReviewDTO rdto, MultipartFile file) {
		String sourceFileName = file.getOriginalFilename();
		File destinationFile;
		
		System.out.println("sourceFileName " + sourceFileName);
		
		rdto.setR_image(sourceFileName);
		destinationFile = new File(rdto.getR_path()+sourceFileName);
		destinationFile.getParentFile().mkdirs(); //파일명으로 생성
		
		try {
			file.transferTo(destinationFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("rdto ====== " + rdto);
		return reviewDao.reviewWrite(rdto);
	}
	

}
