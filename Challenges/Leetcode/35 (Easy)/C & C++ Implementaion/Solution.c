//Breeland Abrams
//Leetcode #35: Search Insert Position
//Re-Implementation fo Java Solution 1 in C
int searchInsert(int *nums, int numsSize, int target)
{

  for (int i = 0; i < numsSize; i++)
  {
    if (nums[i] >= target)
    {
      return i;
    }
  }
  return numsSize;
}