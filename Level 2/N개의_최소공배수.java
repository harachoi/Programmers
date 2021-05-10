class Solution {
    public int solution(int[] arr) {
        int tmp = 1;
        int count = 0;
        while (true) {
            count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (tmp % arr[i] != 0) break;
                count++;
            }
            if (count == arr.length) return tmp;
            tmp++;
        }
    }
}
