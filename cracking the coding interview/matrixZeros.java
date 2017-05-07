
import java.util.*;
import java.lang.*;
import java.io.*;

class Zeros
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Zeros z = new Zeros();
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int[][] a = new int[m][n];
		for(int i = 0 ; i < m; i++)
		{
			for(int j = 0 ; j < n ; j++)
			a[i][j] = s.nextInt();
		}
		for(int i = 0 ; i < m; i++)
		{
			for(int j = 0 ; j < n ; j++)
			System.out.print(a[i][j]+" ");
			System.out.println();
		}
		System.out.println("output:");
	a = z.zeroMatrix(a);
	for(int i = 0 ; i < m; i++)
		{
			for(int j = 0 ; j < n ; j++)
			System.out.print(a[i][j]+" ");
			System.out.println();
		}
	}
	public int[][] zeroMatrix(int[][] a)
	{
		boolean[] r = new boolean[a.length];
		boolean[] c = new boolean[a[0].length];
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[0].length; j++)
			{
				if(a[i][j] == 0){
				r[i] = true;
				c[j] = true;
				}
			}
		}
		for(int i = 0; i < a.length; i++)
		if(r[i])
		a = rowZero(a,i);
	
		for(int i = 0; i < a[0].length; i++){
		if(c[i])
		a = colZero(a,i);
		}
		return a;
	}
	public int[][] rowZero(int[][] a, int r)
	{
		for(int i = 0 ; i < a[0].length; i++)
		a[r][i] = 0;
		return a;
	}
	public int[][] colZero(int[][] a, int c)
	{
		for(int i = 0 ; i < a.length; i++)
		a[i][c] = 0;
		return a;
	}
}