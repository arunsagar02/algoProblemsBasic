/*
  Implementation Of Doubly Linked List for Integer type data
*/
class Node
{
	int data;
	Node prev,next;
	Node(int n)
	{
		data = n;
		prev = null;
		next = null;
	}
}
public class DoublyLinkedList
{
	Node head,tail;
	DoublyLinkedList()
	{
		head = null;
		tail = null;
	}
	//O(n) time
	public boolean containsNodeWithValue(int n)
	{
		Node temp = head;
		while(temp != null)
		{
			if(temp.data == n) return true;
			temp = temp.next;
		}
		return false;
	}
	//O(1) time
	public void removeBindingsOfNode(Node curr)
	{
		if(curr.prev != null) curr.prev.next = curr.next; //curr is head then curr.prev.next throws error
		if(curr.next != null)curr.next.prev = curr.prev; //curr is tail then curr.next.prev throws error
		curr.prev = null;
		curr.next = null; 
	}
	//O(n) time
	public void removeNode(Node curr)
	{
		if(head == curr) head = head.next;
		if(tail == curr) tail = tail.next;
		removeBindingsOfNode(curr);
	}
	//O(n) time
	public void removeAllNodeWithValue(int n)
	{
		Node temp = head;
		while(temp != null)
		{
			if(temp.data == n)
			{
		 		Node next = temp.next // store this because after removingBindings temp.next will be Null.
				removeNode(temp);
				temp = next;
			}
			else
			{
				temp = temp.next;
			}
		}
	}
	//O(n) time
	public void removeNodeWithValue(int n)
	{
		
		Node temp = head;
		while(temp != null)
		{
			if(temp.data == n)
			{
				removeBindingsOfNode(temp);
		 		break;
			}
			temp = temp.next;
		}
	}
	//O(1) time;
	public void insertBeforeNode(Node node,Node nodeToInsert)
	{
		if(nodeToInsert == head && nodeToInsert == tail) return; // if there is one node
		removeNode(nodeToInsert);
		nodeToInsert.prev = node.prev;
		nodeToInsert.next = node
		if(node.prev == null) head = nodeToInsert; // if node is head;
		else node.prev.next = nodeToInsert;
		node.prev = nodeToInsert;   
	}
	//O(1) time
	public void insertAfterNode(Node node, Node nodeToInsert)
	{
		if(nodeToInsert == head && nodeToInsert == tail) return; // there is one node;
		removeNode(nodeToInsert);
		nodeToInsert.next = node.next;
		nodeToInsert.prev = node;
		if(node == tail) tail = nodeToInsert; // if node is tail
		else node.next.prev = nodeToInsert;
		node.next = nodeToInsert; 
		
	}
	//O(pos) time
	public void insertAtPosition(int pos,Node nodeToInsert)
	{
		if(pos == 1){ 
			setNodeAsHead(nodeToInsert);
			return;
		}
		Node temp = head;
		int currpos = 1;
		while(temp != null && currpos != pos)
		{
			currpos++;
			temp = temp.next;
		}
		if(temp != null) insertBeforeNode(temp,nodeToInsert); 
		else setNodeAsTail(nodeToInsert) // we are at tail
		
	}
	//O(1) time
	public void setNodeAsHead(Node n)
	{
		if(head == null)
		{
			head = n;
			tail = n;
			return; 
		}
		insertBeforeNode(head,n);
	}
	//O(1) time
	public void setNodeAsTail(Node n)
	{
		if(tail == null)
		{
			head = n;
			tail = n;
			return;
		}
		insertNodeAfter(tail,n);
	}
}
/* Things To Remember
	1. Always check for conditions like
	if opeartion is on tail
	if operation is on head
	if the list contains only one value
	if list is empty
	if operation is done in middle of the list
*/
