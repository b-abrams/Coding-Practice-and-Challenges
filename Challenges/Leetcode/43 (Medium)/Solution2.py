# Breeland Abrams
# Leetcode 43: Multiply Strings
# Python 2 Solution


class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        nums = {"0": 0, "1": 1, "2": 2, "3": 3, "4": 4,
                "5": 5, "6": 6, "7": 7, "8": 8, "9": 9}
        first = 0
        second = 0

        i = len(num1)-1
        j = len(num2)-1

        for x in num1:
            first += (nums[x] * 10**i)
            i -= 1

        for y in num2:
            second += (nums[y] * 10**j)
            j -= 1

        return str(first * second)
