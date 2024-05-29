package com.example.entity;

import java.time.LocalDateTime;

public class Item {
	private Integer id;
	private String name;
	private Integer price;
	private LocalDateTime deletedAt;
	private Category category;
	private Integer stock;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public LocalDateTime getDeletedAt() {
		return this.deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getStock() {
		return this.stock;
	}

	public Category getCategory() {
		return this.category;
	}

}
