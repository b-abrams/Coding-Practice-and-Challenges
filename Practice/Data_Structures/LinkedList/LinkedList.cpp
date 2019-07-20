#include <iostream>

class Node{
  public:
    int val;
    Node *next;

  
    Node(int val){
      this->val = val;
      this->next = nullptr;
    }

};

class LinkedList{
  public: 
    Node *head;
    int size;
   LinkedList(){
     this->head = nullptr;
     this->size = 0;
   }

   void add(int val){
     if(this->head == nullptr){
       this->head = new Node(val);
     }
     else{
       Node *temp = head;
       while(temp->next != nullptr){
         temp = temp->next;
       }
       temp->next = new Node(val);
     }
     this->size++;
   }

   void remove(int index){
     if(index == 0){
       this->head = head->next;
     }
     else{
       int counter = 0;
       Node *prev = this->head;
       Node *del;
       while(counter < index - 1){
         prev = prev->next;
         counter++;
       }
       del = prev->next;
       prev->next = del->next;
       free(del);
       this->size--; 
     }
   }

   void print(){
     if(head == nullptr){
       std::cout << "List is Empty" << std::endl;
     }
     else{
       Node *temp = head;
       while(temp != nullptr){
         std::cout << temp->val << " ";
         temp = temp->next;
       }
       std::cout << std::endl;
     }
   }
 };

int main(){
  LinkedList *list = new LinkedList();
  list->print();
  list->add(1);
  list->print();
  list->add(2);
  list->print();
  list->add(3);
  list->print();
  list->remove(1);
  list->print();


  return 0;
}