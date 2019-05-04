"""
  Breeland Abrams
  Leetcode 49: Group Anagrams
""""
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        count = [0] * 26
        m = {}
        
        for i in range(len(strs)):
            for j in range(len(strs[i])):
                count[ord(strs[i][j]) - 97] += 1
            if(m.get("".join(str(count)), None) is not None):
                m["".join(str(count))].append(strs[i])
            else:
                m["".join(str(count))] = [strs[i]]
            count = [0]*26
            
        return [m[_] for _ in m.keys()]
        