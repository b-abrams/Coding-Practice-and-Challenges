class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0)
      return 0;
    if (nums.length == 1)
      return 1;
    int solution = 1;
    int updateIndex = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        solution++;
        nums[updateIndex] = nums[i];
        updateIndex++;
      }
    }
    return solution;
  }
}