import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        boolean space = true;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            result.append(space ? s.substring(i,i+1).toUpperCase() : s.charAt(i));
            space = s.charAt(i) == ' ' ? true : false;
        }
        return result.toString();
    }
}
