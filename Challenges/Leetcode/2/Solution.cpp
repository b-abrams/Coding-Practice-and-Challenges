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
  ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
  {

    ListNode *solution = new ListNode(0);
    int carry = 0;
    ListNode *solPtr = solution;

    while (l1 != NULL || l2 != NULL)
    {
      ListNode *temp = new ListNode(0);
      if (l1 != NULL && l2 != NULL)
      {
        int current = l1->val + l2->val + carry;
        if (current >= 10)
        {
          carry = 1;
          temp->val = current % 10;
          solution->next = temp;
          solution = solution->next;
        }
        else
        {
          carry = 0;
          temp->val = current;
          solution->next = temp;
          solution = solution->next;
        }
        l1 = l1->next;
        l2 = l2->next;
      }
      else if (l1 != NULL && l2 == NULL)
      {
        int current = l1->val + carry;
        if (current >= 10)
        {
          carry = 1;
          temp->val = current % 10;
          solution->next = temp;
          solution = solution->next;
        }
        else
        {
          carry = 0;
          temp->val = current;
          solution->next = temp;
          solution = solution->next;
        }
        l1 = l1->next;
      }

      else if (l1 == NULL && l2 != NULL)
      {
        int current = l2->val + carry;
        if (current >= 10)
        {
          carry = 1;
          temp->val = current % 10;
          solution->next = temp;
          solution = solution->next;
        }
        else
        {
          carry = 0;
          temp->val = current;
          solution->next = temp;
          solution = solution->next;
        }
        l2 = l2->next;
      }
    }

    if (carry == 1)
    {
      solution->next = new ListNode(1);
    }

    solution = solPtr;
    solPtr = solPtr->next;
    delete solution;
    return solPtr;
  }
};