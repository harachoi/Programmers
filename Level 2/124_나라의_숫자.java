import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        String[] index = {"4", "1", "2"};
        
        while (n > 0) {
            int remainder = n % 3;
            n = n / 3;
            if (remainder == 0) n--;
            answer = index[remainder] + answer;
        }
        return answer;
    }
}
