package com.restdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AlienResource {
@RequestMapping("aliens")
	public List<Alien> getAliens(){
		List<Alien> aliens = new ArrayList<>();
		
		Alien a1 = new Alien();
		a1.setId(101);
		a1.setName("vinod");
		a1.setPoints(60);
		
		Alien a2 = new Alien();
		a2.setId(101);
		a2.setName("vinod");
		a2.setPoints(60);
		
		return aliens;
	}
}
