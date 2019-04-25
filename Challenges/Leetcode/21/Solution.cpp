/*
  Breeland Abrams
  Leetcode #21 Merge Two Sorted Lists
/*
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
  ListNode *mergeTwoLists(ListNode *l1, ListNode *l2)
  {
    if (l1 == NULL)
      return l2;
    if (l2 == NULL)
      return l1;

    ListNode *r1 = l1;
    ListNode *r2 = l2;
    ListNode *r3;
    ListNode *start;

    if (l1->val <= l2->val)
    {
      start = new ListNode(l1->val);
      r3 = start;
      r1 = r1->next;
    }
    else
    {
      start = new ListNode(l2->val);
      r3 = start;
      r2 = r2->next;
    }

    while (r1 != NULL || r2 != NULL)
    {
      if (r1 == NULL)
      {
        r3->next = r2;
        break;
      }
      if (r2 == NULL)
      {
        r3->next = r1;
        break;
      }

      if (r1->val <= r2->val)
      {
        r3->next = new ListNode(r1->val);
        r3 = r3->next;
        r1 = r1->next;
      }
      else
      {
        r3->next = new ListNode(r2->val);
        r3 = r3->next;
        r2 = r2->next;
      }
    }

    return start;
  }
};