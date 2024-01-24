package Graph.java;

import java.util.ArrayList;

/**
 * DFS approach also need a parent node to take care that already visited
 * node is not the parent of the current node
 */
public class DetectCycleUsingDFS {

    public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        int [] vis = new int[adj.size()];
        for(int i=0;i<v;i++){
            if(vis[i] == 0 && dfs(i, adj, vis, -1))
                return true;
        }
        return false;
    }

    public static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, int [] vis, int parent){

        vis[v] = 1;
        for(int x : adj.get(v)){
            if(vis[x] == 0) {
                if (dfs(x, adj, vis, v)) return true;
            }
            else if (x != parent)
                return true;
        }
        return false;
    }
}
