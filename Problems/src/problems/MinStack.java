/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;

import java.util.ArrayList;

/**
 *
 * @author user
 */
class MinStack {

    /** initialize your data structure here. */
    ArrayList<Long> arr;
    long min;
    public MinStack() {
        arr = new ArrayList<Long>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(arr.size()==0)
        {
            min = x;
            
        }
        arr.add((long)x-min);
        if(x<min)
            min = x;
    
    }
    
    public void pop() {
        if(arr.size()>0)
        {
            long temp = arr.get(arr.size()-1);
            if(temp > 0)  
                arr.remove(arr.size()-1);
            else
            {
                min = min - arr.get(arr.size()-1);
                arr.remove(arr.size()-1);
            }
        }
    }
    
    public int top() {
        if(arr.size()>0)
        {
        long temp = arr.get(arr.size()-1);
        if(temp<0)
            return (int)min;
        else
        {
            return (int)(temp+min);
        }}
        else
        {
            return 0;
        }
            
        
    }
    
    public int getMin() {
        return(int)min;
        
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
minStack.push(46);
        System.out.print("null ");
minStack.push(46);
System.out.print("null ");
minStack.push(47);
System.out.print("null ");

        System.out.print(minStack.top()+ " ");
        minStack.pop();
        System.out.print("null ");
        System.out.print(minStack.getMin()+ " ");
        minStack.pop();
        System.out.print("null ");
        System.out.print(minStack.getMin()+ " ");
        
        minStack.pop();
        System.out.print("null ");
minStack.push(47);
System.out.print("null ");

System.out.print(minStack.top()+" ");
        
        System.out.print(minStack.getMin()+ " ");
minStack.push(-48);
System.out.print("null ");
System.out.print(minStack.top()+" ");
        
        System.out.print(minStack.getMin()+ " ");
minStack.pop();
        System.out.print("null ");
        System.out.print(minStack.getMin()+ " ");
 // --> Returns -2.
    }
}
