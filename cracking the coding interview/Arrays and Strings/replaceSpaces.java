
import java.util.*;
import java.lang.*;
import java.io.*;

class Replace
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Replace r = new Replace();
		Scanner s = new Scanner(System.in);
		String st = s.nextLine();
		System.out.println(r.replaceSpaces(st.toCharArray(),st.length()));
	}
	public String replaceSpaces(char[] c , int truelength)
	{
		int spacecount = 0;
		int index;
		for(int i = 0; i < truelength; i++)
		{
			if(c[i] == ' ')
			spacecount++;
		}
		index = truelength + spacecount*2;
		if(truelength < c.length)
		c[truelength] = '\0';
		char[] a = new char[index];
		for(int i = truelength-1; i >= 0; i--)
		{
			if(c[i] == ' ')
			{
				a[index - 1] = '0';
				a[index - 2] = '2';
				a[index - 3] = '%';
				index = index - 3;
			}
			else
			{
				a[index - 1] = c[i];
				index--;
			}
		}
		return new String(a);
	}
}