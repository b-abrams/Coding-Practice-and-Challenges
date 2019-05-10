/*
  Breeland Abrams
  Leetcode 74: Search a 2D Matrix
*/

class Solution {
  public boolean binarySearch(int[] row, int target) {
    if (row.length <= 2) {
      for (int i = 0; i <= row.length - 1; i++) {
        if (row[i] == target)
          return true;
      }
      return false;
    } else if (row[(row.length - 1) / 2] > target) {
      return binarySearch(Arrays.copyOfRange(row, 0, (row.length - 1) / 2), target);
    }
    return binarySearch(Arrays.copyOfRange(row, (row.length - 1) / 2, row.length), target);
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0)
      return false;
    else if (matrix.length == 1)
      return binarySearch(matrix[0], target);

    for (int i = 1; i <= matrix.length - 1; i++) {
      if (matrix[i][0] > target)
        return binarySearch(matrix[i - 1], target);
    }

    return binarySearch(matrix[matrix.length - 1], target);
  }
}