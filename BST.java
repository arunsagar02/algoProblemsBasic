/* 
	This is code for implementations of BST and its Various methods for Integer Datatype
*/
import java.util.*;
class BSTNode
{
	int data;
	BSTNode left,right;
	BSTNode()
	{
		this.data = 0;
		this.left = null;
		this.right = null;
	}
	BSTNode(int n)
	{
		this.data = n;
		this.left = null;
		this.right = null;
	}
}
public class BST
{
	BSTNode root;
	BST()
	{
		root = null;	
	}
	public void insert(int data)
	{
		root = insert(root,data);
	}
	private BSTNode insert(BSTNode rt, int data)
	{
		if(rt == null) rt = new BSTNode(data);
		else
		{
			if(data < rt.data) rt.left = insert(rt.left,data);
			else rt.right = insert(rt.right,data);
		}
		return rt;
		
	}
	public boolean search(int data)
	{
		return search(root,data);
	}
	private boolean search(BSTNode rt,int data)
	{
		if(rt == null) return false;
		else if(rt.data == data) return true;
		else if(data < rt.data) return search(rt.left,data);
		else return search(rt.right,data);	
	}
	public void delete(int data)
	{
		if(root == null) System.out.println("NO Tree");
		else if(search(data)) root = delete(root,data);
		else System.out.println("Data is not available in tree");
	}
	private BSTNode delete(BSTNode rt, int data)
	{
		if(rt == null) return rt;
		if(rt.data == data)
		{
			if(rt.left == null) return rt.right;
			else if(rt.right == null) return rt.left;
			else
			{
				BSTNode temp = rt.right;
				while(temp.left != null)
				{
					temp = temp.left;
				}
				rt.data = temp.data;
				rt.right = delete(rt.right,temp.data);
			}
		}
		else if(data < rt.data)
		{
			rt.left = delete(rt.left,data);
		}
		else
		{
			rt.right = delete(rt.right,data);
		}
		return rt;
	}
	public void printInOrder()
	{
		printInOrder(root);
		System.out.println();
	}
	private void printInOrder(BSTNode rt)
	{
		if(rt != null)
		{
			printInOrder(rt.left);
			System.out.print(rt.data  + " ");
			printInOrder(rt.right);
		}
	}
	
}
class BSTree
{
	public static void main(String[] args)
	{
		BST bst = new BST();
		bst.insert(4);
		bst.insert(6);
		bst.insert(7);
		bst.insert(3);
		bst.insert(1);
		bst.printInOrder();
		bst.delete(4);
		bst.printInOrder();
		
	}
}
