
import java.util.*;
import java.lang.*;
import java.io.*;

class BinaryToString
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    double a = 0.625;
	    System.out.println(binaryConversion(a));
	}
	public static String binaryConversion(double a){
	    if(a >= 1 || a <= 0){
	        return "ERROR";
	    }
	    StringBuilder sb = new StringBuilder();
	    sb.append(".");
	    while(a > 0){
	        if(sb.length() > 32){
	            return "ERROR";
	        }
	        double r = a * 2;
	        if(r >= 1){
	            sb.append("1");
	            a = r - 1;
	        }
	        else{
	            sb.append("0");
	            a = r;
	        }
	    }
	    return sb.toString();
	}
}
