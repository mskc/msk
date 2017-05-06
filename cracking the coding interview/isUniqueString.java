
import java.util.*;
import java.lang.*;
import java.io.*;

class IsUniqueString
{
	public static void main (String[] args) throws java.lang.Exception
	{
		IsUniqueString i = new IsUniqueString();
		Scanner s = new Scanner(System.in);
		String st = s.nextLine();
		if(i.isUnique(st))
		System.out.println("yes");
		else
		System.out.println("no");
	}
    public boolean isUnique(String st)
    {
    	if(st.length() > 128)
    	return false;
    	boolean[] c = new boolean[128];
    	for(int i = 0; i < st.length(); i++)
    	{
    		int val = st.charAt(i);
    		if(c[val])
    		return false;
    		c[val] = true;
    	}
    	return true;
    }
}