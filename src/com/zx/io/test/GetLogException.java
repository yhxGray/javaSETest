package com.zx.io.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class GetLogException {
	
	public List<String> getErrorLogs(String startDate,String endDate){
		List<String> ls=new ArrayList<>();
		String s="";
		BufferedReader br=null;
		BufferedWriter bw=null;
		try {
			br=new BufferedReader(new InputStreamReader(new FileInputStream(new File("E:\\test\\cutelog.txt"))));
			bw=new BufferedWriter(new FileWriter("E:\\test\\splitcutelog.txt"));
			while((s=br.readLine())!=null){
//				if(s.matches("^.*16-07-0[6-7]\\s15:07:(([4-5][6-8])|(49)|(5[0-5])).*")){
//					ls.add(s);
//				}
				if(s.matches("^.*16-.*$")&&s.length()>17){//����������Ӳ���жϣ�ָ����16�꣬������Ҫ���Խ��и���
					int index=s.indexOf("16-");//�˴���Ҫ������־��д���Խ����ж�
					String dateS=s.substring(index, index+17);//17Ҳ�Ǹ�����־��д����д��Ӳֵ�������ڵ��ַ����ܳ���
					SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd hh:mm:ss");//���ݲ�ͬ��־��ʱ���ʽ���ø�ʽ������Ҫ�ı�
					if(sdf.parse(dateS).compareTo(sdf.parse(startDate))>=0
							&&sdf.parse(dateS).compareTo(sdf.parse(endDate))<=0){
						ls.add(s);
						bw.write(s);
					}
						
					
				}
			}
		} catch (IOException|ParseException e) {
			e.printStackTrace();
		}finally{
			try{
				if(br!=null){
					br.close();
				}
				if(bw!=null){
					bw.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return ls;
	}
	@Test
	public void test() throws ParseException{
		List<String> ls=getErrorLogs("16-07-07 15:07:51","16-07-07 15:07:58");
		ls.forEach(s->System.out.println(s));
	}
	
}
