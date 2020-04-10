


package problems;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.sort;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author user
 */
public class Problems {

    /**
     * @param args the command line arguments
     */
    public static int main(String[] args) {
        
        
        int arr[] = {2,3,4,12,-12,32};
        Arrays.sort(arr);
        int target=0;
        Map <Integer,Integer> map = new HashMap<>();
       for(int i=0;i<arr.length;i++)
       {
           map.put(arr[i],i);
       }
       // System.out.println(map);
       for(int i=0;i<arr.length;i++)
       {
           int c = target-arr[i];
           //System.out.println("" +c );
           for(int j=0;j<arr.length;j++)
           {
               if(map.containsKey(c) && map.get(c)!=i)
               {
                   System.out.println(i + " " + map.get(c));
                   return 0;
               }
           }
       }
        
        return 1;
    }
        
        // TODO code application logic here
    
    
}
