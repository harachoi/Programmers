class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        StringBuilder sb = new StringBuilder();
        while (!s.equals("1")) {
            sb = new StringBuilder();
            answer[0]++;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') answer[1]++;
                else sb.append("1");
            }
            if (sb.toString().equals("1")) break;
            int div = sb.toString().length();
            sb = new StringBuilder();
            while (true) {
                sb.append(div % 2);
                div = div / 2;
                if (div == 1 || div == 0) {
                    sb.append(div);
                    break;
                }
            }
            s = sb.reverse().toString();
        }
        return answer;
    }
}
