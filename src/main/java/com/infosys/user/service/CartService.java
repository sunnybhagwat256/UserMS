package com.infosys.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.user.dto.CartDTO;
import com.infosys.user.entity.Cart;
import com.infosys.user.entity.CompositeKey;

import com.infosys.user.repository.CartRepository;

@Service
public class CartService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CartRepository cartRepo;

	// get cart details
	public List<CartDTO> getCartDetails() {

		List<Cart> cart = cartRepo.findAll();
		List<CartDTO> cartDTO = new ArrayList<>();
		for (Cart c : cart) {
			CartDTO cartDTO1 = CartDTO.valueOf(c);
			cartDTO.add(cartDTO1);
		}
		return cartDTO;
	}

	// save cart details
	public void AddToCart(CartDTO cartDTO) {
		logger.info("Adding to cart for:" + cartDTO);
		Cart cart = cartDTO.createEntity();
		cartRepo.save(cart);
	}

	// get specific cart item details
	public CartDTO getSpecificCartItemDetails(CompositeKey compositeKey) {
		logger.info(" specific cart item details");
		CartDTO cartDTO = null;
		Optional<Cart> opt = cartRepo.findById(compositeKey);
		if (opt.isPresent()) {
			Cart cart = opt.get();
			cartDTO = CartDTO.valueOf(cart);
		}
		return cartDTO;
	}

	// remove items from cart
	public void removeCartItems(Integer buyerid, Integer prodid) {
		CompositeKey comp = new CompositeKey();
		comp.setBuyerid(buyerid);
		comp.setProdid(prodid);
		cartRepo.deleteById(comp);

	}
}
