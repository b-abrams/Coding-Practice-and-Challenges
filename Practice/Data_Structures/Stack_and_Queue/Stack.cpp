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

class Stack
{
public:
  Node *top;
  Stack()
  {
    this->top = nullptr;
  }

  void push(unsigned int val)
  {
    if (top == nullptr)
    {
      top = new Node(val);
    }
    else
    {
      Node *temp = new Node(val);
      temp->next = top;
      top = temp;
    }
  }

  int pop()
  {
    if (top == nullptr)
    {
      std::cout << "Stack is empty" << std::endl;
      return -1;
    }
    else
    {
      Node *toDelete = top;
      int value = toDelete->val;
      top = top->next;
      std::cout << "Value popped: " << value << std::endl;
      free(toDelete);
      return value;
    }
  }

  void peek()
  {
    if (top == nullptr)
    {
      std::cout << "Stack is empty" << std::endl;
    }
    else
    {
      std::cout << top->val << std::endl;
    }
  }
};

int main()
{

  Stack *s = new Stack();
  s->peek();
  s->push(2);
  s->peek();
  s->push(3);
  s->peek();
  s->push(1);
  s->peek();
  s->pop();
  s->peek();

  return 0;
}