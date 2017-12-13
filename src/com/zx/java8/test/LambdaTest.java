package com.zx.java8.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

import com.zx.reflect.test.User;

public class LambdaTest {
	@Test
	public void listTest1(){
		List<String> list=Arrays.asList("fee","bde","abc","ess","eaa");
		Collections.sort(list, (a,b)->a.compareTo(b));
		//list.stream().filter(s->s.contains("e")).forEach(s->{s=s.replace("e", "h");System.out.print(s);});
		list.forEach(s->{System.out.print(s+" ");});
		System.out.println();
		User u1=new User("wkk", "aaa");
		User u2=new User("wkk","bbb");
		User u3=new User("wk","ccc");
		List<User> ul=Arrays.asList(u1,u2,u3);
		ul.stream().filter(u->u.getName().equals("wkk")).forEach(u->u.setAge(22));
		ul.forEach(u->{System.out.println(u.getAge());});
	}
	
	/**
	 * ȡ��list�е���������ɾ�����ظ���Ԫ�غ󱣴浽��list��
	 */
	@Test
	public void listTest2(){
		List<String> ls=Arrays.asList("1","2","3","4","5","6","7","8","9","2","5","11","10","2");
		List<Integer> li=ls.stream()	//�ȴ���һ����
				.map(a->new Integer(a))	//ͨ��map�����������е�StringԪ��ת����integer
				.filter(a->{			//ͨ��filter���ж����������ظ���
					if(a==1) return false;
					if(a==2) return true;
					for(int i=2;i<=Math.sqrt(a);i++){
						if(a%i==0) return false;
					}
					return true;
				})
				.distinct()				//���أ�ɾ���ظ����ݺ󷵻ظ���
				.collect(Collectors.toList());//������ΪList
		li.forEach(i->{System.out.print(i+" ");});
	}
	/**
	 * 
	 */
	@Test
	public void listTest3(){
		List<String> ls=Arrays.asList("1","2","1","4","8","6","5","8","9","2","5","11","10","2");
		Map<Integer,Integer> map=ls.stream().map(a->new Integer(a)).collect(Collectors.groupingBy(a->a,Collectors.summingInt(a->1)));
		System.out.println(map);
	}
	
	@Test
	public void testn(){
		Double d=null;
		if(d instanceof Double){
			System.out.println("ok");
		}else{
			System.out.println("nu");
		}
	}
}
