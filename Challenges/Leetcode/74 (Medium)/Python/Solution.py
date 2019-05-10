# Breeland Abrams
# Leetcode 74: Search a 2D Matrix

class Solution:   
    def binarySearch(self, row:List[int], target:int) -> bool:
        if(len(row) <= 2): return (target in row)
        elif(target < row[int((len(row)-1 )/2)]): 
            return self.binarySearch(row[0:int((len(row)-1)/2)+1], target)
        else:
            return self.binarySearch(row[int((len(row)-1)/2):], target)
        
    
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if(len(matrix) == 0): return False
        if(len(matrix) == 1): return self.binarySearch(matrix[0], target)
        
        for i in range(1, len(matrix)):
            if matrix[i][0] > target:
                return self.binarySearch(matrix[i-1], target)
            
        return self.binarySearch(matrix[len(matrix)-1], target)