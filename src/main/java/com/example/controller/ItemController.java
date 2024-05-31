package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Category;
import com.example.entity.Item;
import com.example.form.ItemForm;
import com.example.service.CategoryService;
import com.example.service.ItemService;

@Controller
@RequestMapping
public class ItemController {

	private final ItemService itemService;
	private final CategoryService categoryService;

	@Autowired
	public ItemController(ItemService itemService, CategoryService categoryService) {
		this.itemService = itemService;
		this.categoryService = categoryService;
	}

	@GetMapping("/index")
	public String index(Model model) {
		List<Item> items = this.itemService.findAllDeletedAtIsNull();
		model.addAttribute("items", items);
		return "index";
	}

	@GetMapping("/create")
	public String showCreate(@ModelAttribute("itemForm") ItemForm itemForm, Model model) {
		List<Category> categories = this.categoryService.findAll();
		model.addAttribute("categories", categories);
		return "create";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute("itemForm") ItemForm itemForm) {
		this.itemService.insert(itemForm.getName(), itemForm.getPrice(), itemForm.getCategoryId());
		return "redirect:/index";
	}

	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable("id") Integer id, Model model, @ModelAttribute("itemForm") ItemForm itemForm) {
		Item item = this.itemService.findById(id);
		itemForm.setName(item.getName());
		itemForm.setPrice(item.getPrice());
		itemForm.setCategoryId(item.getCategory().getId());

		List<Category> categories = this.categoryService.findAll();

		model.addAttribute("categories", categories);
		return "edit";
	}
}
