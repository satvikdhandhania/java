/* Salesforce Telephonic Interview 1 March 2018 
 * Author Satvik Dhandhania
 * Q1
 */ 
/* Merge K sorted linkedLists */
public Node kMergedList(LinkedList l[]){

Node res = null;
Node backQueue = null;

if(l == null){
    return null;
}

int k = l.length;

if(k==1){
    return l[0];
}

PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Node>(){
    public int compare(Node n1, Node n2){
        return n1.val - n2.val;
    }
});

for(int i=0;i<k;i++){
    if(l[i] == null){
        queue.offer(l[i]);
    }
}

while(!queue.isEmpty()){
    Node n = queue.poll();
    if(res == null){
        res = n;
        backqueue = res;
    } else {
        backqueue.next = n;
        backqueue = n;
    }
    if(n.next != null){
        queue.offer(n.next);
    }
}
return res;

}