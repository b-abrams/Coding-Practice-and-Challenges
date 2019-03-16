/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int rangeSumBST(TreeNode root, int L, int R) {
    if (root.val >= L && root.val <= R) {
      return root.val + leftSum(root.left, L, R) + rightSum(root.right, L, R);
    }
    return leftSum(root.left, L, R) + rightSum(root.right, L, R);
  }

  public int leftSum(TreeNode n, int L, int R) {
    if (n == null) {
      return 0;
    } else if (n.val == L) {
      return n.val + rightSum(n.right, L, R);
    } else if (n.val > L && n.val <= R) {
      return n.val + leftSum(n.left, L, R) + rightSum(n.right, L, R);
    }
    return leftSum(n.left, L, R) + rightSum(n.right, L, R);
  }

  public int rightSum(TreeNode n, int L, int R) {
    if (n == null) {
      return 0;
    } else if (n.val == R) {
      return n.val + leftSum(n.left, L, R);
    } else if (n.val >= L && n.val < R) {
      return n.val + leftSum(n.left, L, R) + rightSum(n.right, L, R);
    }
    return leftSum(n.left, L, R) + rightSum(n.right, L, R);
  }
}