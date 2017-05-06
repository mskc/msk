
import java.util.*;
import java.lang.*;
import java.io.*;

class Permutations
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Permutations p = new Permutations();
		Scanner s = new Scanner(System.in);
		String st = s.next();
		p.permutationOfString(st);
	}
	public void permutationOfString(String st)
	{
		permutationOfString(st,"");
	}
	public void permutationOfString(String st,String prefix)
	{
		if(st.length() == 0)
		System.out.println(prefix);
		else{
			for(int i = 0; i < st.length(); i++)
			{
				String r = st.substring(0,i) + st.substring(i+1);
				permutationOfString(r , prefix + st.charAt(i));
			}
		}
	}
}