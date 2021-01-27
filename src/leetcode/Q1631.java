package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * Link :- https://leetcode.com/problems/path-with-minimum-effort/
 *
 */

public class Q1631 {

    public static void main(String[] args){
         int[][] heights = {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
        System.out.println(minimumEffortPath(heights));
    }
    private static final int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    public static   int minimumEffortPath(int[][] heights) {

        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] {0, 0, 0});
        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            int i = p[0], j = p[1];
            if(i == m - 1 && j == n - 1) break;
            for(int[] d: dir) {
                int x = i + d[0], y = j + d[1];
                if(x < 0 || x >= m || y < 0 || y >= n) continue;
                int alt = Math.max(p[2], Math.abs(heights[i][j] - heights[x][y]));
                if(alt < dist[x][y]) {
                    pq.add(new int[] {x, y, dist[x][y] = alt});
                }
            }
        }
        return dist[m - 1][n - 1];
    }

    private static int costFunction(int row ,int col,int[][] data){
        int cost=Integer.MAX_VALUE;
        int upper=0,lower = 0,left=0,right=0;
        if(row==data.length-1){
            lower=-1;
        }
        if(col== data[0].length-1){
            right=-1;
        }
        if(row==0){
            upper=-1;
        }
        if(col==0){
            left=-1;
        }

        if(lower!=-1)
            cost =  Math.min(cost,Math.abs(data[row][col]-data[row+1][col]));
        if(upper!=-1)
            cost = Math.min(cost,Math.abs(data[row][col]-data[row-1][col]));
        if(left!=-1)
            cost = Math.min(cost,Math.abs(data[row][col]-data[row][col-1]));
        if(right!=-1)
            cost = Math.min(cost,Math.abs(data[row][col]-data[row][col+1]));

        return cost;
    }

}
