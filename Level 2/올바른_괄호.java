import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) stack.push(s.charAt(i));
            else if (s.charAt(i) == ')' && stack.peek() == '(') stack.pop();
            else if (s.charAt(i) == '(') stack.add('(');
            else break;
        }
        return stack.isEmpty() ? true : false;
    }
}
