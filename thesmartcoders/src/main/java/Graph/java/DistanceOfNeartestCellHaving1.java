package Graph.java;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNeartestCellHaving1 {
	public int[][] nearest(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] res = new int[m][n];
		int[][] vis = new int[m][n];

		Queue<Pair> que = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					que.add(new Pair(i, j, 0));
					vis[i][j] = 1;
					res[i][j] = 0;
				}
			}
		}

		while (!que.isEmpty()) {
			Pair pair = que.remove();
			int row = pair.row;
			int col = pair.col;
			int dist = pair.dist;


			int[] drow = new int[]{-1, 0, 1, 0};
			int[] dcol = new int[]{0, 1, 0, -1};

			for (int i = 0; i < drow.length; i++) {
				int nrow = row + drow[i];
				int ncol = col + dcol[i];

				if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0
						&& grid[nrow][ncol] == 0) {
					que.add(new Pair(nrow, ncol, dist+1));
					vis[nrow][ncol] = 1;
					res[nrow][ncol] = dist + 1;
				}
			}

		}

		return res;

	}


}

class Pair {
	int row;
	int col;
	int dist;

	public Pair(int row, int col, int dist) {
		this.row = row;
		this.col = col;
		this.dist = dist;
	}
}
