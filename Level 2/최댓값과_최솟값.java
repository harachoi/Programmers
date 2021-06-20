import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String tmp = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                tmp += s.charAt(i);

            } else if (s.charAt(i) != ' ') {
                tmp += s.charAt(i);
                if (i == s.length() - 1) {
                    int a = Integer.parseInt(tmp);
                    if (a > max) {
                        max = a;
                    }
                    if (a < min) {
                        min = a;
                    }
                    tmp = "";
                }
            } else {
                int a = Integer.parseInt(tmp);
                if (a > max) {
                    max = a;
                }
                if (a < min) {
                    min = a;
                }
                tmp = "";
            }
        }
        answer += String.valueOf(min);
        answer += " ";
        answer += String.valueOf(max);
        return answer;
    }
}
