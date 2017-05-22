/* package whatever; // don't place package name! */

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
class RemoveDup
{
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(1);
		list.append(5);
		list.append(7);
	    list.append(5);
		RemoveDup r = new RemoveDup();
		r.print(list.head);
		r.removeDuplicates(list.head);
		System.out.println("output:");
		r.print(list.head);
		
	}
	public void print(Node head){
		if(head == null)
		return;
		while(head!=null){
			System.out.print(head.data+ " ");
			head = head.next;
		}
		System.out.println();
	}
	public Node removeDuplicates(Node n){
		HashSet<Integer> hs = new HashSet<Integer>();
		Node previous,head;
		head = n;
		previous = null;
		while(n != null){
			if(hs.contains(n.data))
			previous.next = n.next;
			else{
				hs.add(n.data);
				previous = n;
			}
			n = n.next;
		}
		return head; 
}
}