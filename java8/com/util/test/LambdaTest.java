package com.util.test;

import org.testng.annotations.Test;

public class LambdaTest {
	
	/**
	 * Lambda当做匿名内部类写法为()->{}，如果所需重写的方法有参数，可写作(e)->{}
	 * 本例为Lambda代替Runnable
	 */
	@Test
	public void innerClassTest() {
		new Thread(()->{
			System.out.println("wkkk");
		}).start();
		//new Thread(()->System.out.println("wkkk")).start();
		
/*		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("old method: wkkk");
			}
		}).start();*/
	}
	//http://www.importnew.com/16436.html
}
