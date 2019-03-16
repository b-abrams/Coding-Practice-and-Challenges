import javafx.util.Pair;
import java.util.HashSet;
public class MatrixPath {

    public static void main(String[] args) {
	// write your code here
        int[][] matrix1 = {{0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0}, {1, 1, 1, 0, 1, 0, 0},
                          {1, 0, 1, 1, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0}};

        int[][] matrix2 = {{0, 0, 1, 0, 1}, {0, 1, 1, 0, 1}, {0, 1, 1, 1, 0}, {0, 0, 0, 1, 0}};

        int[][] matrix3 = {{1}, {0}, {1}};
        //System.out.println(hasPath(matrix1));
        //System.out.println(hasPath(matrix2));
        //System.out.println(hasPath(matrix3));


    }

    public static boolean hasPath(int [][] matrix){
        HashSet<Pair> topStarts = new HashSet<>();
        boolean hasBottomPath = false;
        HashSet<Pair> visited = new HashSet<Pair>();
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 1){
                topStarts.add(new Pair(0, i));
            }
        }
        for(int j = 0; j < matrix.length; j++){
            if(matrix[matrix.length - 1][j] == 1){
                hasBottomPath = true;
                break;
            }
        }
        if(!topStarts.isEmpty() && hasBottomPath){
            for(Pair start : topStarts){
                if(down(start, matrix, visited) || left(start, matrix, visited) || right(start, matrix, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean left(Pair<Integer, Integer> curr, int[][] matrix, HashSet<Pair> visited){
        if(curr.getValue() <= 0 || matrix[curr.getKey()][curr.getValue()] == 0){
            return false;
        }
        visited.add(curr);
        curr = new Pair<Integer, Integer>(curr.getKey(), curr.getValue() - 1);
        if(visited.contains(curr)){
            return false;
        }
        return  up(curr, matrix, visited) ||
                left(curr, matrix, visited) ||
                down(curr, matrix, visited) ||
                right(curr, matrix, visited);
    }

    public static boolean right(Pair<Integer, Integer> curr, int[][] matrix, HashSet<Pair> visited){
        if(curr.getValue() >= matrix[0].length-1 || matrix[curr.getKey()][curr.getValue()] == 0){
            return false;
        }
        visited.add(curr);
        curr = new Pair<Integer, Integer>(curr.getKey(), curr.getValue() + 1);
        if(visited.contains(curr)){
            return false;
        }
        return  up(curr, matrix, visited) ||
                left(curr, matrix, visited) ||
                down(curr, matrix, visited) ||
                right(curr, matrix, visited);
    }

    public static boolean up(Pair<Integer, Integer> curr, int[][] matrix, HashSet<Pair> visited){
        if(curr.getValue() <= 0 || matrix[curr.getKey()][curr.getValue()] == 0){
            return false;
        }
        visited.add(curr);
        curr = new Pair<Integer, Integer>(curr.getKey() - 1, curr.getValue());
        if(visited.contains(curr)){
            return false;
        }
        return  up(curr, matrix, visited) ||
                left(curr, matrix, visited) ||
                down(curr, matrix, visited) ||
                right(curr, matrix, visited);
    }

    public static boolean down(Pair<Integer, Integer> curr, int[][] matrix, HashSet<Pair> visited){
        if(curr.getKey() >= matrix.length - 1){
            return true;
        }
        if(matrix[curr.getKey()][curr.getValue()] == 0){
            return false;
        }
        visited.add(curr);
        curr = new Pair<Integer, Integer>(curr.getKey() + 1, curr.getValue());
        if(visited.contains(curr)){
            return false;
        }
        return  up(curr, matrix, visited) ||
                left(curr, matrix, visited) ||
                down(curr, matrix, visited) ||
                right(curr, matrix, visited);
    }



}