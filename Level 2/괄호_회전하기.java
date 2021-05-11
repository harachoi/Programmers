import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) deque.addLast(s.charAt(i));

        for (int i = 0; i < s.length(); i++) {
            Character tmp = deque.pollFirst();
            deque.addLast(tmp);
            if (check(deque)) answer++;
        }
        return answer;
    }
    public static boolean check(Deque<Character> de) {
        Stack<Character> stack = new Stack<>();
        Deque<Character> deque = new ArrayDeque<>(de);
        int length = deque.size();
        for (int i = 0; i < length; i++) {
            Character ch = deque.pollFirst();
            if (!stack.isEmpty()) {
                if (stack.peek().equals('(') && ch == ')') stack.pop();
                else if (stack.peek().equals('{') && ch == '}') stack.pop();
                else if (stack.peek().equals('[') && ch == ']') stack.pop();
                else stack.push(ch);
            } else stack.push(ch);
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}
