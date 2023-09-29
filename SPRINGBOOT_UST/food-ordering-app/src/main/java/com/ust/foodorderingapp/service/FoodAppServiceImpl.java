package com.ust.foodorderingapp.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.foodorderingapp.model.MenuItem;
import com.ust.foodorderingapp.model.MenuItem.Category;
import com.ust.foodorderingapp.model.MenuItem.Status;
import com.ust.foodorderingapp.repo.FoodAppRepo;

@Service
public class FoodAppServiceImpl implements FoodAppService {
	
	@Autowired
	FoodAppRepo repo;
	
	@PostConstruct
    public void initSomeCustomer() {
        MenuItem m1=new MenuItem(1001,"Biriyani",Status.AVAILABLE,Category.NONVEG,250);
        MenuItem m2=new MenuItem(1002,"pasta",Status.AVAILABLE,Category.VEG,340);
        MenuItem m3=new MenuItem(1003,"noodels",Status.NOTAVAILABLE,Category.NONVEG,450);
        repo.addItem(m1);
        repo.addItem(m2);
        repo.addItem(m3);

    }

	@Override
	public MenuItem addItem(MenuItem item) {
		return repo.addItem(item);
	}

	@Override
	public void deleteItem(long id) {
		repo.deleteItem(id);
		
	}

	@Override
	public MenuItem updateItem(long id,MenuItem item) {
		return repo.updateItem(id, item);
	}

	@Override
	public MenuItem searchItem(String name) {
		return repo.searchItem(name);
	}

	@Override
	public List<MenuItem> displayItem() {
		return repo.displayItem();
	}

	@Override
	public List<MenuItem> filterByCategory(String category) {
		return repo.filterByCategory(category);
	}

}
