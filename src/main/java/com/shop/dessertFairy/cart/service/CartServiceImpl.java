package com.shop.dessertFairy.cart.service;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

import com.shop.dessertFairy.order.dto.OrderDTO;

@Service
public class CartServiceImpl implements CartService {

	//hCartList 해시테이블 선언
	private Hashtable<Integer, OrderDTO> hCartList;

	@Override
	public void setCartList(Hashtable<Integer, OrderDTO> hCartList) {
		//hCartList의 setter
		this.hCartList = hCartList;
	}

	@Override
	public Hashtable<Integer, OrderDTO> addCartList(OrderDTO odto) {
		
		//인자로 받은 odto(장바구니에 담을 상품)에서 d_no(상품번호)를 빼서 따로 저장
		int d_no = odto.getD_no();
		
		//인자로 받은 odto(장바구니에 담을 상품)에서 o_quantity(주문 개수)를 빼서 따로 저장
		int quantity = odto.getO_quantity();
		
		//hCartList 해시테이블에 상품번호를 검색해서
		//해당 상품이 이미 장바구니에 있을 경우엔 원래 주문 수와 새로운 주문 수를 더하고
		//해당 상품이 장바구니에 없을 경우엔 새로운 주문 수만 계산해서 odto를 hCartList 해시테이블에 추가한다.
		if(hCartList.contains(d_no)) {
			//hCartList 해시테이블에서 해당 상품 키의 값을 OrderDTO 타입의 oldOdto에 저장
			OrderDTO oldOdto = hCartList.get(d_no);
			
			
			//새로 추가한 상품수와 원래 상품수를 합쳐서 quantity에 저장한다.
			quantity += oldOdto.getO_quantity();
			
			//추가한 상품 수가 상품의 재고 수보다 작은지 큰지 확인한다.
			if(quantity<oldOdto.getD_stock()) {
				//주문 수가 재고 수보다 작으면 주문 수만큼 장바구니에 추가한다.
				oldOdto.setO_quantity(quantity);
			} else {
				//주문 수가 재고 수보다 크면 재고 수만큼만 장바구니에 추가한다.
				oldOdto.setO_quantity(oldOdto.getD_stock());
				//주문 수가 재고 수를 초과했음을 알리는 변수 설정
				int overStock = 1;
			}
			
			//상품이 원래 장바구니에 있었다면, hCartList 해시테이블에 새로 계산한 DTO로 넣어준다.
			hCartList.put(d_no, oldOdto);
		} else {
			//상품이 장바구니에 없었다면, hCartList 해시테이블에 원래 있던 DTO를 넣어준다.
			hCartList.put(d_no, odto);
		}
		
		return hCartList;
	}
	
}
