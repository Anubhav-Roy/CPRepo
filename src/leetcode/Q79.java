package leetcode;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * Link :- https://leetcode.com/problems/word-search/
 *
 */

public class Q79 {

//    static char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    static char[][] board ;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args){
        String word = "ABCEFSADEESE";
//        board = new char[][]{{'A'}};
        board = new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
//        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

        System.out.println(String.valueOf(exist(board,word)));
    }

    static public boolean exist(char[][] board, String word) {


        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char c = board[i][j];

                if(c==word.charAt(0) ){

                    Set<Coords> coords = new HashSet<>();
                    coords.add(new Coords(i,j));

                    boolean result = recursiveSearch(i,j,0,word,coords);

                    if(result){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static public boolean recursiveSearch(int r, int c, int currentPosition, String word, Set<Coords> coords){

        boolean result= false;

        for(int[] direction : dir){
            int row = r+direction[0];
            int col = c+direction[1];

            if(row<0 || row>board.length-1 || col<0 || col>board[0].length-1)
                continue;

            if(coords.contains(new Coords(row,col)))
                continue;

            char neighbour = board[row][col];

            if(neighbour==word.charAt(currentPosition+1)){

                if(currentPosition==word.length()-2)
                    return true;


                coords.add(new Coords(row,col));
                result = recursiveSearch(row,col,currentPosition+1,word, coords);

                if(result)
                    return true;
            }
        }

        return false;
    }

    static class Coords   {
        int x,y;

        Coords(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Coords))
                return false;

            Coords o = (Coords) obj;

            if(o.x==this.x && o.y == this.y)
                return true;
            else
                return false;
        }

        @Override
        public int hashCode() {
            return Integer.parseInt(String.valueOf(x)+String.valueOf(y));
        }
    }
}
