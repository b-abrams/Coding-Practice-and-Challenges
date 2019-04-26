# Breeland Abrams
# Leetcode 43: Multiply Strings
# Python 3 Solution


class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        first = 0
        second = 0

        i = len(num1)-1
        j = len(num2)-1

        for x in num1:
            first += (int(x) * 10**i)
            i -= 1

        for y in num2:
            second += (int(y) * 10**j)
            j -= 1

        return str(first * second)
