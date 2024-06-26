package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Category;
import com.example.entity.Item;
import com.example.mapper.ItemMapper;

@Service
public class ItemService {

	private final ItemMapper itemMapper;

	@Autowired
	public ItemService(ItemMapper itemMapper) {
		this.itemMapper = itemMapper;
	}

	public List<Item> findAllDeletedAtIsNull() {
		return this.itemMapper.findAllDeletedAtIsNull();
	}

	public Item findById(Integer id) {
		return this.itemMapper.findById(id);
	}

	public void insert(String name, Integer price, Integer categoryId) {
		Item item = new Item();
		item.setName(name);
		item.setPrice(price);

		Category category = new Category();
		category.setId(categoryId);
		item.setCategory(category);
		this.itemMapper.insert(item);
	}

	public void update(Integer id, String name, Integer price, Integer categoryId) {
		Item item = this.itemMapper.findById(id);
		item.setName(name);
		item.setPrice(price);

		Category category = new Category();
		category.setId(categoryId);
		item.setCategory(category);

		this.itemMapper.update(item);
	}

	public void delete(Integer id) {
		Item item = this.itemMapper.findById(id);
		item.setDeletedAt(LocalDateTime.now());
		this.itemMapper.delete(item);
	}

}
