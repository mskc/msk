
import java.util.*;
import java.lang.*;
import java.io.*;

class FlipBits
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int a = 123;
		System.out.println(toBinary(a));
		System.out.println(flipBits(a));
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
	public static int flipBits(int a){
	    if(a == -1){
	        return Integer.BYTES * 8;
	    }
	    int currentLength = 0;
	    int previousLength = 0;
	    int maxLength = 1;
	    while(a != 0){
	        if((a & 1) == 1){
	            currentLength++;
	        }
	        else if((a & 1) == 0){
	            previousLength = (a & 2) == 0 ? 0 : currentLength;
	            currentLength = 0;
	        }
	        maxLength = Math.max(previousLength + currentLength + 1,maxLength);
	        a = a >> 1;
	    }
	    return maxLength;
	}
}
