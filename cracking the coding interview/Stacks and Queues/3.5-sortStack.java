/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class SortStack
{
	public void sort(Stack<Integer> s){
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()){
			int value = s.pop();
			while(!r.isEmpty() && r.peek() > value)
				s.push(r.pop());
			r.push(value);
		}
		while(!r.isEmpty())
			s.push(r.pop());
		print(s);
	}
	public void print(Stack<Integer> s){
		while(!s.isEmpty()){
			System.out.println(s.peek());
			s.pop();
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Stack<Integer> s = new Stack<Integer>();
		s.push(6);
		s.push(7);
		s.push(3);
		s.push(9);
		s.push(8);
		SortStack ss = new SortStack();
		ss.sort(s);
	}
}