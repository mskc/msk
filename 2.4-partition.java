

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
class Partition
{
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(2);
		list.append(5);
		list.append(7);
	    list.append(5);
		Partition p = new Partition();
		p.print(list.head);
		p.print(p.partitionOfElements(list.head,5));
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
	public Node partitionOfElements(Node n,int x){
		Node head = n;
		Node tail = n;
		while(n != null){
			Node nxt = n.next;
			if(n.data < x){
				n.next = head;
				head = n;
			}
			else{
				tail.next = n;
				tail = n;
			}
			n = nxt;
		}
		return head;
	}
}