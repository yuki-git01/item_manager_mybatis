package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.Item;

@Mapper
public interface ItemMapper {
	public List<Item> findAllDeletedAtIsNull();

	public void insert(Item item);
}
