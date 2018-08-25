package com.rahul.joveo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ControllerR {
	Map<Integer,String>  jobs ;
	
	@RequestMapping(path = "/job",method = RequestMethod.PUT)
	public ResponseEntity<?> addJob (@RequestBody String name){
		Random rand = new Random();
		int  n = rand.nextInt(500000) + 1;
		if(jobs == null)
			jobs = new HashMap<>();
		jobs.put(n, name);
		return new ResponseEntity<Integer>(n,HttpStatus.ACCEPTED);
		 
	}
	
	@RequestMapping(path="/job/{id}/{name}",method = RequestMethod.POST)
	public ResponseEntity<?> searchJob (@PathVariable int id,@PathVariable String name){
		if(jobs == null|| jobs.get(id) == null){
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		}
		jobs.put(id, name);
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		 
	}
	@RequestMapping(path = "/job/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> getJob (@PathVariable int id){
		if(jobs == null|| jobs.get(id) == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
			
		return new ResponseEntity<String>(jobs.get(id), HttpStatus.ACCEPTED);
		 
	}
	
	@RequestMapping(path = "/job/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<?> delJob (@PathVariable int id){
		if(jobs == null|| jobs.get(id) == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		jobs.remove(id);
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		 
	}

}
