"""
Breeland Abrams
Leetcode #7 Reverse Integer

"""
class Solution:
    def reverse(self, x: int) -> int:
        neg  = (x < 0)
        if(neg):
            x *= -1
        asStr = str(x)
        asStr = asStr[::-1]
        asStr.replace("0", "")
        if(neg):
            asStr = "-" + asStr
        if(int(asStr) >= -2**31 and int(asStr) <= 2**31):
            return int(asStr)
        return 0
        