

import java.util.*;
import java.lang.*;
import java.io.*;

class OneAway
{
	public static void main (String[] args) throws java.lang.Exception
	{
		OneAway o = new OneAway();
		Scanner s = new Scanner(System.in);
		String s1 = s.next();
		String s2 = s.next();
		if(o.isOneAway(s1,s2))
		System.out.println("yes");
		else
		System.out.println("no");
	}
	public boolean isOneAway(String f, String s)
	{
		String s1 = f.length() < s.length() ? f : s;
		String s2 = f.length() < s.length() ? s : f;
		int index1 = 0;
		int index2 = 0;
		while(index1 < s1.length() && index2 < s2.length())
		{
			boolean diff = false;
			if(s1.charAt(index1) != s2.charAt(index2))
			{
				if(diff)
				return false;
				diff = true;
				if(s1.length() == s2.length())
				index1++;
			}
			else{
				index1++;
			}
			index2++;
		}
		return true;
	}
}