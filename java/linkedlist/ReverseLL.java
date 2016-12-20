package reversell;

class ReverseLL {
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
		public void reverse()
		{
			Node temp,newnode;
			temp=newnode=null;
			while(start.next!=null)
			{
				newnode=start.next;
				start.next=temp;
				temp=start;
				start=newnode;
			}
			start.next=temp;
		}
		public static void main(String[] args) {
		      ReverseLL link=new ReverseLL();
		      link.insertatfront(4);
		      link.insertatfront(9);
		      link.insertatfront(5);
		      link.insertatfront(8);
		      link.display();
		      link.reverse();
		      link.display();
			}

	}

