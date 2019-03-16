import java.util.*;
public class MatchingParenthesis {

    public static void main(String[] args){
        String p = "(((()))()))";
        System.out.print(solution(p));
    }

    public static String solution(String p){
        if(isValid(p)){
            return p;
        }
        return match(p);
    }

    public static boolean isValid(String s){
        if(s.charAt(0) == ')'){
            return false;
        }
        Stack<Character> temp = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(temp.isEmpty()){
                temp.push(s.charAt(i));
            }
            else
            {
                if(s.charAt(i) == ')' && temp.peek() == '('){
                    temp.pop();
                }
                else{
                    temp.push(s.charAt(i));
                }
            }
        }

        return temp.isEmpty();
    }

    public static String match(String s){
        Stack<Character> container = new Stack<Character>();
        int counter = 0;
        char neededOrder = ' ';
        for(int i = 0; i < s.length(); i++) {
            if (container.isEmpty() && s.charAt(i) == '(') {
                container.push(s.charAt(i));
                continue;

            } else if (container.isEmpty() && s.charAt(i) == ')') {
                neededOrder = '(';
                counter += 1;
                continue;
            }
            else if(container.peek() == '(' && s.charAt(i) == '('){
                container.push('(');
                neededOrder = ')';
                counter += 1;
                continue;
            }
            else if(container.peek() == ')' && s.charAt(i) == ')'){
                container.push(')');
                neededOrder = '(';
                counter += 1;
                continue;
            }
            else if(container.peek() == '(' && s.charAt(i) == ')'){
                counter -= 1;
                continue;
            }
            container = addParenthesis(container, neededOrder, counter);
            counter = 0;
        }


            return popStack(container);
    }

    public static String popStack(Stack<Character> s){
        if(s.size() == 1){
            return String.valueOf(s.pop());
        }
        char c = s.pop();
        return String.valueOf(c) + popStack(s);
    }

    public static Stack<Character> addParenthesis(Stack<Character> s, char order, int count){
        if(count >= 0){
            s.push(order);
            return addParenthesis(s, order, count - 1);
        }
        return s;
    }
}
