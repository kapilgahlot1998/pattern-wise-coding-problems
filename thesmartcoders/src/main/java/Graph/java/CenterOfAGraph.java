package Graph.java;

import java.util.ArrayList;

//https://leetcode.com/problems/find-center-of-star-graph/
public class CenterOfAGraph {

	public int findCenter(int[][] edges) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		int m = edges.length;
		int n = edges[0].length;

		for (int i = 0; i <= m; i++) {
			adj.get(i).addAll(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				adj.get(i).add(j);
				adj.get(j).add(i);
			}
		}

		for (int i = 0; i < adj.size(); i++) {
			if(adj.get(i).size() == m-1)
				return i;
		}
		return -1;
	}


}
