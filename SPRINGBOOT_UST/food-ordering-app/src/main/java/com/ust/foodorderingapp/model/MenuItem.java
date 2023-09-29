package com.ust.foodorderingapp.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MenuItem {
     private long menuItemId;
     private String itemName;
     private Status status;
     private Category category;
     private double price;
     @Enumerated
     public enum Status{AVAILABLE,NOTAVAILABLE;}
     public enum Category{VEG,NONVEG;}



}