class Solution2 {
  public int searchInsert(int[] nums, int target) {

    if (nums.length > 3) {
      if (nums[0] > target)
        return 0;
      else if (nums[nums.length - 1] < target)
        return nums.length;
      else
        return binSearch(nums, target, (nums.length - 1) / 2);
    }

    if (nums.length == 3) {
      if (nums[0] >= target)
        return 0;
      else if (nums[0] < target && nums[1] >= target)
        return 1;
      else if (nums[1] < target && nums[2] >= target)
        return 2;
      else
        return 3;
    }

    if (nums.length == 2) {
      if (nums[0] >= target)
        return 0;
      else if (nums[0] < target && nums[1] >= target)
        return 1;
      else
        return 2;
    }

    if (nums[0] >= target)
      return 0;
    return 1;
  }

  public int binSearch(int[] nums, int target, int mid) {

    if (nums.length == 3) {
      if (nums[0] >= target)
        return 0;
      else if (nums[0] < target && nums[1] >= target)
        return 1;
      else if (nums[1] < target && nums[2] >= target)
        return 2;
      else
        return 3;
    }

    if (target < nums[mid]) {
      if (nums.length == 4) {
        return binSearch(Arrays.copyOfRange(nums, 0, mid + 2), target, mid / 2);
      }
      return binSearch(Arrays.copyOfRange(nums, 0, mid + 1), target, mid / 2);
    } else
      return mid + binSearch(Arrays.copyOfRange(nums, mid, nums.length), target, mid / 2);
  }
}