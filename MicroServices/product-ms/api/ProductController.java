package com.mysmartshop.product.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@GetMapping
	public String greet() {
		return "Message from Product Service";
	}

}
