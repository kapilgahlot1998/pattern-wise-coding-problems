package Graph.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS approach because we need level wise traversal
 * Because all the 1 which is near to 2 will rotten at the same time
 */

public class RottenOranges {

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int [][]{{0,1,2},{0,1,2},{2,1,1}}));
    }


    public static int orangesRotting(int [][] grid){
        Queue<int []> starts = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int [][] vis = new int[m][n];

        int cntFresh = 0;
        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] == 2){
                    starts.add(new int[] {i,j});
                    vis[i][j] = 1;
                }
                if(grid[i][j] == 1)
                    cntFresh++;
            }
        }

        int time = 0;
        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};
        int cnt = 0;
        starts.add(new int []{-1,-1});

        while (!starts.isEmpty()) {
            int[] temp = starts.remove();

            int r = temp[0];
            int c = temp[1];

            if(r == -1 && c == -1){
                if(!starts.isEmpty()){
                    time++;
                    starts.add(new int[]{-1, -1});
                }
            } else {
                for(int ind=0;ind<4;ind++) {
                    int nrow = r + drow[ind];
                    int ncol = c + dcol[ind];

                    if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                            && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                        starts.add(new int[]{nrow, ncol});
                        vis[nrow][ncol] = 1;
                        cnt++;
                    }
                }
            }

        }

        if(cnt != cntFresh) return -1;
        return time;

    }



}
