

import java.util.*;
import java.lang.*;
import java.io.*;

class PermutationOfPalindrome
{
	public static void main (String[] args) throws java.lang.Exception
	{
		PermutationOfPalindrome p = new PermutationOfPalindrome();
		Scanner s = new Scanner(System.in);
		String st = s.nextLine();
		if(p.isPermutation(st))
		System.out.println("yes");
		else
		System.out.println("no");
	}
	public boolean isPermutation(String s)
	{
		int[] t = getCharTable(s);
		return checkOdd(t);
	}
	public boolean checkOdd(int[] t)
	{
		boolean odd = false;
		for(int i = 0; i < t.length; i++)
		{
			if(t[i] % 2 == 1)
			{
				if(odd == true)
				return false;
				odd = true;
			}
		}
		return true;
	}
	public int[] getCharTable(String s)
	{
		int[] t = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for(char c : s.toCharArray())
		{
			int x = getCharNumber(c);
			if(x != -1)
			t[x]++;
		}
		return t;
	}
	public int getCharNumber(char c)
	{
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a <= val && val <= z)
		return val - a;
		return -1;
	}
}