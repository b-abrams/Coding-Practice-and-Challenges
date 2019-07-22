#include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
  int val;
  struct Node *left, *right;

} Node;

Node *createNode(int);
Node *insert(Node *, int);
void inOrder(Node *);

int main()
{

  Node *root = NULL;
  root = insert(root, 4);
  insert(root, 2);
  insert(root, 1);
  insert(root, 3);
  insert(root, 5);
  insert(root, 6);
  inOrder(root);

  return 0;
}

Node *createNode(int value)
{
  Node *temp = (Node *)malloc(sizeof(Node));
  temp->val = value;
  temp->left = temp->right = NULL;
  return temp;
}

Node *insert(Node *parent, int value)
{
  if (parent == NULL)
  {
    return createNode(value);
  }
  else if (parent->val > value)
  {
    parent->left = insert(parent->left, value);
  }
  else
  {
    parent->right = insert(parent->right, value);
  }

  return parent;
}

void inOrder(Node *root)
{
  if (root != NULL)
  {
    inOrder(root->left);
    printf("%i ", root->val);
    inOrder(root->right);
  }
}
