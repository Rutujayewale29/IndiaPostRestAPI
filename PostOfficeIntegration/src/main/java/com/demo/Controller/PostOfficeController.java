package com.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Service.PostOfficeService;

@RestController
@RequestMapping("/api")
public class PostOfficeController {
@Autowired
PostOfficeService postOfficeService;

@GetMapping("/pin/{pincode}")
List<Map<String,Object>>getbypincode(@PathVariable int pincode)
{
  return postOfficeService.getbypincode(pincode);	
}
	@GetMapping("/branchname/{name}")
	List<Map<String,Object>>getbybranchname(@PathVariable String name)
	{
       return postOfficeService.getbybranchname(name);		
	}
}
