// Breeland Abrams
// Leetcode #24 Swap Nodes in Pairs

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
  ListNode *swapPairs(ListNode *head)
  {

    if (head == NULL)
      return head;
    if (head->next == NULL)
      return head;
    ListNode *p1 = head;
    ListNode *p2 = head->next;

    ListNode *temp = new ListNode(p2->val);
    temp->next = p1;
    p1->next = p2->next;
    head = temp;
    temp = p2;
    p1 = head;
    p2 = p1->next;
    delete temp;

    ListNode *ctrl = p2;
    p1 = p1->next->next;
    if (p2->next != NULL)
    {
      p2 = p2->next->next;
    }
    else
    {
      p2 = NULL;
    }

    while (p2 != NULL)
    {
      ListNode *temp = new ListNode(p2->val);
      temp->next = p1;
      ctrl->next = temp;
      temp = p2;
      p1 = ctrl->next;
      p2 = ctrl->next->next;
      p2->next = temp->next;
      delete (temp);

      ctrl = p2;
      p1 = p1->next->next;
      if (p2->next != NULL)
      {
        p2 = p2->next->next;
      }
      else
      {
        p2 = NULL;
      }
    }

    return head;
  }
};