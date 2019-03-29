//Breeland Abrams
//Leetcode #19: Remove Nth Node From End of List

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode n0 = head, n1 = head, n2 = head;
    for (int i = 1; i < n; i++) {
      n2 = n2.next;
    }
    while (n2.next != null) {
      if (n0.next == n1) {
        n0 = n0.next;
      }
      n1 = n1.next;
      n2 = n2.next;
    }

    if (n0 == n1 && n1 == n2) {
      head = null;
    } else if (n0 == n1 && n0.next != n2) {
      head = n0.next;
    } else if (n0 == n1) {
      head = n2;
    } else if (n1.next == null) {
      n0.next = null;
    } else {
      n0.next = n1.next;
    }

    return head;

  }
}