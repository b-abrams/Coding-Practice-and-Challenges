import javafx.util.Pair;
import java.util.HashSet;

public class MatrixPathWithSteps {
    public static void main(String[] args) {
        // write your code here
        int[][] matrix1 = { { 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0 }, { 1, 1, 1, 0, 1, 0, 0 },
                { 1, 0, 1, 1, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0 } };

        int[][] matrix2 = { { 0, 0, 1, 0, 1 }, { 0, 1, 1, 0, 1 }, { 0, 1, 1, 1, 0 }, { 0, 0, 0, 1, 0 } };

        Pair<Boolean, Integer> m1 = hasPath(matrix1);
        Pair<Boolean, Integer> m2 = hasPath(matrix2);

        if (m1.getKey()) {
            System.out.println(m1.getKey() + ": Minimum Number of Steps = " + m1.getValue());
        } else {
            System.out.println(m1.getKey());
        }

        if (m2.getKey()) {
            System.out.println(m2.getKey() + ": Minimum Number of Steps = " + m2.getValue());
        } else {
            System.out.println(m2.getKey());
        }

    }

    public static Pair<Boolean, Integer> hasPath(int[][] matrix) {
        HashSet<Pair> topStarts = new HashSet<>();
        boolean hasBottomPath = false;
        HashSet<Pair> visited = new HashSet<Pair>();
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 1) {
                topStarts.add(new Pair(0, i));
            }
        }
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[matrix.length - 1][j] == 1) {
                hasBottomPath = true;
                break;
            }
        }
        if (!topStarts.isEmpty() && hasBottomPath) {
            for (Pair start : topStarts) {
                Pair<Boolean, Integer> down = down(start, matrix, visited, 0);
                Pair<Boolean, Integer> left = left(start, matrix, visited, 0);
                Pair<Boolean, Integer> right = right(start, matrix, visited, 0);

                System.out.println(down.getValue() + " " + down.getKey());
                System.out.println(left.getValue() + " " + left.getKey());
                System.out.println(right.getValue() + " " + right.getKey());

                int leastSteps = 0;
                if (down.getKey() || left.getKey() || right.getKey()) {
                    if (down.getKey() & down.getValue() != 0) {
                        leastSteps = down.getValue();
                    } else if (left.getKey() & left.getValue() != 0) {
                        if (leastSteps == 0) {
                            leastSteps = left.getValue();
                        } else {
                            leastSteps = Math.min(leastSteps, left.getValue());
                        }

                    } else if (right.getKey() & right.getValue() != 0) {
                        if (leastSteps == 0) {
                            leastSteps = right.getValue();
                        } else {
                            leastSteps = Math.min(leastSteps, right.getValue());
                        }
                    }
                    return new Pair<Boolean, Integer>(true, leastSteps);
                }

            }
        }

        return new Pair<Boolean, Integer>(false, 0);
    }

    public static Pair<Boolean, Integer> left(Pair<Integer, Integer> curr, int[][] matrix, HashSet<Pair> visited,
            int steps) {
        int s = steps;
        if (curr.getValue() <= 0 || matrix[curr.getKey()][curr.getValue()] == 0) {
            System.out.println("Left: Steps = " + steps);
            return new Pair<Boolean, Integer>(false, 0);
        }
        visited.add(curr);
        curr = new Pair<Integer, Integer>(curr.getKey(), curr.getValue() - 1);
        if (visited.contains(curr)) {
            System.out.println("Left: Steps = " + steps);
            return new Pair<Boolean, Integer>(false, 0);
        }
        return new Pair<Boolean, Integer>(up(curr, matrix, visited, steps + 1).getKey()
                || left(curr, matrix, visited, steps + 1).getKey() || down(curr, matrix, visited, steps + 1).getKey()
                || right(curr, matrix, visited, steps + 1).getKey(), 0);
    }

    public static Pair<Boolean, Integer> right(Pair<Integer, Integer> curr, int[][] matrix, HashSet<Pair> visited,
            int steps) {
        int s = steps;
        if (curr.getValue() >= matrix[0].length - 1 || matrix[curr.getKey()][curr.getValue()] == 0) {
            System.out.println("Right: Steps = " + steps);
            return new Pair<Boolean, Integer>(false, 0);
        }
        visited.add(curr);
        curr = new Pair<Integer, Integer>(curr.getKey(), curr.getValue() + 1);
        if (visited.contains(curr)) {
            System.out.println("Right: Steps = " + steps);
            return new Pair<Boolean, Integer>(false, 0);
        }
        return new Pair<Boolean, Integer>(up(curr, matrix, visited, steps + 1).getKey()
                || left(curr, matrix, visited, steps + 1).getKey() || down(curr, matrix, visited, steps + 1).getKey()
                || right(curr, matrix, visited, steps + 1).getKey(), 0);
    }

    public static Pair<Boolean, Integer> up(Pair<Integer, Integer> curr, int[][] matrix, HashSet<Pair> visited,
            int steps) {
        int s = steps;
        if (curr.getValue() <= 0 || matrix[curr.getKey()][curr.getValue()] == 0) {
            System.out.println("Up: Steps = " + steps);
            return new Pair<Boolean, Integer>(false, 0);
        }
        visited.add(curr);
        curr = new Pair<Integer, Integer>(curr.getKey() - 1, curr.getValue());
        if (visited.contains(curr)) {
            System.out.println("Up: Steps = " + steps);
            return new Pair<Boolean, Integer>(false, 0);
        }
        return new Pair<Boolean, Integer>(up(curr, matrix, visited, steps + 1).getKey()
                || left(curr, matrix, visited, steps + 1).getKey() || down(curr, matrix, visited, steps + 1).getKey()
                || right(curr, matrix, visited, steps + 1).getKey(), 0);
    }

    public static Pair<Boolean, Integer> down(Pair<Integer, Integer> curr, int[][] matrix, HashSet<Pair> visited,
            int steps) {
        if (curr.getKey() >= matrix.length - 1) {
            return new Pair<Boolean, Integer>(true, steps);
        }
        if (matrix[curr.getKey()][curr.getValue()] == 0) {
            System.out.println("Down: Steps = " + steps);
            return new Pair<Boolean, Integer>(false, 0);
        }
        visited.add(curr);
        curr = new Pair<Integer, Integer>(curr.getKey() + 1, curr.getValue());
        if (visited.contains(curr)) {
            System.out.println("Down: Steps = " + steps);
            return new Pair<Boolean, Integer>(false, 0);
        }
        return new Pair<Boolean, Integer>(up(curr, matrix, visited, steps + 1).getKey()
                || left(curr, matrix, visited, steps + 1).getKey() || down(curr, matrix, visited, steps + 1).getKey()
                || right(curr, matrix, visited, steps + 1).getKey(), 0);
    }

}
