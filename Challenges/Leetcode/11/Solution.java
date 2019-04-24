// Breeland Abrams 
// Leetcode #11: Container with Most Water
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, i = 0, j = height.length-1;
        while(i < j){
            maxArea = Math.max(Math.min(height[i], height[j]) * (j-i), maxArea);
            if(height[i] > height[j]) j--;
            else i++; 
        }
        return maxArea;
    }
}