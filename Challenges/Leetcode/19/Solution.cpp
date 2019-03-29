//Breeland Abrams
//Leetcode #19: Remove Nth Node from End of List

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution
{
public:
  ListNode *removeNthFromEnd(ListNode *head, int n)
  {
    ListNode *n0 = head;
    ListNode *n1 = head;
    ListNode *n2 = head;
    for (int i = 1; i < n; i++)
    {
      n2 = n2->next;
    }
    while (n2->next != NULL)
    {
      if (n0->next == n1)
      {
        n0 = n0->next;
      }
      n1 = n1->next;
      n2 = n2->next;
    }
    if (n0 == n1 && n1 == n2)
    {
      head = NULL;
      delete n0;
    }
    else if (n0 == n1 && n0->next != n2)
    {
      head = n0->next;
      delete n0;
    }
    else if (n0 == n1)
    {
      head = n2;
      delete n0;
    }
    else if (n1->next == NULL)
    {
      n0->next = NULL;
      delete n1;
    }
    else
    {
      n0->next = n1->next;
      delete n1;
    }
    return head;
  }
};