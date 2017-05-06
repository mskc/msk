

import java.util.*;
import java.lang.*;
import java.io.*;

class Compression
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Compression c = new Compression();
	     Scanner s = new Scanner(System.in);
	     String st = s.next();
	     System.out.println(c.stringCompression(st));
	}
	public String stringCompression(String s)
	{
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < s.length(); i++)
		{
			count++;
			if((i+1) >= s.length() || s.charAt(i) != s.charAt(i+1))
			{
				sb.append(s.charAt(i));
				sb.append(count);
				count = 0;
			}
		}
		return sb.length() < s.length() ? sb.toString() : s;
	}
}