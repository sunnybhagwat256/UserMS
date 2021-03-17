package com.infosys.user.dto;

import com.infosys.user.entity.Seller;

public class SellerDTO {
	Integer sellerid;
	String name;
	String email;
	String phonenumber;
	String password;
	Integer isactive;
	public SellerDTO() {
		super();
	}
	public SellerDTO(Integer sellerid, String name, String email, String phonenumber, String password,
			Integer isactive) {
		super();
		this.sellerid = sellerid;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.isactive = isactive;
	}
	public Integer getSellerid() {
		return sellerid;
	}
	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	@Override
	public String toString() {
		return "SellerDTO [sellerid=" + sellerid + ", name=" + name + ", email=" + email + ", phonenumber="
				+ phonenumber + ", password=" + password + ", isactive=" + isactive + "]";
	}
	
	// Converts Entity into DTO
		public static SellerDTO valueOf(Seller seller) {
			SellerDTO sellerDTO = new SellerDTO();
			sellerDTO.setSellerid(seller.getSellerid());
			sellerDTO.setName(seller.getName());
			sellerDTO.setEmail(seller.getEmail());
			sellerDTO.setPhonenumber(seller.getPhonenumber());
			sellerDTO.setPassword(seller.getPassword());
			sellerDTO.setIsactive(seller.getIsactive());
			return sellerDTO;
		}

		// Converts DTO into Entity
		public Seller createEntity() {
			Seller seller = new Seller();
			seller.setSellerid(this.getSellerid());
			seller.setName(this.getName());
			seller.setEmail(this.getEmail());
			seller.setPhonenumber(this.phonenumber);
			seller.setPassword(this.getPassword());
			seller.setIsactive(this.getIsactive());
			return seller;
		}
	
	
}
