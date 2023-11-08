package com.shop.dessertFairy.cart.service;

import java.util.Hashtable;

import com.shop.dessertFairy.order.dto.OrderDTO;

public interface CartService {

	void setCartList(Hashtable<Integer, OrderDTO> hCartList);

	Hashtable<Integer, OrderDTO> addCartList(OrderDTO odto);

	Hashtable<Integer, OrderDTO> updateCartList(OrderDTO odto);

	Hashtable<Integer, OrderDTO> deleteCartList(OrderDTO odto);
		
}
