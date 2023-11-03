package com.shop.dessertFairy.cart.service;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

import com.shop.dessertFairy.order.dto.OrderDTO;

@Service
public class CartServiceImpl implements CartService {

	private Hashtable<Integer, OrderDTO> hCartList;
}
