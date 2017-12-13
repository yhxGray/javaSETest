package com.zx.exception.test;

import org.testng.annotations.Test;

public class ThrowExceptionTest {
	/**
	 * ���׳�һ���쳣ʱ���������쳣������·����뽫����ִ�У�ֱ��ĳ������������try catch��
	 * ���һֱû��try catch����ᴫ��JVM����ֹ��������
	 */
	@Test
	public void ThrowRuntimeExceptionTest(){
		String a_B_c="";
		System.out.println(a_B_c);
		try{
			testbb();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("kkkk");
		}
		System.out.println("continue");
	}
	
	@Test
	public void testbb(){
		Testaa();
		System.out.println("ssss");
	}
	
	@Test
	public void Testaa(){
		String a=null;
		if(a==null) raise();
		String b="wkk";
		System.out.println(b);
	}
	
	public void raise(){
		throw new RuntimeException();
	}
}
