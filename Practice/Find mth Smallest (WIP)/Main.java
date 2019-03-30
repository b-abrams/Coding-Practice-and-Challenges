import java.util.Arrays;

class Main {

  public static void main(String[] args) {
    int[] n = { -1, 5, 13, 4, 2, 6, 8, 23, 1 }; // -1, 1, 2, 4, 5, 6, 8, 13, 23
    // All comments after this one are for debugging purposes
    System.out.println(mthMin(n, 5));

  }

  public static int mthMin(int[] nums, int m) {
    int left = 0;
    int right = nums.length - 1;
    int index = (m == 0) ? m : m - 1;
    int pivot = nums[index];

    while (left < right) {
      while (nums[left] < pivot && left < right) {
        // System.out.println("L: " + left);
        left++;
      }
      while (nums[right] > pivot && right > left) {
        // System.out.println("R: " + right);
        right--;
      }
      // System.out.println("Swap : " + nums[left] + ", " + nums[right] + "\nAt: L, "
      // + left + " R, " + right);
      // System.out.println("I = " + index);
      int temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
      if (left == index) {
        index = right;

      } else if (right == index) {
        index = left;
      }

      // System.out.println("I = " + index);
    }

    // System.out.println(index);
    // for (int i : nums) {
    // System.out.print(i + " ");
    // }
    // System.out.print("\n");

    if (index == m - 1) {
      return nums[index];
    } else if (index > m - 1) {
      return mthMin(Arrays.copyOfRange(nums, 0, index), m);
    } else {
      return mthMin(Arrays.copyOfRange(nums, index + 1, (nums.length + 1) - index),
          m - (nums.length - ((nums.length + 1) - (index + 1))));
    }

  }
}