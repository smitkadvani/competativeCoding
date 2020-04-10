
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
        
         
         
         
     
    public static void main(String[] args) {
        
        flip("010");
        
    }
    
}
