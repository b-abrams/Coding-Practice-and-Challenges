/*
  Breeland Abrams
  Leetcode 41: First Missing Positive
*/
class Solution {
  public int firstMissingPositive(int[] nums) {
    if (nums.length == 0)
      return 1;
    Arrays.sort(nums);
    int startIndex = 0;
    while (nums[startIndex] <= 0) {
      startIndex++;
      if (startIndex == nums.length) {
        return 1;
      }
    }
    for (int i = startIndex; i < nums.length; i++) {
      if (i == startIndex && nums[i] > 1) {
        return 1;
      } else if (i >= startIndex + 1 && nums[i] == nums[i - 1]) {
        continue;
      } else if (i >= startIndex + 1 && nums[i] != nums[i - 1] + 1) {
        return nums[i - 1] + 1;
      }
    }

    return nums[nums.length - 1] + 1;
  }

}