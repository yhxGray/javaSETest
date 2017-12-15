package com.collections.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ListTest {

	private List<String> list=new ArrayList<>();
	
	@BeforeTest
	public void init() { 
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		list.add("wkk");
	}
	
	@Test
	public void test() {
		list.forEach(o->System.out.println(o));
	}
	
}
