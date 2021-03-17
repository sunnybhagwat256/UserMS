package com.infosys.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infosys.user.entity.CompositeKey;
import com.infosys.user.dto.CartDTO;
import com.infosys.user.service.CartService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/cart")
public class CartController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CartService cartService;

	// get all cart details
	@GetMapping(value = "/cartdata", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CartDTO> getCartData() {
		return cartService.getCartDetails();
	}

	// add to cart
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> AddToCart(@RequestBody CartDTO cartDTO) {
		cartService.AddToCart(cartDTO);
		return new ResponseEntity<String>("cart items added successfully", HttpStatus.OK);
	}

	// get specific cart item
	@GetMapping(value = "/cartdata/{buyerid}/{prodid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CartDTO getSpecificCartItemDetails(@PathVariable Integer buyerid, @PathVariable Integer prodid) {
		CompositeKey compositeKey = new CompositeKey();
		compositeKey.setBuyerid(buyerid);
		compositeKey.setProdid(prodid);
		CartDTO dto = cartService.getSpecificCartItemDetails(compositeKey);

		return dto;
	}

	// deleted cart item
	@DeleteMapping(value = "/remove/{buyerid}/{prodid}")
	public ResponseEntity<String> removeCartItems(@PathVariable Integer buyerid, @PathVariable Integer prodid) {
		cartService.removeCartItems(buyerid, prodid);
		ResponseEntity<String> response = new ResponseEntity<String>("Cart items deleted successfully", HttpStatus.OK);
		return response;
	}
}
