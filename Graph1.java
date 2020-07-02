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
	public void bfs(int n)
	{
		System.out.println("The Nodes reachable from Node "+ n +" are");
		bfs(graph,n); 
	}
	private void bfs(ArrayList<ArrayList<Integer>> adj, int s)
	{
		Queue<Integer> que = new LinkedList<Integer>();
		boolean[] visited = new boolean[adj.size()];
		visited[s] = true;
		que.add(s);
		while(!que.isEmpty())
		{
			int temp = que.poll();
			for(int i = 0 ; i < adj.get(temp).size() ; ++i)
			{
				if(!visited[adj.get(temp).get(i)])
				{
					visited[adj.get(temp).get(i)] = true;
					que.add(adj.get(temp).get(i));
				}
			}
		}
		for(int i = 0 ; i < visited.length ; ++i)
		{
			if(visited[i]) System.out.print(i + " ");
		}
		System.out.println();
	}
	public void dfs(int n)
	{
		System.out.println("The Nodes reachable from Node "+ n +" are");
		dfs(graph,n);
	}
	private void dfs(ArrayList<ArrayList<Integer>> adj, int s)
	{
		boolean[] visited = new boolean[adj.size()];
		Stack<Integer> stk = new Stack<Integer>();
		visited[s] = true;
		stk.push(s);
		while(!stk.isEmpty())
		{
			int temp = stk.pop();
			for(int i = 0 ; i < adj.get(temp).size() ; ++i)
			{
				if(!visited[adj.get(temp).get(i)])
				{
					visited[adj.get(temp).get(i)] = true;
					stk.push(adj.get(temp).get(i));
				}
			}
		}
		for(int i = 0 ; i < visited.length ; ++i)
		{
			if(visited[i]) System.out.print(i+" ");
		}
		System.out.println();
	}
	
}
class Main
{
	public static void main(String[] args)
	{
		Graph1 g = new Graph1(7);
		g.addEdge(0,1);
		g.addEdge(2,3);
		g.addEdge(3,4);
		g.addEdge(4,0);
		g.addEdge(4,1);
		g.addEdge(6,5);
		g.printGraph();
		g.bfs(2);
		g.bfs(6);
		g.dfs(2);
		g.dfs(5);
	}
}
