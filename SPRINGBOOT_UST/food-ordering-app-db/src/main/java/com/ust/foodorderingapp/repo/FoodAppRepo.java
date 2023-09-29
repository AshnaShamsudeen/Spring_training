package com.ust.foodorderingapp.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ust.foodorderingapp.model.MenuItem;
import com.ust.foodorderingapp.model.MenuItem.Category;

public interface FoodAppRepo extends JpaRepository<MenuItem,Long> {
	public Optional<MenuItem>findByItemName(String itemName);
	
	//JPQL
	
	@Query("from MenuItem where Category=:category")
	public List<MenuItem> findItemInCategory(String category);
	
//	public MenuItem addItem(MenuItem item);
//	public void deleteItem(long id);
//	public MenuItem updateItem(long id,MenuItem item);
//	public MenuItem searchItem(String name);
//	public List<MenuItem> displayItem();
//	public List<MenuItem> filterByCategory(String category);
	
	

}
