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
public class MaxStoneWeight {
    
    
    public int heapify(int st[],int index)
    {
        int len = st.length;
        int l = ((index+1) << 1)-1;
        int r = l+1;
        int max=index;
        int flag = 0;
        
        if(l<len && st[l] > st[index])
        {
            max = l;
            flag = 1;
        }
        if(r<len && st[r] > st[index])
        {
            max = r;
            flag=1;
        }
        
        if(flag==0)
            return (0);
        
        int temp = st[index];
        st[index] = st[max];
        st[max] = temp;
        heapify(st, max);
        return 0;
        
    }
    public void buildMaxHeap(int st[])
    {
        int len = st.length;
        len = len >> 1;
        

        while(len>=0)
        {
            heapify(st, len);
            len--;
        }
        
    }
    public int lastStoneWeight(int[] stones) {
        
        int len = stones.length;
        buildMaxHeap(stones);
        
        int max1 = stones[0];
        stones[0] = Integer.MIN_VALUE;
        
        int temp = stones[0];
        stones[0] = stones[len-1];
        stones[len-1] = temp;
        
        buildMaxHeap(stones);
        int max2 = stones[0];
        
        temp = stones[0];
        stones[0] = stones[len-2];
        stones[len-2] = temp;
        
        if(max1!=max2)
            stones[len-2] = max1>max2?max1:max2;
        
    }
    
}
