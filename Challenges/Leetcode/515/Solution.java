
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
  public List<Integer> largestValues(TreeNode root) {
    if (root == null) {
      return new ArrayList<Integer>();
    }
    Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
    currentLevel.add(root);
    return BFS(new ArrayList<Integer>(), currentLevel);
  }

  public ArrayList<Integer> BFS(ArrayList<Integer> solution, Queue<TreeNode> currentLevel) {
    if (currentLevel.isEmpty()) {
      return solution;
    }
    int maxCurrent = Integer.MIN_VALUE;
    int size = currentLevel.size();
    for (int i = 0; i < size; i++) {
      TreeNode c = currentLevel.poll();
      if (c == null) {
        continue;
      }
      if (c.left != null) {
        currentLevel.add(c.left);
      }
      if (c.right != null) {
        currentLevel.add(c.right);
      }
      maxCurrent = Math.max(c.val, maxCurrent);
    }
    solution.add(maxCurrent);
    return BFS(solution, currentLevel);

  }

}