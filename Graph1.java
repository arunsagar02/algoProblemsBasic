/* The program is to show how to represent a graph using Adjacency List */

import java.util.*;
public class Graph1
{
	ArrayList<ArrayList<Integer>> graph;
	Graph1(int n)
	{
		graph = new ArrayList<ArrayList<Integer>>(n);
		for(int i = 0 ; i < n ; ++i)
		{
			graph.add(new ArrayList<Integer>());
		}
		
	}
	public void addEdge(int u , int v)
	{
		addEdge(graph,u,v);
	}
	private void addEdge(ArrayList<ArrayList<Integer>> adj , int u , int v)
	{
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	public void printGraph()
	{
		printGraph(graph);
	}
	private void printGraph(ArrayList<ArrayList<Integer>> adj)
	{
		for(int i = 0 ; i < adj.size() ; ++i)
		{
			System.out.println("Nodes connected to "+i+"th  Node : ");
			for(int j = 0 ; j < adj.get(i).size() ; ++j)
			{
				System.out.print(adj.get(i).get(j) + " ");
			} 
			System.out.println();
		}
	}
	
}
class Main
{
	public static void main(String[] args)
	{
		Graph1 g = new Graph1(5);
		g.addEdge(0,1);
		g.addEdge(2,3);
		g.addEdge(3,4);
		g.addEdge(4,0);
		g.addEdge(4,1);
		g.printGraph();
	}
}
