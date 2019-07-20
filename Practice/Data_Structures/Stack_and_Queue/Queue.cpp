#include <iostream>

class Node
{
public:
  unsigned int val;
  Node *next;
  Node(unsigned int val)
  {
    this->val = val;
    this->next = nullptr;
  }
};

class Queue
{

public:
  Node *head;

  Queue()
  {
    head = nullptr;
  }

  void add(unsigned int value)
  {

    if (head == nullptr)
    {
      head = new Node(value);
    }
    else
    {
      Node *temp = head;
      while (temp->next != nullptr)
      {
        temp = temp->next;
      }
      temp->next = new Node(value);
    }
  }

  int peek()
  {
    if (head == nullptr)
    {
      printf("Queue is empty\n");
      return -1;
    }
    else
    {
      printf("Front of Queue: %i\n ", head->val);
      return head->val;
    }
  }

  int poll()
  {
    if (head == nullptr)
    {
      printf("Queue is empty\n");
      return -1;
    }
    else
    {
      Node *temp = head;
      int poll = temp->val;
      head = head->next;
      if (head == nullptr)
      {
        printf("New Front of Queue: %i\n ", -1);
      }
      else
      {
        printf("New Front of Queue: %i\n ", head->val);
      }
      free(temp);
      return poll;
    }
  }
};

int main()
{
  Queue *q = new Queue();
  q->peek();
  for (int i = 1; i < 4; i++)
  {
    q->add(i);
  }
  q->peek();
  printf("Polled: %i\n", q->poll());
  return 0;
}