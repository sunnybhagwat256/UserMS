package com.infosys.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buyer")
public class Buyer {

	@Id
	@Column(nullable = false, length = 11)
	Integer buyerid;
	@Column(nullable = false, length = 45)
	String name;
	@Column(nullable = false, length = 45)
	String email;
	@Column(nullable = false, length = 45)
	String phonenumber;
	@Column(nullable = false, length = 45)
	String password;
	@Column(length = 1)
	Integer isprivileged;
	@Column(nullable = false, length = 11)
	Integer rewardpoints;
	@Column(length = 1)
	Integer isactive;

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

}
