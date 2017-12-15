package com.util.test;

import java.util.Optional;

import org.testng.annotations.Test;

public class OptionalTest {
	
	private Optional<String> optional=Optional.ofNullable(null);

	@Test
	public void optionalTest() {
		System.out.println("Is Present:"+optional.isPresent());
		System.out.println("");
	}
	
	@Test
	public void basicTest() {
		System.out.println(optional.orElse("wkk"));
		System.out.println(optional.orElseGet(()->"wkkGet"));
	}
	
}
