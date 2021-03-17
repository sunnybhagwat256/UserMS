package com.infosys.user.dto;

import com.infosys.user.entity.Buyer;

public class BuyerDTO {

	
	Integer buyerid;
	String name;
	String email;
	String phonenumber;
	String password;
	Integer isprivileged;
	Integer rewardpoints;
	Integer isactive;

	public BuyerDTO() {
		super();
	}

	public BuyerDTO(Integer buyerid, String name, String email, String phonenumber, String password,
			Integer isprivileged, Integer rewardpoints, Integer isactive) {
		super();
		this.buyerid = buyerid;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.isprivileged = isprivileged;
		this.rewardpoints = rewardpoints;
		this.isactive = isactive;
	}

	public Integer getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(Integer buyerid) {
		this.buyerid = buyerid;
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

	public Integer getIsprivileged() {
		return isprivileged;
	}

	public void setIsprivileged(Integer isprivileged) {
		this.isprivileged = isprivileged;
	}

	public Integer getRewardpoints() {
		return rewardpoints;
	}

	public void setRewardpoints(Integer rewardpoints) {
		this.rewardpoints = rewardpoints;
	}

	public Integer getIsactive() {
		return isactive;
	}

	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}

	@Override
	public String toString() {
		return "BuyerDTO [buyerid=" + buyerid + ", name=" + name + ", email=" + email + ", phonenumber=" + phonenumber
				+ ", password=" + password + ", isprivileged=" + isprivileged + ", rewardpoints=" + rewardpoints
				+ ", isactive=" + isactive + "]";
	}

	// Convert entity to DTO
	public static BuyerDTO valueof(Buyer buyer) {
		BuyerDTO buyerDTO = new BuyerDTO();
		buyerDTO.setBuyerid(buyer.getBuyerid());
		buyerDTO.setEmail(buyer.getEmail());
		buyerDTO.setPhonenumber(buyer.getPhonenumber());
		buyerDTO.setIsactive(buyer.getIsactive());
		buyerDTO.setIsprivileged(buyer.getIsprivileged());
		buyerDTO.setName(buyer.getName());
		buyerDTO.setRewardpoints(buyer.getRewardpoints());
		buyerDTO.setPassword(buyer.getPassword());

		return buyerDTO;
	}

	// Convert DTO to entity
	public Buyer createEntity() {
		Buyer buyer = new Buyer();
		buyer.setBuyerid(this.getBuyerid());
		buyer.setEmail(this.getEmail());
		buyer.setIsactive(this.getIsactive());
		buyer.setIsprivileged(this.getIsprivileged());
		buyer.setName(this.getName());
		buyer.setPassword(this.getPassword());
		buyer.setPhonenumber(this.getPhonenumber());
		buyer.setRewardpoints(this.getRewardpoints());
		return buyer;

	}

}
