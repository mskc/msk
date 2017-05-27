
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int a = 12;
		System.out.println(a+ " " +toBinary(a));
		System.out.println(getNext(a)+ " " +toBinary(getNext(a)));
		System.out.println(getPrev(a)+ " " +toBinary(getPrev(a)));
		
	}
	public static int getNext(int n) {
		int c = n;
		int c0 = 0;
		int c1 = 0;
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}
		
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}
		
		/* Arithmetically:
		 * 2^c0 = 1 << c0
		 * 2^(c1-1) = 1 << (c0 - 1)
		 * next = n + 2^c0 + 2^(c1-1) - 1;
		 */
		
		return n + (1 << c0) + (1 << (c1 - 1)) - 1;
	}
	
	public static int getPrev(int n) {
		int temp = n;
		int c0 = 0;
		int c1 = 0;
		while (((temp & 1) == 1) && (temp != 0)) {
			c1++;
			temp >>= 1;
		}
		
		if (temp == 0) { 
			return -1;
		}
		
		while ((temp & 1) == 0 && (temp != 0)) {
			c0++;
			temp >>= 1;
		}

		/* Arithmetic:
		 * 2^c1 = 1 << c1
		 * 2^(c0 - 1) = 1 << (c0 - 1)
		 */
		return n - (1 << c1) - (1 << (c0 - 1)) + 1;		
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
