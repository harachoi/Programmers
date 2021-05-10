import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        answer[0] = 2;
        answer[1] = 1;
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (set.contains(words[i]) || words[i].charAt(0) != words[i-1].charAt(words[i-1].length() - 1) || words[i].length() == 1) {
                return answer;
            }
            answer[0]++;
            if (answer[0] > n) {
                answer[0] = 1;
                answer[1]++;
            }
            set.add(words[i]);
        }
        return new int[]{0,0};
   }
}
