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
public class whoseTurn {
    
    public static boolean whoseTurnChess(String p)
    {
        String []moves = p.split(";");
        
        ArrayList<String> wh1 = new ArrayList<String>();
        ArrayList<String> wh2 = new ArrayList<String>();
        ArrayList<String> bk1 = new ArrayList<String>();
        ArrayList<String> bk2 = new ArrayList<String>();
        
        
        wh1.add("a3");
        wh1.add("c3");
        wh1.add("d2");
        wh2.add("f3");
        wh2.add("h3");
        wh2.add("e2");
        
        bk1.add("a6");
        bk1.add("c6");
        bk1.add("d7");
        bk2.add("f6");
        bk2.add("h6");
        wh2.add("e2");
        int count=0;
        for(int i=0;i<moves.length;i++)
        {
            if( bk1.contains(moves[i]) || bk2.contains(moves[i]))
            {
                count--;
            }
            else if(wh1.contains(moves[i]) || wh2.contains(moves[i]))
            {
                count++;
            }
            else
            {
                
            }
        }
        //System.out.println(" "+ count);
        if(count > 0)
            return false;
        else 
            return true;
        
        
    }
    
    public static void main(String[] args) {
        System.out.println(whoseTurnChess("b1;g1;b8;g8"));
    }
    
}
