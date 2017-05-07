

import java.util.*;
import java.lang.*;
import java.io.*;

class StringRot
{
	public static void main (String[] args) throws java.lang.Exception
	{
		StringRot sr = new StringRot();
		Scanner s = new Scanner(System.in);
		String s1 = s.next();
		String s2 = s.next();
		if(sr.stringRotation(s1,s2))
		System.out.println("yes");
		else
		System.out.println("no");
	}
	public boolean stringRotation(String s1,String s2)
	{
		if(s1.length() != s2.length() || s1.length() == 0 || s2.length() == 0)
		return false;
		String s = s1 + s1;
		return s.contains(s2);
		
	}
}