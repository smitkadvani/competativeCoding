/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.



 */

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/
package problems;

import static java.lang.Integer.min;

/**
 *
 * @author user
 */
public class MinDistance {
    int arr[][];
    public static int calculatePath(int [][]grid,int m,int n)
    {
        
        if(m==0 && n==0)
        {
            return grid[m][n];
        }
        if(m==0)
        {
            int sum=0,i=0;
            for(i=0;i<n;i++)
            {
                sum+=grid[m][i];
            }
            return sum+grid[m][i];
        }
        
        if(n==0)
        {
            int sum=0,i;
            for(i=0;i<m;i++)
            {
                sum+=grid[i][n];
            }
            return sum+grid[i][n];
        }
        return grid[m][n]+min(calculatePath(grid, m, n-1),calculatePath(grid, m-1, n));
    }
    public static int minPathSum1(int [][] grid )
    {
        
        int n,m = grid.length;
        n = grid[0].length;
        m--;
        n--;
        MinDistance mm = new MinDistance(m, n);
        return mm.calculatePath1(grid, m, n);
    }
   
    public MinDistance(int m,int n)
    {
        arr = new int [m+1][n+1];
        
        for(int i=0;i<m+1;i++)
        {
            for(int j=0;j<n+1;j++)
            {
                arr[i][j]=Integer.MAX_VALUE;
            }
        }
        
    }
     
    public int calculatePath1(int [][]grid,int m,int n)
    {
        if(arr[m][n]==Integer.MAX_VALUE)
            return arr[m][n];
        if(m==0 && n==0)
        {
            arr[m][n]  = grid[m][n];
            return grid[m][n];
        }
        if(m==0)
        {
            int sum=0,i=0;
            for(i=0;i<n;i++)
            {
                sum+=grid[m][i];
            }
            arr[m][i] = sum;
            return sum+grid[m][i];
        }
        
        if(n==0)
        {
            int sum=0,i;
            for(i=0;i<m;i++)
            {
                sum+=grid[i][n];
            }
            arr[i][n] = sum;
            return sum+grid[i][n];
        }
        
        arr[m][n] = grid[m][n]+min(calculatePath1(grid, m, n-1),calculatePath1(grid, m-1, n));
        return arr[m][n];
    }
    
    public static int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        System.out.println("" +m+ " "+n);
        int sol[][] = new int [m][n];
        int i=m-1;
        int j=n-1;
        int temp=0;
        m--;
        n--;
        sol[i][j] = grid[i][j];
        //System.out.println("Broken " + i + " "+j);
        while(true)
        {
          //  System.out.println("1Broken " + i + " "+j);
            if((i-1)<0 && (j-1) <0)
            {   
            //    System.out.println("Broken " + i + " "+j);
                break;
            }
            if(i-1>=0)
            {
                sol[i-1][n] = sol[i][n] + grid[i-1][n];
                System.out.println(" " + sol[i-1][n] + " " + (i-1) + " " + n);
            }
            
            
            sol[i-1][n] = sol[i][n] + grid[i-1][n];
            if(j-1>=0)
            {
                sol[m][j-1] = sol[m][j] + grid[m][j-1];
                System.out.println(" " + sol[m][j-1] + " " + (m) + " " + (j-1));
            }
            int ii=0;
            if(i+1>=m)
            {
            while(n-ii>i)
            {
                System.out.println(n+ "bbb " + ii + " "+i);
                sol[i-1][n-ii] = grid[i-1][n-ii] + min(sol[i-1+1][n-ii],sol[i-1][n-ii+1]);
                sol[m-ii][j-1] = grid[m-ii][j-1] + min(sol[m-ii+1][j-1],sol[m-ii][j-1+1]);
                System.out.println(" " + sol[i-1][n-ii]);
                System.out.println(" " + sol[m-ii][j-1]);
                ii++;
            }
            }
           // System.out.println("i+1" + i+1);
            if(i<m)
            {
                sol[i+1][j] = min(sol[(i+1)-1][j],sol[i+1][j-1]) + grid[i+1][j];
                    System.out.println(" " + sol[i][j] + " " + (i) + " " + (j));
            }
            if(j<n)
            {
                sol[i][j+1] = min(sol[i][(j+1)-1],sol[i-1][j+1]) + grid[i][j+1];
                    System.out.println(" " + sol[i][j] + " " + (i) + " " + (j));
            }
            if(i-1 >= 0 && j-1 >= 0)
            {
                sol[i-1][j-1] = min(sol[i][j-1],sol[i-1][j])+grid[i-1][j-1];
                System.out.println(" " + sol[i-1][j-1] + " " + (i-1) + " " + (j-1));
            
            }   
            i--;
            j--;
            
        }
        return sol[0][0];
    }
    public static void main(String[] args) {
        int grid[][]={
     {3,8,6,0,5,9,9,6,3,4,0,5,7,3,9,3},{0,9,2,5,5,4,9,1,4,6,9,5,6,7,3,2},{8,2,2,3,3,3,1,6,9,1,1,6,6,2,1,9},{1,3,6,9,9,5,0,3,4,9,1,0,9,6,2,7},{8,6,2,2,1,3,0,0,7,2,7,5,4,8,4,8},{4,1,9,5,8,9,9,2,0,2,5,1,8,7,0,9},{6,2,1,7,8,1,8,5,5,7,0,2,5,7,2,1},{8,1,7,6,2,8,1,2,2,6,4,0,5,4,1,3},{9,2,1,7,6,1,4,3,8,6,5,5,3,9,7,3},{0,6,0,2,4,3,7,6,1,3,8,6,9,0,0,8},{4,3,7,2,4,3,6,4,0,3,9,5,3,6,9,3},{2,1,8,8,4,5,6,5,8,7,3,7,7,5,8,3},{0,7,6,6,1,2,0,3,5,0,8,0,8,7,4,3},{0,4,3,4,9,0,1,9,7,7,8,6,4,6,9,5},{6,5,1,9,9,2,2,7,4,2,7,2,2,3,7,2},{7,1,9,6,1,2,7,0,9,6,6,4,4,5,1,0},{3,4,9,2,8,3,1,2,6,9,7,0,2,4,2,0},{5,1,8,8,4,6,8,5,2,4,1,6,2,2,9,7}}
        ;         
        System.out.println("" +minPathSum1(grid));
    }
}
    