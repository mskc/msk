
import java.util.*;
import java.lang.*;
import java.io.*;

class SameChars
{
	public static void main (String[] args) throws java.lang.Exception
	{
		SameChars sc = new SameChars();
		Scanner s = new Scanner(System.in);
		String s1 = s.next();
		String s2 = s.next();
		if(sc.sameCharCount(s1,s2))
		System.out.println("yes");
		else
		System.out.println("no");
	}
	public boolean sameCharCount(String s1,String s2)
	{
	    if(s1.length() != s2.length())
	    return false;
	    int[] count = new int[128];
	    char[] c = s1.toCharArray();
	    for(int i = 0; i < s1.length(); i++)
	    {
	    	count[c[i]]++;
	    }
	    for(int i = 0; i < s2.length(); i++)
	    {
	    	count[c[i]]--;
	    	if(count[c[i]] < 0)
	    	return false;
	    }
	    return true;
	}
}