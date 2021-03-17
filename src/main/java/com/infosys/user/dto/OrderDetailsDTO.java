package com.infosys.user.dto;

import java.sql.Date;
import java.util.List;

public class OrderDetailsDTO {
	int orderid;
	int buyerid;
	float amount;
	Date date;
	String address;
	String status;
	List<ProductsOrderedDTO> orderProducts;

	public OrderDetailsDTO() {
		super();
	}

	public OrderDetailsDTO(int orderid, int buyerid, float amount, Date date, String address, String status,
			List<ProductsOrderedDTO> orderProducts) {
		super();
		this.orderid = orderid;
		this.buyerid = buyerid;
		this.amount = amount;
		this.date = date;
		this.address = address;
		this.status = status;
		this.orderProducts = orderProducts;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(int buyerid) {
		this.buyerid = buyerid;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ProductsOrderedDTO> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<ProductsOrderedDTO> orderProducts) {
		this.orderProducts = orderProducts;
	}

	@Override
	public String toString() {
		return "OrderDetailsDTO [orderid=" + orderid + ", buyerid=" + buyerid + ", amount=" + amount + ", date=" + date
				+ ", address=" + address + ", status=" + status + ", orderProducts=" + orderProducts + "]";
	}


}
