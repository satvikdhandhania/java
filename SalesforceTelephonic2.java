/*
Salesforce technical screen 2
Implement a generic API for a linkedList. Discussion turned to a doubly linked list with multiple methods.
Author Satvik Dhandhania Date 04/03/18
*/
public class DoubleLinkedList {
    
    Node head = null;
    Node rear = null;
    int size = 0;
    class Node {
        int val;
        Node prev,next;
        
        Node(int i){
           this.val = i;
           this.prev = null;
           this.next = null;
        }
    }
    
    public boolean add(int val){
        Node newNode = new Node(val);
        
        newNode.next = head;
        newNode.prev = null;
        
        if(head!=null){
            head.prev = newNode;
        } else {
            rear = newNode;
        }
        head = newNode;
        size++;
        return true;
    }
    
    
    
    
    public boolean addAtEnd(int val){
        Node newNode = new Node(val);
        if(rear == null){
            head = newNode;
        } else {
        rear.next = newNode;
        newNode.prev = rear;
        }
        rear = newNode;
        size++;
        return true; 
    }
    
    
    
    public boolean add(int index, int val){
           Node temp = head;
           int i = 0;
           if((index < 0)|| (index>(size+1))) return false;
           while(i<index){
               temp = temp.next;
           }
           Node newNode = new Node(val);
           Node next = temp.next; 
          if(index == 0){
              add(val);
          } else if(index == size){
             addAtEnd(val);
          } else 
          {
              temp.next = newNode;
              newNode.prev = temp;
              newNode.next = next;
              next.prev = newNode;
          }
          size++;
           
    }
    
    
    public void printTraverse();
    public boolean delete(int val);
    public boolean deleteFromEnd(int val);
    public boolean deleteIndex(int val);
    public boolean reverse(){
        Node prev = null;
        Node cur = head;
        rear = head; 
        
        while(cur!=null){
            prev = cur.prev;
            cur.prev = cur.next;
            cur.next = prev;
            cur = cur.prev;
        }
    
        if(prev!=null){
          head = prev;
        }
    
    }
    public boolean clear();
    
    
    
    
    
    

}