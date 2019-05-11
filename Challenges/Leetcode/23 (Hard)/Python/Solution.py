# Breeland Abrams
# Leetcode 23: Merge K Sorted Lists


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1:ListNode, l2:ListNode) -> ListNode:
        if(l1 is None): return l2
        elif(l2 is None): return l1
        
        if(l1.val <= l2.val):
            combined = ListNode(l1.val)
            l1 = l1.next
        else:
            combined = ListNode(l2.val)
            l2 = l2.next
            
        combinedRunner = combined
        
        while(l1 is not None and l2 is not None):
            if(l1.val <= l2.val):
                combinedRunner.next = ListNode(l1.val)
                l1 = l1.next
                combinedRunner = combinedRunner.next
            else:
                combinedRunner.next = ListNode(l2.val)
                l2 = l2.next
                combinedRunner = combinedRunner.next
                
        if(l1 is not None and l2 is None):
            combinedRunner.next = l1
        elif(l1 is None and l2 is not None):
            combinedRunner.next = l2
        
        return combined
                 
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if(len(lists) == 0): return None
        if(len(lists) == 1): return lists[0]
        while(len(lists) > 1):
            lists.append(self.mergeTwoLists(lists.pop(0), lists.pop(0)))
        return lists[0]