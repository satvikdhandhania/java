/* Author Satvik Dhandhania, April 2017, Thoughworks Telephonic 
 * Given a pair of chemicals that react with each other. Form two groups such that they do not react when one group element is mixed with the other one. 
 *   [1, 2, 3, 4, 5, 6, 7, 8] 
 *    
 *    explosion map
 *    1   [3, 6]
 *    2,  [7, 6]  
 *    3   [1, 4, 5, 8]
 *    4   [3]
 *    5   [3]
 *    6   [1, 2]
 *    7   [2]
 *    8   [3]
 *                               
 *     g1  g2                    
 *      7  2
 *         5
 *      3  8
 *      6  1
 *         4  

 g1     g2    
 1      3, 6 
 2      7
 4
 5
 8
*/     
 boolean makeGroups(HashMap<Integer, ArrayList<Integer>> explosionMap, int[] chemicals){
     
     Set<Integer> g1 = new HashSet<Integer>();
     Set<Integer> g2 = new HashSet<Integer>(); 
     
     for(Map.Entry<Integer,ArrayList<Integer>> entry : explosionMap){
        boolean f1 = false,f2 = false; 
        Integer key =  entry.getKey();
        ArrayList<Integer> values =  entry.getValue();
    
        for(int i=0;i<values.size();i++){
             if(g1.contains(values.get(i))){
                 f1 = true;
             }
             if(g2.contains(values.get(i))){
                 f2 = true;
             }
        }
    
        if(f1 && f2){
          return false;
        }
    
        if(f1 && !f2){
          if(g1.contains(key)) { 
            return false;
          } else {
            g2.add(key);
            for(int j=0;j<values.size();j++){
              g1.add(values.get(i));
            } 
            continue;   
          }
        }
        if(f2 && !f1){
            if(g2.contains(key)){  
              return false;
            } else {
              g1.add(key);
              for(int j=0;j<values.size();j++){
                g2.add(values.get(i));
              }    
              continue;   
            }
        }
        if(!f1 && !f2){
            g1.add(key);
            for(int j=0;j<values.size();j++){
                g2.add(values.get(i));
            }
        }
    return true;
 }
 