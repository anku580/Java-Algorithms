package linkedlist;



public class SinglyLinkedList
{
	class Node
	{
		int data;
		Node next;

		public Node(int data)
		{
			this.data=data;
			this.next=null;
			size++;	
		}
	}

	Node head;
	Node tail;
	int size;
	
	public SinglyLinkedList()
	{
		head=null;
		tail=null;
		size=0;
	}

	public void InsertAtTail(int data)
	{
		Node node =new Node(data);
		if(this.head==null)
		{
			this.head=node;
			this.tail=node;
		}
		else
			this.tail.next=node;
			this.tail=node;
	}

	public void InstertAtHead(int data)
	{
		Node node=new Node(data);	
		node.next=head;
		head=node;
		if(this.tail==null)
			this.tail=node;
	}

	Boolean isEmpty()
	{
		return head==null;	
	}

	public void displayNodes()
		{
			if(this.isEmpty())
			System.out.println("The list is empty");
			Node temp=this.head;	
			while(temp.next!=null)
				{
					System.out.print(temp.data+"->");
					temp=temp.next;	
				}
			System.out.print("end");	
		}
	public static void main(String[] args)
	{
		SinglyLinkedList l =new SinglyLinkedList(); 
		l.InstertAtHead(5);
		l.InsertAtTail(6);
		l.InstertAtHead(4);
		System.out.println("Size of Linked List is: "+l.size);
		l.InsertAtTail(3);
		l.displayNodes();
	}

}