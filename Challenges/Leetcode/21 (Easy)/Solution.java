/*
  Breeland Abrams
  Leetcode #21 Merge Two Sorted Lists
*/
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;

    ListNode r1 = l1, r2 = l2, r3, start;

    if (l1.val <= l2.val) {
      start = new ListNode(l1.val);
      r3 = start;
      r1 = r1.next;
    } else {
      start = new ListNode(l2.val);
      r3 = start;
      r2 = r2.next;
    }

    while (r1 != null || r2 != null) {
      if (r1 == null) {
        r3.next = r2;
        break;
      }
      if (r2 == null) {
        r3.next = r1;
        break;
      }

      if (r1.val <= r2.val) {
        r3.next = new ListNode(r1.val);
        r3 = r3.next;
        r1 = r1.next;
      } else {
        r3.next = new ListNode(r2.val);
        r3 = r3.next;
        r2 = r2.next;
      }

    }

    r1 = null;
    r2 = null;
    r3 = null;
    return start;
  }
}