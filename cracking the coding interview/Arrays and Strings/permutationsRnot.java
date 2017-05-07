
import java.util.*;
import java.lang.*;
import java.io.*;

class Permutation
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Permutation p = new Permutation();
		Scanner s = new Scanner(System.in);
		String s1 = s.next();
		String s2 = s.next();
		if(p.permutations(s1,s2))
		System.out.println("yes");
		else
		System.out.println("no");
	}
	public boolean permutations(String s1,String s2)
	{
		if(s1.length() != s2.length())
		return false;
		return sort(s1).equals(sort(s2));
	}
	public String sort(String s)
	{
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}