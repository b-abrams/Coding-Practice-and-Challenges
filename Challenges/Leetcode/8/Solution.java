//Breeland Abrams
//LeetCode #8: String to Integer (atoi)
import java.lang.StringBuilder;
class Solution {
    
    public String process(char[] c){
        StringBuilder str = new StringBuilder();
        boolean nonLeadZero = false;
        for(int i = 0; i < c.length; i++){
            if(i == 0){
                if(c[i] == '+' || c[i] == '-'){
                    str.append(c[i]);
                    continue;
                }
            }
            if(Character.isDigit(c[i])){
               if(c[i] == '0' && !nonLeadZero){
                   continue;
               } 
               else{
                    nonLeadZero = true;
                    str.append(c[i]);
                }
            }
            else{
                break;
            }
        }
        
        return str.toString();
    }
    
    public int myAtoi(String str) {
        String var = process(str.trim().split(" ")[0].toCharArray());
        if(var.length() == 0) return 0; 
        try{
            return Integer.parseInt(var);
        }
        catch(Exception e){
            try{
                return (int)Double.parseDouble(var);
            }
            catch(Exception f){
                if(var.charAt(0) == '-'){
                    if(var.length() == 1){
                        return 0;
                    }
                    else{
                        if(var.length() > 1 && Character.isDigit(var.charAt(1))){
                            return Integer.MIN_VALUE;
                        } 
                    } 
                }
                else if(var.charAt(0) == '+'){
                    if(var.length() == 1){
                        return 0;
                    }
                    else{
                        if(var.length() > 1 && Character.isDigit(var.charAt(1))){
                            return Integer.MIN_VALUE;
                        } 
                        else if(Character.isDigit(var.charAt(0))){
                            return Integer.MAX_VALUE;
                        }  
                    } 
                    
                }
                else if(Character.isDigit(var.charAt(0))){
                        return Integer.MAX_VALUE;
                }  
                
            }
            
        }
        return 0;    
    }
    
    
}