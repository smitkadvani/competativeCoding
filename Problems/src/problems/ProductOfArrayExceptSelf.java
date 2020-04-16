/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;

/**
 *
 * @author user
 */
public class ProductOfArrayExceptSelf {
    
    
    public static int[] Solution(int arr[])
    {
        int len = arr.length;
        
        int left[] = new int[len];
        
        left[0] = 1;
        
        
        for(int i=1;i<len;i++)
        {
            left[i] = arr[i-1]*left[i-1];
            System.out.println(" " + left[i]);
        }
        
        int i=len-1;
        int mul = 1;
        while(i>=0)
        {
            if(i+1 >= len)
                mul=1;
            else
                mul = mul*arr[i+1];
            
            left[i] = left[i]*mul;
            System.out.println(" " + left[i] + " " + mul);
            i--;
        }
        return null;
    }
    public static void main(String[] args) {
        int arr[] = {2,3,4,5};
        Solution(arr);
        
    }
    
}
