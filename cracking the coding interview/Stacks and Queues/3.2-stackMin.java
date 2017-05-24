/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class MinStack extends Stack<Integer>
{
	Stack<Integer> s;
	public MinStack(){
		s = new Stack<Integer>();
	}
	public void push(int x){
		if(x <= min()){
			s.push(x);
		}
		super.push(x);
	}
	public Integer pop(){
		int value = super.pop();
		if(value == min()){
			s.pop();
		}
		return value;
	}
	public int min(){
		if(s.isEmpty()){
			return Integer.MAX_VALUE;
		}
		return s.peek();
	}
	public static void main(String[] args){
		MinStack m = new MinStack();
		m.push(3);
		m.push(-1);
		m.push(3);
		m.push(0);
		m.push(-2);
		m.push(5);
		System.out.println(m.min());
		System.out.println(m.pop());
		System.out.println(m.pop());
		System.out.println(m.min());
	}
}