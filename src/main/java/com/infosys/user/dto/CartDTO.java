package com.infosys.user.dto;

import com.infosys.user.entity.Cart;

public class CartDTO {

	Integer buyerid;
	Integer prodid;
	Integer quantity;

	public CartDTO() {
		super();
	}

	public CartDTO(Integer buyerid, Integer prodid, Integer quantity) {
		super();
		this.buyerid = buyerid;
		this.prodid = prodid;
		this.quantity = quantity;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartDTO [buyerid=" + buyerid + ", prodid=" + prodid + ", quantity=" + quantity + "]";
	}

	// Converts Entity into DTO
	public static CartDTO valueOf(Cart cart) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setBuyerid(cart.getBuyerid());
		cartDTO.setProdid(cart.getProdid());
		cartDTO.setQuantity(cart.getQuantity());
		return cartDTO;
	}

	// Converts DTO into Entity
	public Cart createEntity() {
		Cart cart = new Cart();
		cart.setBuyerid(this.getBuyerid());
		cart.setProdid(this.getProdid());
		cart.setQuantity(this.getQuantity());
		return cart;
	}

}
