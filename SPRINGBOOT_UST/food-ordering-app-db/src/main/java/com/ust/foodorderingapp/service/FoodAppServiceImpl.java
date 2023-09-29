package com.ust.foodorderingapp.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ust.foodorderingapp.exception.InvalidCategoryException;
import com.ust.foodorderingapp.exception.ItemNotFoundException;
import com.ust.foodorderingapp.model.MenuItem;
import com.ust.foodorderingapp.model.MenuItem.Category;
import com.ust.foodorderingapp.model.MenuItem.Status;
import com.ust.foodorderingapp.repo.FoodAppRepo;

@Service
public class FoodAppServiceImpl implements FoodAppService {
	
	@Autowired
	FoodAppRepo repo;
	
//	@PostConstruct
//    public void initSomeCustomer() {
//        MenuItem m1=new MenuItem(1001,"Biriyani",Status.AVAILABLE,Category.NONVEG,250);
//        MenuItem m2=new MenuItem(1002,"pasta",Status.AVAILABLE,Category.VEG,340);
//        MenuItem m3=new MenuItem(1003,"noodels",Status.NOTAVAILABLE,Category.NONVEG,450);
//        repo.addItem(m1);
//        repo.addItem(m2);
//        repo.addItem(m3);
//
//    }

	@Override
	public MenuItem addItem(MenuItem item) {
		long id=item.getMenuItemId();
		if(!repo.existsById(id)) {
				throw new ItemNotFoundException("Item with id: "+id+ " not found");
		}
		return repo.save(item);
	}

	@Override
	public void deleteItem(long menuItemId) {
		if(!repo.existsById(menuItemId)) {
			throw new ItemNotFoundException("Item with id: "+menuItemId+ " not found");
		}
		repo.deleteById(menuItemId);
		
	}

	@Override
	public MenuItem updateItem(long id,MenuItem newItem) {
		if(!repo.existsById(id)) {
			throw new ItemNotFoundException("Item with id: "+id+ " not found");
	}
		
		return repo.save(newItem);
	}

	@Override
	public MenuItem searchItem(String itemName) {
		return repo.findByItemName(itemName).orElseThrow(()-> new ItemNotFoundException("Item with name: "+itemName+ "not found"));
	}

	@Override
	public List<MenuItem> displayItem() {
		return repo.findAll();
	}

	@Override
	public List<MenuItem> filterByCategory(String category) {
		try {
			Category fCategory=Category.valueOf(category.toUpperCase());
			
		return repo.findItemInCategory(category.toUpperCase());}
		
		catch(Exception e) {
			throw new InvalidCategoryException("Item with category: "+category+ " not found");
			
		}

	
	
	}

}
