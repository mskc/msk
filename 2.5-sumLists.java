

import java.util.*;
import java.lang.*;
import java.io.*;
class Node{
	int data;
	Node next;
	public Node(int value){
		data = value;
	}
}
class LinkedList{
	Node head;
	public void append(int data){
		if(head == null){
			head = new Node(data);
			return ;
		}
		Node current = head;
		while(current.next!=null){
			current = current.next;
		}
		current.next = new Node(data);
}
}
class Sum
{
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		list1.append(1);
		list1.append(2);
		list1.append(5);
		list2.append(7);
	    list2.append(5);
	    list2.append(6);
		Sum s = new Sum();
		s.print(s.sum1(list1.head,list2.head,0));
	}
	public void print(Node head){
		if(head == null)
		return;
		while(head!=null){
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	public Node sum1(Node l1,Node l2,int carrier){
		if(l1 == null && l2 == null && carrier == 0)
		return null;
		int value = carrier;
		if(l1 != null){
			value = value + l1.data;
		}
		if(l2 != null){
			value = value + l2.data;
		}
		Node result = new Node(value%10);
		if(l1!=null && l2!=null){
		Node nxt = sum1((l1 == null)?null:l1.next,(l2 == null)?null:l2.next,(value>=10)?1:0);
		result.next = nxt;
		}
		return result;
	}
}
