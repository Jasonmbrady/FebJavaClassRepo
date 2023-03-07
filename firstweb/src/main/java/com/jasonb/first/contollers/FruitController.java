package com.jasonb.first.contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fruit")
public class FruitController {
	
	@GetMapping("/view/{id}")
	public String viewFruit(@PathVariable("id") Long id) {
		return "fruit number " + id;
	}
}
