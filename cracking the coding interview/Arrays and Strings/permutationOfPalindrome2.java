

import java.util.*;
import java.lang.*;
import java.io.*;

class PermutationOfPlaindrome
{
	public static void main (String[] args) throws java.lang.Exception
	{
		PermutationOfPlaindrome p = new PermutationOfPlaindrome();
		Scanner s  = new Scanner(System.in);
		String st = s.nextLine();
		if(p.isPalindrome(st))
		System.out.println("yes");
		else
		System.out.println("no");
	}
	public boolean isPalindrome(String s)
	{
		int bitvector = createBitVector(s);
		return bitvector == 0 || checkOdd(bitvector);
	}
	public int createBitVector(String s)
	{
		int bitvector = 0;
		for(char c : s.toCharArray())
		{
			int x = getCharNumber(c);
			bitvector = toggle(bitvector , x);
		}
		return bitvector;
	}
	public int toggle(int bitvector , int x)
	{
		if(x < 0)
		return bitvector;
		int m = 1 << x;
		if((bitvector & m) == 0)
		bitvector = bitvector | m;
		else
		bitvector = bitvector & ~m;
		return bitvector;
	}
	public boolean checkOdd(int bitvector)
	{
		return (bitvector & (bitvector - 1)) == 0;
	}
	public int getCharNumber(char c)
	{
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a <= val && z >= val)
		return val - a;
		return -1;
		
	}
}