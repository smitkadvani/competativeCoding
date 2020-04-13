package problems;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */

/*
  Backspace String Compare
Solution
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
*/
public class CompareBackspaceString {
    
    
    public static boolean Cmp(String s1,String s2)
    {
        
        
        StringBuilder b1 = new StringBuilder();
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)=='#')
            {
                if(b1.length()==0)
                    continue;
                
                b1.deleteCharAt(b1.length()-1);
                        
            }
            else
            {
                b1.append(s1.charAt(i));
            }
        }
        StringBuilder b2 = new StringBuilder();
        for(int i=0;i<s2.length();i++)
        {
            if(s2.charAt(i)=='#')
            {
                if(b2.length()==0)
                    continue;
                
                b2.deleteCharAt(b2.length()-1);
                        
            }
            else
            {
                b2.append(s2.charAt(i));
            }
        }
        boolean rep = b1.toString().equals(b2.toString());
        return rep;
    }
    public static void main(String[] args) {
        System.out.println(Cmp("##I#Ta", "###s#T"));
    }
    
}
