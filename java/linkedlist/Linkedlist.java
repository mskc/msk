package linkedlists;
class Linkedlist {
		Node start,end;
		int size;
		class Node{
			int data;
			Node next;
			Node(int data)
			{
				this.data=data;
				next=null;
			}
		}
		public void insertatfront(int data)
		{
			Node newnode=new Node(data);
			size++;
			if(start==null)
			{
				start=newnode;
				end=newnode;
			}
			else{
				newnode.next=start;
				start=newnode;
			}
		}
		public void insertatend(int data)
		{
			Node newnode=new Node(data);
			size++;
			if(start==null)
			{
				start=newnode;
				end=newnode;
			}
			else{
				end.next=newnode;
				end=newnode;
			}
		}
		public void insertinmiddle(int data,int pos)
		{
			Node newnode=new Node(data);
			Node ptr=start;
			pos--;
			for(int i=1;i<size;i++)
			{
				if(i==pos)
				{
					Node temp=ptr.next;
					ptr.next=newnode;
					newnode.next=temp;
					break;
				}
				ptr=ptr.next;
			}
			size++;
		}
		public void display()
		{
			Node ptr=start;
			for(int i=1;i<=size;i++)
			{
				System.out.println(ptr.data+ "\n");
				ptr=ptr.next;
			}
		}
	public static void main(String[] args) {
      Linkedlist link=new Linkedlist();
      link.insertatfront(4);
      link.insertatfront(9);
      link.insertatend(6);
      link.insertinmiddle(2,2);
      link.display();
	}

}
