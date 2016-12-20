package doubleLL;

public class DoubleLL {
	Node start,end;
    int size;
	class Node{
		int data;
		Node next,previous;
		public Node(int d){
			data=d;
			next=previous=null;
		}
	}
	public void insertatfront(int d)
	{
		Node newnode=new Node(d);
		size++;
		if(start==null)
		{
			start=end=newnode;
		}
		else{
			newnode.next=start;
			newnode.previous=null;
			start=newnode;
		}
	}
	public void insertatend(int d)
	{
		Node newnode=new Node(d);
		size++;
		if(start==null)
			start=end=newnode;
		else{
			newnode.previous=end;
			newnode.next=null;
			end.next=newnode;
			end=newnode;
		}
	}
	public void insertinmiddle(int d,int position)
	{
		Node temp,p;
		p=start;
		Node newnode=new Node(d);
		for(int i=1;i<size;i++)
		{
			if(i==position-1)
			{
				temp=p.next;
				p.next=newnode;
				newnode.next=temp;
				p.next.previous=newnode;
				newnode.previous=p;
				break;
			}
			p=p.next;
		}
		size++;
	}
	public void display()
	{
		Node ptr=start;
		while(ptr.next!=null)
		{
			System.out.print(ptr.data+ " ");
			ptr=ptr.next;
		}
		System.out.print(ptr.data+" " );
		System.out.println("");
	}

	public static void main(String[] args) {
		 DoubleLL link=new DoubleLL();
	      link.insertatfront(4);
	      link.insertatfront(9);
	      link.insertatfront(6);
	      link.insertinmiddle(5,3);
	      link.insertatend(8);
	      link.display();

	}

}
