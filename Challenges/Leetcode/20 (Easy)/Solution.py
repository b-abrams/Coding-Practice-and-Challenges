# Breeland Abrams
# Leetcode 20: Valid Parenthesis
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for i in range(len(s)):
            if(not stack or s[i] == "(" or s[i] == "{" or s[i] == "["): 
                stack.append(s[i])   
            elif((s[i] == ')' and stack[len(stack) - 1] == "(") or (s[i] == '}' and stack[len(stack) - 1] == "{") or (s[i] == ']' and stack[len(stack) - 1] == "[")):
                stack.pop()
            else:
                stack.append(s[i])
            
        return not stack
            