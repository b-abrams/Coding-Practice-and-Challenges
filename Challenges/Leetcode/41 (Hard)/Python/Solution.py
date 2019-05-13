# Breeland Abrams
# Leetcode 41: First Missing Positive

class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        if(nums == []): return 1
        nums = sorted(nums)
        while(nums[0] <= 0):
            nums.pop(0)
            if(nums == []): return 1    
        for i in range(len(nums)):
            if(i == 0 and nums[i] > 1):
                return 1
            elif(i >= 1 and nums[i] == nums[i-1] or i >= 1 and nums[i] == nums[i-1]+1):
                continue
            elif(i >= 1 and nums[i] is not nums[i-1] + 1):
                return nums[i-1] + 1
              
        return nums[len(nums) - 1] + 1