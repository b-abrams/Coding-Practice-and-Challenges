/*
  Breeland Abrams
  Leetcode# 33: Search in Rotated Array

  --- Note --- 
  Memory Usage is actually 37.4 MB - better than 95% of other submissions
  I forgot to screenshot the original screen, so I reran the code and got a
    slightly worse memory score

*/

class Solution {
  public int search(int[] nums, int target) {
    if (nums.length == 0 || (nums.length == 1 && nums[0] != target))
      return -1;
    if (nums[0] == target)
      return 0;

    int indexSmallest = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        indexSmallest = i;
        break;
      }
    }

    if (indexSmallest == 0)
      return binSearch(nums, target, 0, nums.length - 1);
    else if (target > nums[0] && indexSmallest > 0)
      return binSearch(nums, target, 0, indexSmallest - 1);
    else
      return binSearch(nums, target, indexSmallest, nums.length - 1);
  }

  public int binSearch(int[] nums, int target, int start, int end) {
    if (end - start <= 1) {
      if (nums[start] == target)
        return start;
      else if (nums[end] == target)
        return end;
      else
        return -1;
    }
    if (end - start == 2) {
      if (nums[start] == target)
        return start;
      else if (nums[start + 1] == target)
        return start + 1;
      else if (nums[end] == target)
        return end;
      else
        return -1;
    }

    int mid = (start + end) / 2;
    if (target < nums[mid])
      return binSearch(nums, target, start, mid);
    else
      return binSearch(nums, target, mid, end);
  }
}