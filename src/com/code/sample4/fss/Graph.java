package com.code.sample4.fss;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	class Node {
		int data;
		LinkedList<Node> adjacent;
		boolean marked;
		
		// 생성자 생성
		Node (int data) {
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<>();
		}
	}
	
	Node[] nodes;
	
	// 전달 받은 size에 따른 리스트 생성
	public Graph(int size) {
		nodes = new Node[size];
		for (int i=0; i<size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		
		if (!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		
		if (!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	
	void dfs(int index) {
		Node root = nodes[index];
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		root.marked = true;
		
		while (!stack.isEmpty()) {
			Node r = stack.pop();
			for (Node n : r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					stack.push(n);
				}
			}
			visit(r);
		}
	}
	
	void dfsR(Node r) {
		if (r == null) return;
		r.marked = true;
		visit(r);
		for (Node n : r.adjacent) {
			if (n.marked == false) {
				dfsR(n);
			}
		}
	}
	
	void dfsR(int index) {
		Node r = nodes[index];
		dfsR(r);
	}
	
	void bfs(int index) {
		Node root = nodes[index];
		Queue<Node> queue = new LinkedList<Graph.Node>();
		queue.add(root);
		root.marked = true;
		
		while (queue.size() != 0) {
			Node r = queue.poll();
			for (Node n : r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					queue.add(n);
				}
			}
			visit(r);
		}
	}
	
	void visit(Node n) {
		System.out.print(n.data + " ");
	}
	
}
