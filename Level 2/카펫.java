class Solution {
    public int[] solution(int brown, int yellow) {
        int tmp = 1;
        int big = 0;
        while (true) {
            if (yellow % tmp == 0) {
                if (tmp > yellow / tmp) big = tmp;
                else big = yellow/ tmp;
                if (brown == ((big + 2) * 2 + ((yellow/big) * 2))) {
                    return new int[]{big + 2, yellow / big + 2};
                }
            }
            tmp++;
        }
    }
}
