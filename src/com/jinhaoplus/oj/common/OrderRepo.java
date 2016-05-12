package com.jinhaoplus.oj.common;

import java.util.LinkedList;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class OrderRepo {
	private static LinkedList<String> repoList = new LinkedList<String>();
	static
	{
		for(int i = 1;i <= 28;i++){
			if(i<10)
				repoList.add("0"+new Integer(i).toString());
			else 
				repoList.add(new Integer(i).toString());
		}
		for(int j = 0;j <= 100;j++){
			Random random = new Random();
			int left = random.nextInt(28);
			int right = random.nextInt(28);
			String temp = repoList.get(left);
			repoList.set(left, repoList.get(right));
			repoList.set(right, temp);
		}
	}
	
	public synchronized static String getOrder(){
		String result;
		if(repoList.size()>0){
			result = repoList.removeLast();
			return result;
		}
		else{
			return "排号结束";
		}
	}
}
