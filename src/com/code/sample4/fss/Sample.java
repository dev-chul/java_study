package com.code.sample4.fss;

public class Sample {
	/*
	 *   0
	 *  /
	 * 1 -- 3    7
	 * |  / | \ /
	 * | /  |  5
	 * 2 -- 4   \
	 *           6 - 8
	 */
	public static void main(String[] args) {
		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		
		/*
		 * DFS stack vs Recursion(���ȣ��)�� ����
		 * stack�� �������� ���� ���� ���� ��������,
		 * ���ȣ���� ������� ȣ���� �ȴ�.
		 */
		g.dfsR(0);
		
		for (Graph.Node n : g.nodes) {
			n.marked = false;
		}
		
		System.out.println("\n===== ===== ===== ===== =====");
		
		g.dfs(0);
	}
}