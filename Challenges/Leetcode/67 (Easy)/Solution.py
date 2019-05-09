# Breeland Abrams
# Leetcode 67: Add Binary
class Solution:
    def addBinary(self, a: str, b: str) -> str:     
        return bin(int(a, 2) + int(b, 2))[2:]