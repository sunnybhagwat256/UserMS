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
import org.springframework.web.bind.annotation.RestController;
import com.infosys.user.dto.WishlistDTO;
import com.infosys.user.entity.CompositeKey;
import com.infosys.user.service.WishlistService;

@RestController
@CrossOrigin
public class WishlistController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	WishlistService wishlistService;

	// add to Wishlist
	@PostMapping(value = "/wishlist", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> AddToWishlist(@RequestBody WishlistDTO wishlistDTO) {
		wishlistService.AddToWishlist(wishlistDTO);
		return new ResponseEntity<String>("items added to wishlist successfully", HttpStatus.OK);
	}

	// get wishlist details
	@GetMapping(value = "/wishlistdata", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<WishlistDTO> getWishlistData() {
		return wishlistService.getWishlist();
	}

	// delete wishlist item
	@DeleteMapping(value = "/wishlist/{buyerid}/{prodid}")
	public ResponseEntity<String> removeWishlistItems(@PathVariable CompositeKey compositeKey) {
		wishlistService.removeWishlistItems(compositeKey);
		return new ResponseEntity<String>("Wishlist items deleted successfully", HttpStatus.OK);
	}
}
