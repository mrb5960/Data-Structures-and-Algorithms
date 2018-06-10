package com.ctci.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class Temp {
	
	class Vertex{
		int id;
		LinkedList<Vertex> adj;
		
		Vertex(int id){
			this.id = id;
			adj = new LinkedList<Vertex>();
		}
	}
	
	public void setVertex(int id){
		vertices.put(id, new Vertex(id));
	}
	
	HashMap<Integer, Vertex> vertices = new HashMap<>();
	
	
	public void addEdge(int s, int d){
		Vertex source = vertices.get(s);
		Vertex dest = vertices.get(d);
		source.adj.add(dest);
	}
	
	public boolean hasDFS(int s, int d){
		HashSet<Integer> visited = new HashSet<>();
		Vertex source = vertices.get(s);
		Vertex dest = vertices.get(d);
		return hasDFS(source, dest, visited);
	}
	
	public boolean hasDFS(Vertex source, Vertex dest, HashSet<Integer> visited){
		if(visited.contains(source.id))
			return false;
		//visited.add(source.id);
		if(source.id == dest.id)
			return true;
		visited.add(source.id);
		for(Vertex v : source.adj){
			if(hasDFS(v, dest, visited))
				return true;
		}
		return false;
	}
	
	public boolean hasCycle(int s){
		HashSet<Integer> visited = new HashSet<>();
		HashSet<Integer> recStack = new HashSet<>();
		Vertex source = vertices.get(s);
		//Vertex dest = vertices.get(d);
		return hasCycleHelper(source, visited, recStack);
	}
	
	public boolean hasCycleHelper(Vertex source, HashSet<Integer> visited, HashSet<Integer> recStack){
		if(recStack.contains(source.id))
			return true;
		
		recStack.add(source.id);
		
		if(visited.contains(source.id))
			return false;

		visited.add(source.id);
		
		for(Vertex v : source.adj){
			if(hasCycleHelper(v, visited, recStack))
				return true;
		}
		
		recStack.remove(source.id);
		return false;
	}
	
	//HashSet<Integer> visited = new HashSet<>();
	
	public void TopologicalSort(){
		HashSet<Integer> visited = new HashSet<>();
		for(Map.Entry<Integer, Vertex> m : vertices.entrySet()){
			TopologicalSortHelper(m.getValue(), visited);
			visited.add(m.getKey());
		}
	}
	
	public void TopologicalSortHelper(Vertex source, HashSet<Integer> visited){
		if(!visited.contains(source.id)){			
				for(Vertex child : source.adj){
					TopologicalSortHelper(child, visited);
				}
				visited.add(source.id);
				System.out.println(source.id);
		}
	}
	
	public boolean hasBFS(int s, int d){
		Vertex source = vertices.get(s);
		Vertex dest = vertices.get(d);
		HashSet<Integer> visited = new HashSet<>();
		LinkedList<Vertex> toVisit = new LinkedList<>();
		toVisit.add(source);
		
		while(!toVisit.isEmpty()){
			Vertex temp = toVisit.remove();
			if(visited.contains(temp.id))
				continue;
			visited.add(temp.id);
			if(temp.id == dest.id)
				return true;
			toVisit.addAll(temp.adj);
		}
		
		return false;
	}

	public static void main(String[] args) {
		/*Temp g = new Temp();
		g.setVertex(0);
		g.setVertex(1);
		g.setVertex(2);
		g.setVertex(3);
		g.setVertex(4);
		g.setVertex(5);
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(0, 5);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 1);
		g.addEdge(3, 2);
		g.addEdge(3, 4);
		g.addEdge(4, 0);
		// Input for dependency 
		//g = new Graph();
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
		System.out.println(g.hasDFS(0, 3));
		System.out.println(g.hasDFS(5, 4));
		System.out.println(g.hasBFS(0, 3));
		System.out.println(g.hasBFS(5, 4));
		System.out.println("Has cycle: " + g.hasCycle(0));
		System.out.println("Dependency output");
		g.TopologicalSort();*/
		
		System.out.println("Mandar".substring(0,1));
	}

}
