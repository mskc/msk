
import java.util.*;
import java.lang.*;
import java.io.*;

class Insertion
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int N = 1454;
		int M = 12;
		System.out.println(toBinary(N));
		System.out.println(toBinary(M));
		System.out.println(toBinary(insertionOfBits(N,M,6,2)));
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
	public static int insertionOfBits(int n, int m, int i,int j){
	    int a = -1 << (i + 1);
	    int t = ((1 << j) - 1);
	    a = a | t;
	    n = n & a;
	    m = m << j;
	    return n | m;
	}
}
