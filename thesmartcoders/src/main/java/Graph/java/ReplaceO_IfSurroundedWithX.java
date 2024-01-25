package Graph.java;

public class ReplaceO_IfSurroundedWithX {

	static char[][] fill(int n, int m, char a[][])
	{
		int [][] vis = new int [n][m];
		char [][] res = new char [n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				res[i][j] = 'X';
			}
		}

		for (int i = 0; i < m; i++) {
			if(a[0][i] == 'O' && vis[0][i] == 0){
				dfs(a, vis, res, 0, i );
			}
			if(a[n-1][i] == 'O' && vis[n-1][i] == 0){
				dfs(a, vis, res, n-1, i );
			}
		}

		for(int i=0;i<n;i++){
			if(a[i][0] == 'O' && vis[i][0] == 0){
				dfs(a, vis, res, i, 0 );
			}
			if(a[i][m-1] == 'O' && vis[i][m-1] == 0){
				dfs(a, vis, res, i, m-1 );
			}
		}

		return res;
	}

	public static void dfs(char [][]a, int [][] vis, char [][] res, int i, int j){

		if(i>=0 && i<a.length && j>=0 && j<a[0].length && vis[i][j] == 0 && a[i][j] == 'O') {
			vis[i][j] = 1;
			res[i][j] = 'O';
			dfs(a, vis, res, i - 1, j);
			dfs(a, vis,res, i + 1, j);
			dfs(a, vis, res, i, j - 1);
			dfs(a, vis, res, i, j + 1);
		}
	}

}
