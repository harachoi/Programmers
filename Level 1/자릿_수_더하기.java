public class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = String.valueOf(n);
        String[] sp = str.split("");
        for (String i : sp) answer += Integer.valueOf(i);

        return answer;
    }
}
