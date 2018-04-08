/* Salesforce Telephonic Interview 1 March 2018 
 * Author Satvik Dhandhania
 * Q2
 */ 
/* Check Binary Tree is BST 
     5  
   3  9<-
  1  6 8  

*/

class Node{
    int val;
    Node left, right;

}



public static void main(String[] args){
    
    checkBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE)

}

public boolean checkBinarySearchTree(Node root, int min, int max){

    if(root == null){
        return true;
    }

    if((root.val < min) || (root.val > max)){
        return false;
    }

    return (checkBinarySearchTree(root.left,min, root.val-1) && checkBinarySearchTree(root.right, root.val+1, max));

} 















