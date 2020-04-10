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
public class Medianoftwoarray {

    public Medianoftwoarray() {
    }
    
    
    public double findMedian(int[] nums1,int[] nums2)
    {
        int len1=nums1.length,len2=nums2.length,mid=(len1+len2+1)/2;
        
        int l1=0,r1=mid,l2,r2;
        int mid1 = (l1+r1)/2;
        int mid2 = mid-mid1;
        while(true)
        {
            if(nums1[mid1] > nums2[mid2])
            {
                if(nums1[mid1] > nums2[mid2+1])
                {
                    System.out.println("You are lucky");
                    break;
                }
                else
                {
                    System.out.println(mid1 + " if "+mid2);
                    mid1--;
                    mid2++;
                }
            }
            else
            {
                if(nums1[mid1] <= nums2[mid2+1])
                {
                    System.out.println("You are lucky");
                    break;
                }
                else
                {
                    
                    System.out.println(mid1 + " else "+mid2);
                    mid1++;
                    mid2--;
                }
                
                
                
            }

        }
        
        
        
    return 10.1;    
    }
    public static void main(String args[])
    {
        Medianoftwoarray m = new Medianoftwoarray();
        int nums1[]={1,4,8,12};
        int nums2[]={3,5,6,34};
        //m.findMedian(n1,n2);
        int len1=nums1.length,len2=nums2.length,mid=(len1+len2+1)/2;
        
        int l1=0,r1=mid,l2,r2;
        int mid1 = (l1+r1)/2;
        int mid2 = mid-mid1;
        while(true)
        {
            if(nums1[mid1-1] > nums2[mid2-1])
            {
                 System.out.println(mid1 + " mmif "+mid2);
                   
                if(nums1[mid1-1] > nums2[mid2+1-1])
                {
                    System.out.println("You are lucky"+nums1[mid1-1]);
                    break;
                }
                else
                {
                    System.out.println(mid1-1 + " if "+(mid2-1));
                    mid1--;
                    mid2++;
                }
            }
            else
            {
                 System.out.println(mid1-1 + " if "+(mid2-1));
                   
                if(nums1[mid1-1] <= nums2[mid2+1-1])
                {
                    System.out.println("You are lucky " + nums2[mid2-1]);
                    break;
                }
                else
                {
                    
                    System.out.println(mid1-1 + " else "+(mid2-1));
                    mid1++;
                    mid2--;
                }
                
                
                
            }

        }
        
        
        
        
    }
    
}
