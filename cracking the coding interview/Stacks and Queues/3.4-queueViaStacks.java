/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Queue
{
	Stack<Integer> stackNew,stackOld;
	public Queue(){
		stackNew = new Stack<Integer>();
		stackOld = new Stack<Integer>();
	}
	public int size(){
		return stackNew.size() + stackOld.size();
	}
	public void add(int value){
		stackNew.push(value);
	}
	public void shiftStacks(){
		if(stackOld.isEmpty()){
			while(!stackNew.isEmpty()){
				stackOld.push(stackNew.pop());
			}
		}
	}
	public int peek(){
		shiftStacks();
		return stackOld.peek();
	}
	public int remove(){
		shiftStacks();
		return stackOld.pop();
	}
	public static void main(String[] args){
		Queue q = new Queue();
		q.add(1);
		q.add(8);
		q.add(2);
		q.add(3);
		q.add(4);
		System.out.println(q.peek());
		q.remove();
		System.out.println(q.peek());
		q.remove();
		System.out.println(q.peek());
	}
}