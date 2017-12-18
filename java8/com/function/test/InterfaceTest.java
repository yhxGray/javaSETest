package com.function.test;

import java.util.function.Supplier;

import org.testng.annotations.Test;

public class InterfaceTest {
	
	@Test
	public void defaultTest() {
		IA ia=new A();
		ia.print();
		ia.printB();
		ia=new B();
		ia.print();
		ia.printB();
	}
	
	@Test
	public void staticTest() {
		IA ia=IAFactory.getIA(A::new);
		ia.print();
		ia=IAFactory.getIA(B::new);
		ia.print();
	}
}

interface IA{
	default void print() {
		System.out.println("IA default method");
	}
	
	void printB();
}

class A implements IA{
	@Override
	public void printB() {
		System.out.println("A override method printB()");
	}
}

class B implements IA{
	@Override
	public void printB() {
		System.out.println("B override method printB()");
	}
	
	public void print() {
		System.out.println("B override default method");
	}
}

interface IAFactory{
	
	static IA getIA(Supplier<IA> supplier) {
		return supplier.get();
	}
}