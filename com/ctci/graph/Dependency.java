package com.ctci.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import com.ctci.util.graph.Graph;
import com.ctci.util.graph.Graph.Vertex;

public class Dependency {
	
	Graph g;
	HashSet<Integer> visited;
	HashMap<Integer, Vertex> vertices;
	
	public Dependency(){
		visited = new HashSet<>();
		g = new Graph();
		g.setVertex(1);
		g.setVertex(2);
		g.setVertex(3);
		g.setVertex(4);
		g.setVertex(5);
		g.setVertex(6);
		g.setVertex(7);
		g.addEdge(6, 1);
		g.addEdge(6, 2);
		g.addEdge(6, 3);
		g.addEdge(3, 1);
		g.addEdge(2, 1);
		g.addEdge(1, 5);
		g.addEdge(2, 5);
		g.addEdge(4, 7);
		/*g.addEdge(3, 4);
		g.addEdge(4, 1);
		g.addEdge(1, 6);
		g.addEdge(4, 2);
		g.addEdge(2, 6);*/
		vertices = g.getVertices();
	}
	
	public void traverse(){
		
		for(int id : vertices.keySet())
			traverse(g.getVertex(id));
	}
	
	public boolean traverse(Vertex ver){
		int id = ver.getId();
		if(visited.contains(id))
			return true;
		
		LinkedList<Vertex> adj = ver.getAdjacent();
		int childCount = adj.size();
		//System.out.println("adj size of " + id + " is " + childCount);
		
		if(adj.size() == 0){
			visited.add(id);
			System.out.println(id);
			return true;
		}
		
		// IMP: never remove an element from any data structure while traversing through it
		for(Vertex child : adj){
			if(traverse(child)){
				childCount--;
				if(childCount == 0){
					visited.add(id);
					System.out.println(id);
					return true;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Dependency d = new Dependency();
		d.traverse();
	}
}
