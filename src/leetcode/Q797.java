package leetcode;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 *
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q797 {

    static final int[][] mainGraph = {{1,2,3},{2},{3}, {}};


    public static void main(String[] args){
        Trav trav= new Trav(mainGraph);
        List<List<Integer>> paths  = trav.allPathsSourceTarget(mainGraph);

        System.out.println("noice");
     }

     static class Trav {

        final int[][] mainGraph;

        Trav(int[][] mainGraph){
            this.mainGraph = mainGraph;
        }

        List<List<Integer>> paths = new ArrayList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

            List<Integer> nodeStart = new ArrayList<>();
            nodeStart.add(0);


            graphTraverse(0, nodeStart);
            return paths;
        }

        public void graphTraverse(int currentNode, List<Integer> prevNodes) {

            int[] possibleNodes = mainGraph[currentNode];

            for (int i = 0; i < possibleNodes.length; i++) {
                int possibleNode = possibleNodes[i];
                List<Integer> possiblePath = new ArrayList<>();
                possiblePath.addAll(prevNodes);
                possiblePath.add(possibleNode);

                if (possibleNode == mainGraph.length - 1) {
                    paths.add(possiblePath);
                } else
                    graphTraverse(possibleNode, possiblePath);
            }
        }
    }

}
