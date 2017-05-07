/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Power
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Power p = new Power();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		p.powerOfTwo(n);
	}
	public int powerOfTwo(int n )
	{
		if(n < 0)
		return 0;
		else if(n == 1)
		{
			System.out.println(1);
			return 1;
		}
		else
		{
			int previous = powerOfTwo(n/2);
			int current = previous*2;
			System.out.println(current);
			return current;
		}
	}
}