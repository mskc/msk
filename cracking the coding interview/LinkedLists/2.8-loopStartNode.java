

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
	public void append(Node n){
		if(head == null){
			head = n;
			return ;
		}
		Node current = head;
		while(current.next!=null){
			current = current.next;
		}
		current.next = n;
}
}
class Loop
{
	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedList list = new LinkedList();
		list.append(new Node(1));
		list.append(new Node(2));
		list.append(new Node(3));
		list.append(new Node(4));
		list.append(new Node(5));
		list.append(new Node(6));
		list.append(new Node(7));
		list.append(new Node(8));
		list.append(list.head.next.next);
		Loop l = new Loop();
		l.containsLoopNode(list.head);
	}
	public void containsLoopNode(Node head){
		if(head == null)
		return ;
		HashSet<Node> hs = new HashSet<Node>();
		while(head != null){
			if(hs.contains(head))
			break;
			hs.add(head);
			head = head.next;
		}
	    if(head == null)
		System.out.println("no loop");
		System.out.println(head.data);
	}
}
