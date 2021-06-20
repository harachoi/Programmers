class Solution {
     public int solution(int n) {
        int answer = 1;
        for (int i = 1; i <= n; i++) {
            int count = i;
            for (int j = i + 1; j <= n; j++) {
                count += j;
                if (count > n) {
                    break;
                } else if (count == n) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
