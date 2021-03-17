package com.infosys.user.dto;

import com.infosys.user.entity.Wishlist;

public class WishlistDTO {
	Integer buyerid;
	Integer prodid;
	
	public WishlistDTO() {
		super();
	}
	
	public WishlistDTO(Integer buyerid, Integer prodid) {
		super();
		this.buyerid = buyerid;
		this.prodid = prodid;
	}

	public Integer getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(Integer buyerid) {
		this.buyerid = buyerid;
	}

	public Integer getProdid() {
		return prodid;
	}

	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}

	@Override
	public String toString() {
		return "WishlistDTO [buyerid=" + buyerid + ", prodid=" + prodid + "]";
	}
	
	// Converts Entity into DTO
		public static WishlistDTO valueOf(Wishlist wishlist) {
			WishlistDTO wishlistDTO = new WishlistDTO();
			wishlistDTO.setBuyerid(wishlist.getBuyerid());
			wishlistDTO.setProdid(wishlist.getProdid());
			return wishlistDTO;
		}

		public Wishlist createEntity() {
			Wishlist wishlist = new Wishlist();
			wishlist.setBuyerid(this.getBuyerid());
			wishlist.setProdid(this.getProdid());
			return wishlist;
		}

}
