package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class newcoder {
	public static void main(String[] args){
		StringBuilder stringBuilder = new StringBuilder();
		int[] list = new int[10000];
		for(int i=0;i<10000;i++) {
			list[i]=i;
		}
		long starttime = System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			System.out.print(list[i]+" ");
		}
		System.out.println();
		long endtime = System.currentTimeMillis();
		System.out.println(endtime-starttime);
		starttime = System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			stringBuilder.append(list[i]);
			stringBuilder.append(" ");
		}
		System.out.print(stringBuilder.toString().trim());
		System.out.println();
		endtime = System.currentTimeMillis();
		System.out.println(endtime-starttime);
		
	}
}

