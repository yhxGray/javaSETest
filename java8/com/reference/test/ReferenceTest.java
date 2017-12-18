package com.reference.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.testng.annotations.Test;

public class ReferenceTest {
	
	/**
	 * java8中new可以用A a=A::new;
	 */
	@Test
	public void referenceTest() {
		List<RT> lrt=new ArrayList<RT>();
		RT rt=RT.getRT(RT::new);
		rt.setName("www");
		lrt.add(rt);
		lrt.forEach(RT::print);
		lrt.forEach(RT::printS);
		lrt.forEach(rt::printWithrt);
	}
	
//	public void refer2Test() {
//		
//	}
}

class RT{
	private String name;
	String password;
	
	public static void printST() {
		System.out.println("printST for test");
	}
	
	public static void printS(RT rt) {
		System.out.println("printS RT name is : "+rt.name);
	}
	
	public void print() {
		System.out.println("print RT name is : "+name);
	}
	
	public void printWithrt(RT rt) {
		System.out.println("printWithrt RT name is : "+rt.name);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RT(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public RT() {
		super();
	}
	
	static RT getRT(Supplier<RT> supplier) {
		return supplier.get();
	}
	
}

class R2{
	public void print(RT rt) {
		System.out.println("RT Name is : "+rt.getName());
	}
}
