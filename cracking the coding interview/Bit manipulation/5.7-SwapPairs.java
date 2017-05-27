
import java.util.*;
import java.lang.*;
import java.io.*;

class swapPairs
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int a = 1354;
		System.out.println(toBinary(a));
		System.out.println(toBinary(swapPairs(a)));
		
	}
	public static int swapPairs(int x){
	    return ( ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1) ); 
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
