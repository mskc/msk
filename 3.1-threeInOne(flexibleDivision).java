

import java.util.*;
import java.lang.*;
import java.io.*;

class MultiStack{
	private class StackInfo{
		public int size,start,capacity;
		public StackInfo(int start,int capacity){
			this.start = start;
			this.capacity = capacity;
		}
		public boolean isWithinStackCapacity(int index){
			if(index < 0 || index >= values.length){
			return false;
			}
			int contiguousIndex = index < start ? index + values.length : index;
			int end = start + capacity;
			return start <= contiguousIndex && contiguousIndex < end;
		}
		public int lastCapacityIndex()
		{
			return adjustIndex(start + capacity -1);
		}
		public int lastElementIndex(){
			return adjustIndex(start + size - 1);
		}
		public boolean isFull(){
			return size == capacity;
		}
		public boolean isEmpty(){
			return size == 0;
		}
	}
	private StackInfo[] info;
	private int[] values;
	public MultiStack(int numberOfStacks,int defaultSize){
		info = new StackInfo[numberOfStacks];
		for(int i = 0; i < numberOfStacks; i++){
			info[i] = new StackInfo(defaultSize*i,defaultSize);
		}
		values = new int[numberOfStacks*defaultSize];
	}
	public void push(int stackNum,int value) throws FullStackException{
		if(allStacksAreFull()){
			throw new FullStackException();
		}
		StackInfo stack = info[stackNum];
		if(stack.isFull()){
			expand(stackNum);
		}
		stack.size++;
		values[stack.lastElementIndex()] = value;
	}
	public int pop(int stackNum) throws EmptyStackException{
		StackInfo stack = info[stackNum];
		if(stack.isEmpty()){
			throw new EmptyStackException();
		}
		int value = values[stack.lastElementIndex()];
		values[stack.lastElementIndex()] = 0;
		stack.size--;
		return value;
	}
	public int peek(int stackNum) throws EmptyStackException{
		StackInfo stack = info[stackNum];
		if(stack.isEmpty()){
			throw new EmptyStackException();
		}
		return values[stack.lastElementIndex()];
	}
	public void shift(int stackNum){
		StackInfo stack = info[stackNum];
		if(stack.size >= stack.capacity){
			int nextStack = (stackNum + 1)%info.length;
			shift(nextStack);
			stack.capacity++;
		}
		int index = stack.lastCapacityIndex();
		while(stack.isWithinStackCapacity(index)){
			values[index] = values[previousIndex(index)];
			index = previousIndex(index);
	    }
	    values[stack.start] = 0;
	    stack.start = nextIndex(stack.start);
	    stack.capacity--;
	}
	public void expand(int stackNum){
		shift((stackNum + 1)%info.length);
		info[stackNum].capacity++;
	}
	public int numberOfElements(){
		int size = 0;
		for(StackInfo sd : info){
			size = size + sd.size;
		}
		return size;
	}
	public boolean allStacksAreFull(){
		return numberOfElements() == values.length;
	}
	public int adjustIndex(int index){
		int max = values.length;
		return ((index % max) + max)%max;
    }
    private int nextIndex(int index){
    	return adjustIndex(index + 1);
    }
    private int previousIndex(int index){
    	return adjustIndex(index - 1);
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
	public static void main(String[] args){
		MultiStack m = new MultiStack(3,4);
		try{
			m.push(0,1);
			m.push(1,2);
			m.push(2,5);
			m.push(1,6);
			m.push(1,7);
			m.push(1,8);
			m.push(1,9);
			m.push(1,3);
			m.push(1,1);
			m.push(2,3);
			m.push(2,4);
			m.push(2,5);
			m.push(0,7);
		}
		catch(FullStackException e){
			System.out.println("stack is full");
		}
		try{
			System.out.println(m.pop(1));
			System.out.println(m.pop(1));
			System.out.println(m.pop(1));
			System.out.println(m.pop(2));
			System.out.println(m.pop(0));
			System.out.println(m.pop(0));
		}
		catch(EmptyStackException e){
			System.out.println("stack is empty");
		}
	}
}