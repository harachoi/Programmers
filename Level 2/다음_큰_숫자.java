import java.util.*;
class Solution {
    public int solution(int n) {
        int find = -1;
        int one_counter = div(n);
        while (one_counter != find) {
            n++;
            find = div(n);
        }        
        return n;
    }
    public static int div(int n) {
        int one_counter = 0;
        while (n != 0) {
            if (n == 1) {
                one_counter++;
                break;
            } 
            if (n % 2 == 1) {
                one_counter++;
            }
            n /= 2;
        }
        return one_counter;
    }
}
