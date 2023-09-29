package com.ust.foodorderingapp.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="menu_item")
@Entity

public class MenuItem {
	@Id
     private long menuItemId;
	@Column(name="item_name" ,length=50, nullable= false ,unique=true)
     private String itemName;
     private double price;
     @Enumerated(EnumType.STRING)
     private Status status;
     public enum Status{AVAILABLE,NOTAVAILABLE;}
     @Enumerated(EnumType.STRING)
     private Category category;
     public enum Category{VEG,NONVEG;}



}