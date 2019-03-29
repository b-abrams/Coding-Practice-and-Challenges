//Breeland Abrams
//Leetcode #35: Search Insert Position
//Re-Implementation fo Java Solution 1 in C++
class Solution
{
public:
  int searchInsert(vector<int> &nums, int target)
  {
    for (int i = 0; i < nums.size(); i++)
    {
      if (nums[i] >= target)
      {
        return i;
      }
    }
    return nums.size();
  }
};