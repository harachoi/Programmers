import java.util.*;

class Solution {
    int solution(int[][] land) {
        int  max = 0;
        int[][] dp = new int[land.length][4];
        for (int i = 0; i < 4; i++ ) {
            dp[0][i] = land[0][i];
        }

        for (int i = 0; i < land.length - 1; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (dp[i + 1][k] == 0) dp[i+1][k] = land[i + 1][k];
                    if (j != k && dp[i][j] + land[i+ 1][k] > dp[i + 1][k]) {
                        dp[i + 1][k] = dp[i][j] + land[i+ 1][k];
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) max = Math.max(max, dp[land.length - 1][i]);
        return max;
    }
}
