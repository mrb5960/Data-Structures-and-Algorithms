package com.ctci.graph;

import com.ctci.util.graph.Graph;

public class PrimsMST {
	
	public void findMST(Graph g){
		while(!g.getEdges().isEmpty())
			System.out.println(g.getEdges().poll());
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		g.setVertex(1);
		g.setVertex(2);
		g.setVertex(3);
		g.setVertex(4);
		g.setVertex(5);
		g.setVertex(6);
		g.setVertex(7);
		g.addEdge(10, 1, 6);
		g.addEdge(28, 1, 2);
		g.addEdge(25, 6, 5);
		g.addEdge(14, 2, 7);
		g.addEdge(24, 5, 7);
		g.addEdge(22, 5, 4);
		g.addEdge(18, 7, 4);
		g.addEdge(16, 2, 3);
		g.addEdge(12, 3, 4);
		g.addEdge(10, 6, 1);
		g.addEdge(28, 2, 1);
		g.addEdge(25, 5, 6);
		g.addEdge(14, 7, 2);
		g.addEdge(24, 7, 5);
		g.addEdge(22, 4, 5);
		g.addEdge(18, 4, 7);
		g.addEdge(16, 3, 2);
		g.addEdge(12, 4, 3);
		PrimsMST mst = new PrimsMST();
		mst.findMST(g);
	}

}
