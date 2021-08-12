import java.io.*;
import java.util.*;

class Solution {
    static int n, target, answer;

    public int solution(int N, int number) {
        n = N;
        target = number;
        answer = Integer.MAX_VALUE;
        dfs(0, 0);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    static void dfs(int count, int prev) {
        if (count > 8) {
            answer = -1;
            return;
        }

        if (prev == target) {
            answer = Math.min(answer, count);
            return;
        }

        int tmpN = n;
        for (int i = 0; i < 8 - count; i++) {
            int newSum = count + i + 1;
            dfs(newSum, prev + tmpN);
            dfs(newSum, prev - tmpN);
            dfs(newSum, prev / tmpN);
            dfs(newSum, prev * tmpN);

            tmpN = tmpN * 10 + n;
        }
    }
}
