package com.ust.foodorderingapp.repo;

import java.util.List;

import com.ust.foodorderingapp.model.MenuItem;
import com.ust.foodorderingapp.model.MenuItem.Category;

public interface FoodAppRepo {
	
	public MenuItem addItem(MenuItem item);
	public void deleteItem(long id);
	public MenuItem updateItem(long id,MenuItem item);
	public MenuItem searchItem(String name);
	public List<MenuItem> displayItem();
	public List<MenuItem> filterByCategory(String category);
	
	

}
