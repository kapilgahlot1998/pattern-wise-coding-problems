package Graph.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Cycle is detected when you are trying to visit a node which is already visited by someone else
 * if the that node is your parent then skip but if not then that means you are in a circle
 */

public class DetectCycleUsingBFS {
    public static void main(String[] args) {
    }

    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        int [] vis = new int[adj.size()];
        for(int i=0;i<v;i++){
            if(vis[i] == 0 && bfs(i, adj, vis))
                return true;
        }
        return false;
    }

    public static boolean bfs(int v, ArrayList<ArrayList<Integer>> adj, int [] vis) {

        Queue<int []> queue = new LinkedList<>();
        queue.add(new int []{v, -1});
        vis[v] = 1;

        while(!queue.isEmpty()){
            int [] temp = queue.remove();

            for(int z : adj.get(temp[0])){
                if(vis[z] == 0 ){
                    queue.add(new int []{z, temp[0]});
                    vis[z] = 1;
                }
                else if ( z != temp[1]){
                    return true;
                }
            }
        }
        return false;
    }

}
