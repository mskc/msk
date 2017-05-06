
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
    	int checker = 0;
    	for(int i = 0; i < st.length(); i++)
    	{
    		int c = st.charAt(i) - 'a';
    		if((checker & (1 << c)) > 0)
    		return false;
    		checker = checker | (1 << c);
    	}
    	return true;
    }
}