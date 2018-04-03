// Given an empty ocean of water (NxN matrix of 0s):

// 0000
// 0000
// 0000
// 0000
// Implement a function that puts a land 1 into the given cell and returns a resulting number of islands in the ocean. Adjacent 1s form a single island, i.e.

// fun putLand(row: Int, col: Int): Int

// putLand(0,0) // returns 1, new island
// 1000
// 0000
// 0000
// 0000

// putLand(1,1) // returns 2, new island
// 1000
// 0100
// 0000
// 0000

// putLand(1,0) // returns 1, previous islands now form a single one
// 1000
// 1101
// 0011
// 0110

import java.io.*;
import java.util.*;



class Solution {
    static int N = 4;
    static int ocean[][] = new int[4][4];  
    
     public static boolean isValid(int i, int j, boolean visited[][]){
         
         return ((i>=0) && (i<N) && (j>=0) && (j<N) && (ocean[i][j]==1) && (!visited[i][j]));
     }
    
    
     public static void findNumOfIslandsR(int i, int j,boolean visited[][]){
        
        
        visited[i][j] = true;

        if(isValid( i-1,  j, visited))
            findNumOfIslandsR(i-1,j,visited);
        if(isValid( i+1,  j,  visited))
            findNumOfIslandsR(i+1,j,visited);
        if(isValid( i,  j-1,  visited))
            findNumOfIslandsR(i,j-1,visited);
        if(isValid( i,  j+1,  visited))
            findNumOfIslandsR(i,j+1,visited);
    }
    
    public static int findNumOfIslands(){
        boolean visited[][] = new boolean[N][N];
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                
                //System.out.println(i + ":"+ j);
                if((ocean[i][j]==1)&&(!visited[i][j])){
                   
                    findNumOfIslandsR(i,j,visited);
                    count++;
                }
            }
        } 
         
        
        return count;
    }
    
    public static int addToOcean(int i, int j){
     ocean[i][j] = 1;
     
     return findNumOfIslands();
    }
    
  public static void main(String[] args) {
                                
    System.out.println(addToOcean(0,0));
    System.out.println(addToOcean(0,1));
    System.out.println(addToOcean(1,0));
    
    System.out.println(addToOcean(3,3));
  }
}

 
    
