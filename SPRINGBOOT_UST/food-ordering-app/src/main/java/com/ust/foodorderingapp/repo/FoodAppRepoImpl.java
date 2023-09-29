package com.ust.foodorderingapp.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ust.foodorderingapp.exception.InvalidCategoryException;
import com.ust.foodorderingapp.exception.ItemNotFoundException;
import com.ust.foodorderingapp.model.MenuItem;
import com.ust.foodorderingapp.model.MenuItem.Category;

@Repository
public class FoodAppRepoImpl implements FoodAppRepo {
	
	List<MenuItem> itemList=new ArrayList<>();

	@Override
	public MenuItem addItem(MenuItem item) {
		itemList.add(item);
		return item;
	}

	@Override
	public void deleteItem(long id) {
		MenuItem delItem=null;
		for(MenuItem item:itemList) {
			if(item.getMenuItemId()==id) {
				delItem=item;
				break;
			}
		}
		if(delItem==null) {
			throw new ItemNotFoundException("item not found");
		}
		itemList.remove(delItem);
		
	}

	@Override
	public MenuItem updateItem(long id, MenuItem item) {
		MenuItem oldItem=null;
		for(MenuItem item1:itemList) {
			if(item1.getMenuItemId()==id) {
				oldItem=item1;
				break;
			}
		}
		itemList.remove(oldItem);
		oldItem.setPrice(item.getPrice());
		itemList.add(oldItem);
		return oldItem;
	}

	@Override
	public MenuItem searchItem(String name) {
		MenuItem searchItem=null;
		for(MenuItem item:itemList) {
			if(item.getItemName().equalsIgnoreCase(name)){
				return item;
			}
		}
		if (searchItem==null) {
			throw new ItemNotFoundException("Item not found");
		}
     
		return searchItem;
	}

	@Override
	public List<MenuItem> displayItem() {
		return itemList;
	}

	@Override
	public List<MenuItem> filterByCategory(String category) {
		try {
			
		Category errCategory=Category.valueOf(category.toUpperCase());
		List<MenuItem> categories=new ArrayList<>();
		for(MenuItem item:itemList) {
			if(item.getCategory()==errCategory) {
				categories.add(item);
			}
		}
		return categories;
	}
		catch(Exception e) {
			throw new InvalidCategoryException("category not found");
		}
}
}
