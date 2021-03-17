package com.infosys.user.dto;



public class ProductsOrderedDTO {

	int orderid;
	int prodid;
	int sellerid;
	int quantity;
	String status;
	Double price;

	public ProductsOrderedDTO() {
		super();
	}

	public ProductsOrderedDTO(int orderid, int prodid, int sellerid, int quantity, String status, Double price) {
		this();
		this.orderid = orderid;
		this.prodid = prodid;
		this.sellerid = sellerid;
		this.quantity = quantity;
		this.status = status;
		this.price = price;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public int getSellerid() {
		return sellerid;
	}

	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductsOrderedDTO [orderid=" + orderid + ", prodid=" + prodid + ", sellerid=" + sellerid
				+ ", quantity=" + quantity + ", status=" + status + ", price=" + price + "]";
	}

}
