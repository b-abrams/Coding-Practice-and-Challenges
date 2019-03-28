// Breeland Abrams
// Leetcode #29: Divide Two Integers
import java.math.BigInteger;
class Solution {
    public int divide(int dividend, int divisor) {
       BigInteger division = new BigInteger(Integer.toString(dividend)).divide(new BigInteger(Integer.toString(divisor)));
    
        if(division.longValue() < 0){
            if(-(division.longValue()) > Integer.MAX_VALUE) return Integer.MIN_VALUE;
        }
               
        if(division.longValue() > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        
        return division.intValue();
    }
    
}