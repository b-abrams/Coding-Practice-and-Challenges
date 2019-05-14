# Breeland Abrams
# Leetcode 61: Rotate List

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        size = 0
        ptr = head
        while(ptr is not None):
            size += 1
            ptr = ptr.next
        if(size <= 1): return head
        
        rotations = k % size
        if(rotations == 0): return head
        ptr = head
        count = size - rotations
        
        while(count > 1):
            ptr = ptr.next
            count -= 1
        
        end = ptr
        while(end.next is not None):
            end = end.next
        end.next = head
        head = ptr.next
        ptr.next = None
        
        return head