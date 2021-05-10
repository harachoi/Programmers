import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for(int i = 0; i < scoville.length; i++) pq.add(scoville[i]);
        if (pq.peek() >= K) return 0;
        while (pq.size() > 1) {
            pq.add(pq.poll() + pq.poll() * 2);
            count++;
            if (pq.peek() >= K) return count;
        }
        return -1;
    }
}
