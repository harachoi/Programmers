import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        String tmp1 = str1;
        String tmp2 = str2;
        ArrayList<String> list = new ArrayList<>();
        int notIn = 0;
        int in = 0;

        tmp1 = str1.toLowerCase();
        tmp2 = str2.toLowerCase();

        for (int i = 0; i < str1.length() - 1; i++) {
            String tmp = String.valueOf(tmp1.charAt(i));
            tmp += String.valueOf(tmp1.charAt(i+1));
            if (tmp.matches("[a-zA-Z]+")) {
                list.add(tmp);
                notIn++;
            }
        }
        for (int i = 0; i < tmp2.length() - 1; i++) {
            String tmp = String.valueOf(tmp2.charAt(i));
            tmp += String.valueOf(tmp2.charAt(i + 1));
            if (tmp.matches("[a-zA-Z]+")) {
                if (list.contains(tmp)) {
                    list.remove(tmp);
                    in++;
                } else {
                    notIn++;
                }
            }
        }

        double div;
        div = (double) in / (double) notIn;

        answer = (int)(div * 65536);
        if (notIn == 0) {
            return 65536;
        }
       
        return answer;
    }
}
