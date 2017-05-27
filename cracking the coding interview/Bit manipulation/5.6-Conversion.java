

import java.util.*;
import java.lang.*;
import java.io.*;

class Conversion
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int a = 12;
		int b = 345;
		System.out.println(toBinary(a));
		System.out.println(toBinary(b));
		System.out.println(conversion(a,b));
	}
	public static int conversion(int a,int b){
	    int count = 0;
		for (int c = a ^ b; c != 0; c = c & (c-1)) {
			count++;
		}
	/*	for (int c = a ^ b; c != 0; c = c >>> 1) { 
			count += c & 1;
		}*/
		return count;
	}
		public static String toBinary(int a){
	    String s = "";
	    for(int i = 0; i < 32; i++){
	        Integer t = (a & 1);
	        s = t.toString() + s;
	        a = a >> 1;
	    }
	    return s;
	}
}
