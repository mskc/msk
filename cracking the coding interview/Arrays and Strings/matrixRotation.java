
import java.util.*;
import java.lang.*;
import java.io.*;

class Rotate
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Rotate r  = new Rotate();
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int[][] a = new int[m][n];
		for(int i = 0 ;i < m; i++)
		{
			for(int j = 0; j < n; j++ )
			{
				a[i][j] = s.nextInt();
			}
		}
		for(int i = 0; i < m; i++)
			{
				for(int j = 0; j < n; j++)
				{
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("rotated matrix is");
		if(r.rotateMatrix(a)){
			for(int i = 0; i < m; i++)
			{
				for(int j = 0; j < n; j++)
				{
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	public boolean rotateMatrix(int[][] a)
	{
		if(a.length != a[0].length || a.length == 0)
		return false;
		int n = a.length;
		for(int i = 0; i < n/2; i++)
		{
			int first = i;
			int last = n-1-i;
			for(int j = first; j < last; j++)
			{
				int offset = j - first;
				int top = a[first][j];
				a[first][j] = a[last-offset][first];
				a[last-offset][first] = a[last][last-offset];
				a[last][last-offset] = a[j][last];
				a[j][last] = top;
			}
		}
		return true;
	}
}