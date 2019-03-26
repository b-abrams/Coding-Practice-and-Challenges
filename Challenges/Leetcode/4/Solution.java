
//Breeland Abrams
//Leetcode #4: Median of Two Sorted Arrays

import java.util.Arrays;

class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] nums3 = makeNewSortedArray(nums1, nums2);
    if (nums3.length % 2 == 0) {
      return ((double) (nums3[nums3.length / 2 - 1] + (double) nums3[nums3.length / 2]) / 2);
    }
    return nums3[(int) Math.floor(nums3.length / 2)];
  }

  public int[] makeNewSortedArray(int[] n1, int[] n2) {
    if (n1.length == 0) {
      return n2;
    } else if (n2.length == 0) {
      return n1;
    }
    int[] mixedArray = new int[n1.length + n2.length];
    int current1 = 0;
    int current2 = 0;
    for (int i = 0; i < mixedArray.length; i++) {
      if (current1 >= n1.length) {
        mixedArray[i] = n2[current2];
        current2 += 1;
      } else if (current2 >= n2.length) {
        mixedArray[i] = n1[current1];
        current1 += 1;
      } else {
        mixedArray[i] = Math.min(n1[current1], n2[current2]);
        if (mixedArray[i] == n1[current1]) {
          current1 += 1;
        } else {
          current2 += 1;
        }
      }

    }
    return mixedArray;
  }

}