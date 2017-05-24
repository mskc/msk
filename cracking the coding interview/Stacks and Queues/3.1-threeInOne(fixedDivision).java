

import java.util.*;
import java.lang.*;
import java.io.*;

 class FixedMultiStacks{
 	int numberOfStacks = 3;
 	int stackCapacity;
 	int[] values;
 	int[] sizes;
 	public FixedMultiStacks(int capacity){
 		stackCapacity = capacity;
 		values = new int[numberOfStacks*stackCapacity];
 	    sizes = new int[numberOfStacks];
 	}
 	public void push(int stackNum,int value) throws FullStackException{
 		if(isFull(stackNum)){
 			throw new FullStackException("full Stack");
 		}
 		sizes[stackNum]++;
 		values[indexOfTop(stackNum)] = value;
 	}
 	public int pop(int stackNum) throws EmptyStackException{
 		if(isEmpty(stackNum)){
 		throw new EmptyStackException("empty stack");
 		}
 		int topIndex = indexOfTop(stackNum);
 		int value = values[topIndex];
 		sizes[stackNum]--;
 		return value;
 	}
 	public int peek(int stackNum) throws EmptyStackException{
 		if(isEmpty(stackNum)){
 			throw new EmptyStackException("empty stack");
 		}
 		return values[indexOfTop(stackNum)];
 	}
 	public boolean isEmpty(int stackNum){
 		return sizes[stackNum] == 0;
 	}
 	public boolean isFull(int stackNum){
 		return sizes[stackNum] == stackCapacity;
 	}
 	public int indexOfTop(int stackNum){
 		int offset = stackNum * stackCapacity;
 		int size = sizes[stackNum];
 		return offset+size-1;
 	}
 }
 class FullStackException extends Exception {
	private static final long serialVersionUID = 1L;

	public FullStackException(){
        super();
    }

    public FullStackException(String message){
        super(message);
    }
}
class EmptyStackException extends Exception {
	private static final long serialVersionUID = 1L;

	public EmptyStackException(){
        super();
    }

    public EmptyStackException(String message){
        super(message);
    }
}
class Helper{
	public static void main(String args[]) {
		FixedMultiStacks f = new FixedMultiStacks(4);
		try{
		f.push(0,2);
		f.push(0,4);
		f.push(0,3);
		f.push(0,5);
		f.push(1,3);
		f.push(2,8);
		f.push(2,9);
		f.push(2,0);
		f.push(0,2);
		}
		catch(FullStackException e){
			System.out.println("full stack");
		}
		try{
		System.out.println(f.pop(0));
		System.out.println(f.pop(2));
		System.out.println(f.pop(1));
		}
		catch(EmptyStackException e){
			System.out.println("empty stack");
		}
	}
}
