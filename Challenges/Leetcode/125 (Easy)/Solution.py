# Breeland Abrams
# Leetcode 125: Valid Palendrome
class Solution:
    def isPalindrome(self, s: str) -> bool:
        right = len(s) - 1 
        for left in range(int(len(s)/2)):
            if(not s[left].isalpha() and not s[left].isdigit()):
                continue
            while(not s[right].isalpha() and not s[right].isdigit()):
                right -= 1
            if(not s[left].lower() == s[right].lower()):
                return False
            else:
                right -= 1
        return True