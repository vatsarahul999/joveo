package com.rahul.joveo.controller;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;


@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
	@InjectMocks
	private ControllerR contrer;
	
	private int id;
	
	@Test
	public void testAdd(){
		ResponseEntity<?> s = contrer.addJob("name");
		boolean res = s.getBody()!=null;
		assertEquals(res,true);
		id = (Integer)s.getBody();
	}
	
	@Test
	public void testRead(){
		ResponseEntity<?> s = contrer.addJob("name");
		boolean res = s.getBody()!=null;
		assertEquals(res,true);
		id = (Integer)s.getBody();
		s = contrer.getJob(id);
		assertEquals("name", (String)s.getBody());
	}

}
