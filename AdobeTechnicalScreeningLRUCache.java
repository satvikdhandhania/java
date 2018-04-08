/* 
Class name must be "Main"
Libraries included:
json simple, guava, apache commons lang3, junit, jmock 

Look for O(1) solution mixing hashmap and queues to formulate the cache
https://www.geeksforgeeks.org/lru-cache-implementation/
Implement LRU CACHE Adobe Phone Screen 
Author Satvik Dhandhania Date: 03/20/2018

Bad and generic Implementation of Web Cache
*/
class Main {
        
        class WebPage{ 
           String title,author;
           int  id;  
        }
        
        class Cache{
            
            Queue<Webpage> cache;
            int size;
            int maxSize = 1000;
            
            Cache(){
                cache = new LinkedList<WebPage>();
                size = 0;
            };    
       
            public void addToCache(Webpage webpage){
                if(size < maxSize){ 
                  size++; 
                } else {
                 cache.remove(0);     
                }
                cache.add(webpage); 
            }
            
            public WebPage checkPage(int id){
                for(int i=0;i<size;i++){
                    WebPage webpage = cache.get(i);
                    if(webpage.id == id){
                        cache.remove(i);
                        addToCache(webpage);
                        return webpage;     
                    }
                }   
                return null;       
            }
        
            public WebPage fetch(int id){
                WebPage res = checkPage(id);
                if(res!= null){
                    return res;    
                }
                
                WebPage webpage = fetchWebPage(id);
                addToCache(webpage);
                return webpage;
            }
        }
        
            
        public static void main(String[] args) {
        }    
    }
