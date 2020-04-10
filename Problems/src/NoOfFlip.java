/*

Flip
Asked in:  
VMWare
You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

Notes:

Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
For example,

S = 010

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return
*/
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class NoOfFlip {
    
    
    // This is greedy approach to solve this problem
    /* It involves complexity of o(n^2) 
    
    This complexity can be further reduced to linear time using modified version of kadane's algorithms
    
    
    */
    
    // Greedy approach 
    public static int checkFlip(String A,int i,int j)
    {
        StringBuilder str = new StringBuilder(A);
        for(int ii=i;ii<=j;ii++)
        {
            char ch = A.charAt(ii);
            ch = ch=='0'?'1':'0';
            
            str.setCharAt(ii,ch);
            
        }
        return Integer.parseInt(str.toString(),2);
        
    }
     public static ArrayList<Integer> flip(String A){
         
         
         int len = A.length();
         int count_1s=0;
         int n = Integer.parseInt(A,2);
         System.out.println("" + n);
         int max_i=0,max_j=0,temp=Integer.MIN_VALUE;
        
         for(int i=0;i<len;i++)
         {
             for(int j=i;j<len;j++)
             {
                 int sum = checkFlip(A, i, j);
                 
                 if(sum > temp)
                 {  
                     
                     temp = sum;
                     max_i=i;
                     max_j=j;
                 }
             }
             
         }
          
          System.out.println(""+max_i+ " "+max_j);
          return null;
         }
        
         
         
         
     // Using kadane's algorithm
     
     public static ArrayList<Integer> flip_kadane(String A)
             
     {
         
     }
    public static void main(String[] args) {
        
        flip("010");
        
    }
    
}
