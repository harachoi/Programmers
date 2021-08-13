class Solution {
    static int[][] dp;
    public int solution(int m, int n, int[][] puddles) {

        //1. set up dp
        dp = new int[n + 1][m + 1];

        //2. place puddles
        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }

        //3. use dp to find the total path
        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //퍼들일 경우
                if (dp[i][j] == -1) continue;

                //퍼들이 아닌 경우 왼쪽과 위 체크
                if (j - 1 > 0 || i - 1 > 0) {
                    if (dp[i - 1][j] != -1) dp[i][j] += dp[i - 1][j] % 1000000007;
                    if (dp[i][j - 1] != -1) dp[i][j] += dp[i][j - 1] % 1000000007;
                }
            }
        }
        return dp[n][m] % 1000000007;
    }
}
