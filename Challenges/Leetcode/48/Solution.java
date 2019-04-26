/*
  Breeland Abrams
  Leetcode #48 - Rotate Image
*/

class Solution {
  public void rotate(int[][] matrix) {
    int p1 = 0, p2 = matrix.length - 1;
    while (p1 < p2) {
      int[] tempRow = matrix[p1];
      matrix[p1] = matrix[p2];
      matrix[p2] = tempRow;
      p1++;
      p2--;
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = i + 1; j < matrix[0].length; j++) {
        int tempVal = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tempVal;
      }
    }

  }
}