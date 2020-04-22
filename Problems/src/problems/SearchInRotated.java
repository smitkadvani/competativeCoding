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
public class SearchInRotated {

    
    
    public static void main(String[] args) {
        SearchInRotated nn = new SearchInRotated();
        int aa[]={3,5},target=5;
        System.out.println(nn.search(aa, target));
    }
    public int search(int[] nums, int target) {
        
        int len = nums.length;
        
        int jump,base=-1;
        int index1,index2;
        int freq=0,lind=Integer.MAX_VALUE;
        if(len==1)
        {
            if(nums[0]==target)
                return 0;
            else
                return -1;
        }
        for(int i=0;i<len ;i++)
        {
            jump =(int) Math.pow(2, i);
            index1 = jump + base;
            jump = (int)Math.pow(2, i+1);
            index2 = base+jump;
            freq++;
            if(index2==(len-1) && nums[index1] < nums[index2])
            {
                    lind=0;
                    break;
                }
            if(index2>=len)
            {
                
                base=index1-1;
                i=-1;    
                continue;
             }        
            if(nums[index1] > nums[index2])
            {
                base=index1-1;
                i=-1;
                
                if(freq==1)
                {
                    lind=index2;
                    break;
                }
                freq=0;
            }
            
        }
        //System.out.println("" + lind);
        
        
        int beg=0,end=len;
        int mid = (beg+end)/2;
        
        for(int i=1;i<=len;i*=2)
        {
           // System.out.println(" " +i);
            if(nums[(mid+lind)%len] == target)
                return (mid+lind)%len;
               //System.out.println("Comparison< " + nums[(mid+lind)%len] );
            if(target < nums[(mid+lind)%len])
            {
                //System.out.println("Comparison< " + nums[(mid+lind)%len] );
                end = mid;
            }
            if(target > nums[(mid+lind)%len])
            {
                beg = mid;
                //System.out.println("Comparison>" + nums[(mid+lind)%len] );
                
            }
            mid = (beg+end)/2;
        }
      return -1;  
    }
    
}
