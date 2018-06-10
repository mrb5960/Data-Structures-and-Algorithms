package com.ctci.util.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph {

	private HashMap<Integer, Vertex> vertices = new HashMap<>();
	private PriorityQueue<Edge> edges = new PriorityQueue<>();
	
	public PriorityQueue<Edge> getEdges() {
		return edges;
	}

	public void setEdges(PriorityQueue<Edge> edges) {
		this.edges = edges;
	}

	public HashMap<Integer, Vertex> getVertices() {
		return vertices;
	}

	public void setVertices(HashMap<Integer, Vertex> vertices) {
		this.vertices = vertices;
	}
	
	public class Edge implements Comparable<Edge>{
		int weight, source, dest;
		
		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public int getSource() {
			return source;
		}

		public void setSource(int source) {
			this.source = source;
		}

		public int getDest() {
			return dest;
		}

		public void setDest(int dest) {
			this.dest = dest;
		}

		Edge(int w, int s, int d){
			weight = w;
			source = s;
			dest = d;
		}

		// compareTo() which will order the elements for minHeap i.e. PriorityQueue edges
		@Override
		public int compareTo(Edge o) {
			if(this.weight > o.weight)
				return 1;
			else if(this.weight < o.weight)
				return -1;
			else
				return 0;
		}
		
		@Override
		public String toString(){
			return "" + source + "--" + weight + "-->" + dest;
		}
	}

	public class Vertex{
		private int id;
		private LinkedList<Vertex> adjacent = new LinkedList<>();
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public LinkedList<Vertex> getAdjacent() {
			return adjacent;
		}

		public void setAdjacent(LinkedList<Vertex> adjacent) {
			this.adjacent = adjacent;
		}
		
		public Vertex(int id){
			this.id = id;
		}
	}
	
	public Vertex getVertex(int id){
		return vertices.get(id);
	}
	
	public void setVertex(int id){
		vertices.put(id, new Vertex(id));
	}
	
	public LinkedList<Vertex> getAdjacent(Vertex v){
		return v.adjacent;
	}
	
	public void addEdge(int s, int d){
		Vertex source = getVertex(s);
		Vertex dest = getVertex(d);
		source.adjacent.add(dest);
	}
	
	// for edges with weights
	public void addEdge(int w, int s, int d){
		Vertex source = getVertex(s);
		Vertex dest = getVertex(d);
		source.adjacent.add(dest);
		edges.add(new Edge(w, s, d));
	}
	
	public boolean hasPathDFS(int s, int d){
		Vertex source = getVertex(s);
		Vertex dest = getVertex(d);
		HashSet<Integer> visited = new HashSet<>();
		return hasPathDFS(source, dest, visited);
	}
	
	public boolean hasPathDFS(Vertex source, Vertex dest, HashSet<Integer> visited){
		if(visited.contains(source.id))
			return false;
		visited.add(source.id);
		if(source == dest)
			return true;
		for(Vertex child : source.adjacent){
			if(hasPathDFS(child, dest, visited))
				return true;
		}
		return false;
	}
	
	public boolean hasPathBFS(int s, int d){
		Vertex source = getVertex(s);
		Vertex dest = getVertex(d);
		LinkedList<Vertex> toVisit = new LinkedList<>();
		toVisit.add(source);
		HashSet<Integer> visited = new HashSet<>();
		while(!toVisit.isEmpty()){
			Vertex current = toVisit.remove();
			if(current == dest)
				return true;
			if(visited.contains(current.id))
				continue;
			visited.add(current.id);
			for(Vertex child : current.adjacent)
				toVisit.add(child);
		}
		return false;
	}
	
	public static void main(String[] args) {
		Graph g = new Graph();
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
		System.out.println(g.hasPathDFS(0, 3));
		System.out.println(g.hasPathDFS(5, 4));
		System.out.println(g.hasPathBFS(0, 3));
		System.out.println(g.hasPathBFS(5, 4));
	}
}
