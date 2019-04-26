/*
  Breeland Abrams
  Leetcode #27 Remove Element
*/

/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
  let len = nums.length;
  nums.forEach(n => {
    if (n != val) nums.push(n);
  });
  for (let i = 0; i < len; i++) {
    nums.shift();
  }

  return nums.length;
};
