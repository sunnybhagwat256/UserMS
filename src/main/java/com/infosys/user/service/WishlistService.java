package com.infosys.user.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infosys.user.dto.WishlistDTO;
import com.infosys.user.entity.CompositeKey;
import com.infosys.user.entity.Wishlist;
import com.infosys.user.repository.WishlistRepository;

@Service
public class WishlistService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	WishlistRepository wishlistRepo;

	public void AddToWishlist(WishlistDTO wishlistDTO) {
		logger.info("Adding to wishlist for:" + wishlistDTO);
		Wishlist wishlist = wishlistDTO.createEntity();
		wishlistRepo.save(wishlist);
	}

	// get wishlist details
	public List<WishlistDTO> getWishlist() {

		List<Wishlist> wishlist = wishlistRepo.findAll();
		List<WishlistDTO> wishlistDTO = new ArrayList<>();
		for (Wishlist w : wishlist) {
			WishlistDTO wishlistDTO1 = WishlistDTO.valueOf(w);
			wishlistDTO.add(wishlistDTO1);
		}
		return wishlistDTO;
	}

	public void removeWishlistItems(CompositeKey compositeKey) {
		logger.info("removing wishlist items for:" + compositeKey);
		Wishlist wishlist = wishlistRepo.findById(compositeKey).orElse(null);
		if (wishlist != null) {
			wishlistRepo.deleteById(compositeKey);
		}

	}

}
