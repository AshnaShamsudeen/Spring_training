package com.ust.foodorderingapp.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ust.foodorderingapp.model.MenuItem;
import com.ust.foodorderingapp.model.MenuItem.Category;
import com.ust.foodorderingapp.service.FoodAppService;
 
@RestController
@RequestMapping("/api/foodapp")
public class FoodAppRestController {

    @Autowired
    private FoodAppService service;

    
    @ResponseStatus(code=HttpStatus.CREATED)
    @PostMapping
    public MenuItem addItem(@RequestBody MenuItem item) {
        return service.addItem(item);
    }
    
    @ResponseStatus(code=HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable long id) {
    	service.deleteItem(id);
    	
    }
    
    @ResponseStatus(code=HttpStatus.OK)
    @PutMapping("/{id}")
    public MenuItem updateItem(@PathVariable long id,@RequestBody MenuItem item) {
    	return service.updateItem(id, item);
    }
    
    @ResponseStatus(code=HttpStatus.OK)
    @GetMapping("/name/{name}")
   	public MenuItem searchItem(@PathVariable String name) {
    	return service.searchItem(name);
    }
    
    @ResponseStatus(code=HttpStatus.OK)
    @GetMapping
    public List<MenuItem> displayItem(){
        return service.displayItem();
    }
    
    @ResponseStatus(code=HttpStatus.OK)
    @GetMapping("/{category}")
    public List<MenuItem>filterByCategoryList(@PathVariable String category){
    	return service.filterByCategory(category);
    	
    }
    


    
    
}
